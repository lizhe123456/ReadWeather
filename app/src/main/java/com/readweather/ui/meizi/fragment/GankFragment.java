package com.readweather.ui.meizi.fragment;

import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.GirlsPresenter;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.service.GirlsThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankFragment extends BaseGankFragment<GirlsPresenter> implements GirlsContract.View {



    @Override
    protected void refresh() {
        super.refresh();
        mPresenter.getGirlsData();
    }

    @Override
    protected void getMore() {
        super.getMore();
        mPresenter.getMore();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<GankBean> list) {
        List<Girl> girls = new ArrayList<>();
        for (GankBean gank : list) {
            girls.add(new Girl(gank.getUrl()));
        }
        GirlsThread.startWork(getContext(),girls,getClass().getName());
    }

    @Override
    public void showMore(List<GankBean> list) {
        List<Girl> girls = new ArrayList<>();
        for (GankBean gank : list) {
            girls.add(new Girl(gank.getUrl()));
        }
        GirlsThread.startWork(getContext(),girls,getClass().getName());
    }

}
