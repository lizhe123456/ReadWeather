package com.readweather.ui.meizi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.readweather.R;
import com.readweather.base.MvpActivity;
import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.MeitusPresenter;
import com.readweather.presenter.meizi.contract.MeitusContract;
import com.readweather.ui.meizi.adapter.GankAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by lizhe on 2017/10/13 0013.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class MzituPictureActivity extends MvpActivity<MeitusPresenter> implements MeitusContract.View {

    public static final String EXTRA_IMAGE_URL = "image_url";
    public static final String EXTRA_IMAGE_TITLE = "image_title";
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.rv_gank)
    RecyclerView rvGank;

    private String url;
    private String title;
    private String baseUsr;
    private String fakeRefer;
    private String realUrl;
    private int currentPage = 1;

    private GankAdapter adapter;
    private  List<Girl> mList;
    protected StaggeredGridLayoutManager layoutManager;
    private static final int SPAN_COUNT = 2;

    public static Intent newIntent(Context context, String url, String desc) {
        Intent intent = new Intent(context, MzituPictureActivity.class);
        intent.putExtra(EXTRA_IMAGE_URL, url);
        intent.putExtra(EXTRA_IMAGE_TITLE, desc);
        return intent;
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_mzitu_picture;
    }


    @Override
    protected void init() {
        super.init();
        url = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        title = getIntent().getStringExtra(EXTRA_IMAGE_TITLE);

        toolbarTitle.setText("图集");
        mList = new ArrayList<>();
        adapter = new GankAdapter(mList,this);

    }

    private void refresh() {
        mPresenter.getMeitus(baseUsr, currentPage);

    }

    private void getMore(int page) {
        baseUsr = url + "/" + page;
        mPresenter.getMeitus(baseUsr,realUrl,fakeRefer);
    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        baseUsr = url + "/" + currentPage;
        fakeRefer = url + "/"; //伪造 refer 破解防盗链
        realUrl = "http://api.caoliyu.cn/meizitu.php?url=%s&refer=%s";// 然后用自己的服务器进行转发

        //瀑布流布局管理器
        layoutManager = new StaggeredGridLayoutManager(SPAN_COUNT,StaggeredGridLayoutManager.VERTICAL);
        //解决瀑布流左右乱跑问题
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        layoutManager.setItemPrefetchEnabled(false);

        rvGank.setLayoutManager(layoutManager);
        rvGank.setAdapter(adapter);

        adapter.setOnItemClickListener(new GankAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, View view) {
                if (!TextUtils.isEmpty(mList.get(position).getLink())) {
                    Intent intent = MzituPictureActivity.newIntent(MzituPictureActivity.this, mList.get(position).getLink(), "");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent();
                    intent.setClass(MzituPictureActivity.this, PhotosActivity.class);
                    intent.putExtra(PhotosActivity.URL, mList.get(position).getUrl());
                    intent.putExtra(PhotosActivity.ID, mList.get(position).getId());
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) MzituPictureActivity.this, view, "shareView");
                    try {
                        ActivityCompat.startActivity(MzituPictureActivity.this, intent, optionsCompat.toBundle());
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        startActivity(intent);
                    }
                }
            }
        });
        loading();
        refresh();
    }


    @Override
    public void stateError() {

    }

    @Override
    public void showMeitu(List<Girl> list) {
        currentPage++;
        if (adapter.getmList() == null || adapter.getmList().size() == 0) {
            adapter.setNewData(list);
        } else {
            adapter.addData(adapter.getmList().size(), list);
        }
    }

    @Override
    public void getMeiziFromServer(int page) {
        getMore(page);
    }
}
