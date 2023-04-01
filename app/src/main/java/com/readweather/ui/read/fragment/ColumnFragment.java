package com.readweather.ui.read.fragment;

import android.content.Intent;

import android.view.View;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.presenter.read.SectionPresenter;
import com.readweather.presenter.read.contract.SectionListContract;
import com.readweather.ui.read.activity.ColumnActivity;
import com.readweather.ui.read.adapter.ColumnAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import butterknife.BindView;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ColumnFragment extends MvpFragment<SectionPresenter> implements SectionListContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ColumnAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_column;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getSectionList();
        mAdapter = new ColumnAdapter(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                SectionListBean.DataBean bean = (SectionListBean.DataBean) item;
                Intent intent = new Intent();
                intent.putExtra("id",bean.getId());
                intent.setClass(getContext(),ColumnActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showSectionList(List<SectionListBean.DataBean> bean) {
        mAdapter.addFirstDataSet(bean);
    }

}
