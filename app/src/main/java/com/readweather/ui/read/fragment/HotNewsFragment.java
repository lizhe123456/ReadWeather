package com.readweather.ui.read.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.presenter.read.HotListPresenter;
import com.readweather.presenter.read.contract.HotListContract;
import com.readweather.ui.read.adapter.HotNewsAdapter;
import com.readweather.ui.read.adapter.NewsAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class HotNewsFragment extends MvpFragment<HotListPresenter> implements HotListContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private HotNewsAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_hot_news;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getHotList();
        mAdapter = new HotNewsAdapter(getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL,1));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showHotList(List<HotListBean.RecentBean> bean) {
        mAdapter.addFirstDataSet(bean);
    }
}
