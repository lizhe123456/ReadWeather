package com.readweather.ui.meizi.fragment;

import com.readweather.model.bean.Girl;
import com.readweather.model.bean.JiandanBean;
import com.readweather.presenter.meizi.JianDanPresenter;
import com.readweather.presenter.meizi.contract.JianDanContract;
import com.readweather.service.GirlsThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class JiandanFragment extends BaseGankFragment<JianDanPresenter> implements JianDanContract.View {


    @Override
    protected void refresh() {
        super.refresh();
        mPresenter.setPAGE(1);
        mPresenter.getJIanDan();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void getMore() {
        super.getMore();
        mPresenter.getJIanDan();
    }


    @Override
    public void showJianDan(List<JiandanBean> list) {
        List<Girl> girls = new ArrayList<>();
        for (JiandanBean gank : list) {
            for (String url : gank.getPics()) {
                if (!url.toLowerCase().endsWith("gif")) {
                    //gif占用内存&流量太大，pass掉
                    girls.add(new Girl(gank.getUser_id(),url));
                }
            }
        }
        GirlsThread.startWork(getContext(),girls,getClass().getName());
    }

}
