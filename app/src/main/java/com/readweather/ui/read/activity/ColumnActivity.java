package com.readweather.ui.read.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.base.MvpBackActivity;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListDetailBean;
import com.readweather.model.bean.read.ThemeNewsDetailBean;
import com.readweather.presenter.read.SectionDetailPresenter;
import com.readweather.presenter.read.contract.SectionDetailContract;
import com.readweather.ui.read.adapter.NewsAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhe on 2017/11/18 0018.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ColumnActivity extends MvpBackActivity<SectionDetailPresenter> implements SectionDetailContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private NewsAdapter mAdapter;
    @Override
    public void stateError() {

    }

    @Override
    public void showContent(SectionListDetailBean bean) {
        tvTitle.setText(bean.getName());
        mAdapter.addFirstDataSet(bean.getStories());
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_column;
    }

    @Override
    protected void setData() {
        Intent intent = getIntent();
        mPresenter.getSectionDetail(intent.getIntExtra("id",0));
        mAdapter = new NewsAdapter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL,1));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                NewListBean.StoriesBean bean = (NewListBean.StoriesBean) item;
                Intent intent = new Intent();
                intent.putExtra("id",bean.getId());
                intent.setClass(ColumnActivity.this, NewsDetailsActivity.class);
                startActivity(intent);
            }
        });
    }



    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
