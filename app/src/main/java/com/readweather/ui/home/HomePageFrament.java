package com.readweather.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.ui.home.adapter.HomeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/1/26.
 * 类介绍：
 */

public class HomePageFrament extends BaseFrament {


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
    protected void init() {

    }

    @Override
    protected void setData() {
        mAdapter = new HomeAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(mAdapter);

    }


}
