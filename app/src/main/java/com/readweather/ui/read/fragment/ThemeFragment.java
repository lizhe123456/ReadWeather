package com.readweather.ui.read.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.base.MvpFragment;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.presenter.read.ThemePresenter;
import com.readweather.presenter.read.contract.ThemeListContract;
import com.readweather.ui.read.adapter.ThemeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ThemeFragment extends MvpFragment<ThemePresenter> implements ThemeListContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ThemeAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_theme;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getThemeListBean();
        mAdapter = new ThemeAdapter(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void stateError() {

    }

    @Override
    public void showThemeList(List<ThemeListBean.OthersBean> themeListBean) {
        mAdapter.addFirstDataSet(themeListBean);
    }
}
