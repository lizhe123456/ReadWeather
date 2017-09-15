package com.readweather.ui.meizi.activity;

import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import com.readweather.R;
import com.readweather.base.MvpActivity;
import com.readweather.model.bean.RealmLikeBean;
import com.readweather.presenter.db.LikePresenter;
import com.readweather.presenter.db.contract.LikeContract;
import com.readweather.utils.GlideuUtil;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by lizhe on 2017/9/15 0015.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class PhotosActivity extends MvpActivity<LikePresenter> implements LikeContract.View {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.collection)
    ImageView collection;
    @BindView(R.id.photoView)
    PhotoView photoView;

    private boolean isCollection;
    PhotoViewAttacher mAttacher;

    @Override
    protected int setLayout() {
        return R.layout.activity_photos;
    }

    @Override
    protected void init() {
        mAttacher = new PhotoViewAttacher(photoView);
        GlideuUtil.loadImageView(getApplicationContext(),getIntent().getStringExtra("img"),photoView);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected void setData() {

    }


    @OnClick({R.id.back, R.id.menu, R.id.share, R.id.collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.menu:
                showPopupMenu(menu);
                break;
            case R.id.share:
                //分享
                break;
            case R.id.collection:
                //收藏

                break;
        }
    }

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        //加载menu布局
        popupMenu.getMenuInflater().inflate(R.menu.photo_menu, popupMenu.getMenu());
        //menu点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.photo_item_0:
                        //保存图片到相册
                        break;
                    case R.id.photo_item_1:
                        //设置为壁纸
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void showContent(List<RealmLikeBean> mList) {

    }

    @Override
    public void stateError() {

    }
}
