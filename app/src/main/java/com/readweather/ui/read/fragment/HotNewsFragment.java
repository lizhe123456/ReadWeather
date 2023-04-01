package com.readweather.ui.read.fragment;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.presenter.read.HotListPresenter;
import com.readweather.presenter.read.contract.HotListContract;
import com.readweather.ui.read.activity.NewsDetailsActivity;
import com.readweather.ui.read.adapter.HotNewsAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;

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
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HotListBean.RecentBean bean = (HotListBean.RecentBean) item;
                Intent intent = new Intent();
                intent.putExtra("id",bean.getNews_id());
                intent.setClass(getContext(), NewsDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showHotList(List<HotListBean.RecentBean> bean) {
        mAdapter.addFirstDataSet(bean);
    }
}
