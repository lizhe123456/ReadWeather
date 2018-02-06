package com.readweather.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.presenter.homepage.HomePagePresenter;
import com.readweather.presenter.homepage.contract.HomePageContract;
import com.readweather.ui.home.adapter.HomeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/1/26.
 * 类介绍：
 */

public class HomePageFragment extends MvpFragment<HomePagePresenter> implements HomePageContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private HomeAdapter mAdapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        mAdapter = new HomeAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mPresenter.getHomePage("武汉市");
    }


    @Override
    public void stateError() {

    }



    @Override
    public void showContent(List<Object> homeBean) {
        mAdapter.addData(homeBean);
    }
}
