package com.readweather.ui.meizi.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.GankBean;
import com.readweather.presenter.meizi.GirlsPresenter;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.ui.meizi.adapter.GankAdapter;

import java.util.List;
import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankFragment extends MvpFragment<GirlsPresenter> implements GirlsContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private List<GankBean> mList;

    private StaggeredGridLayoutManager layoutManager;

    private GankAdapter adapter;

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void unLoading() {

    }

    @Override
    protected int setLayout() {
        return R.layout.gank_fragment;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<GankBean> list) {
        if (refresh.isRefreshing()){
            refresh.setRefreshing(false);
        }
        mList.clear();
        mList.addAll(list);
    }

    @Override
    public void showMore(List<GankBean> list) {

    }

}
