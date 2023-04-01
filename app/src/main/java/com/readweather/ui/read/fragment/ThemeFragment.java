package com.readweather.ui.read.fragment;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.presenter.read.ThemePresenter;
import com.readweather.presenter.read.contract.ThemeListContract;
import com.readweather.ui.read.activity.ThemeActivity;
import com.readweather.ui.read.adapter.ThemeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

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
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                Intent intent = new Intent();
                intent.setClass(getContext(), ThemeActivity.class);
                intent.putExtra("id",((ThemeListBean.OthersBean)item).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showThemeList(List<ThemeListBean.OthersBean> themeListBean) {
        mAdapter.addFirstDataSet(themeListBean);
    }
}
