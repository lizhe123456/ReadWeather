package com.readweather.ui.meizi.fragment;

import android.support.v4.app.Fragment;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.presenter.meizi.GirlsPresenter;
import com.readweather.presenter.meizi.contract.GirlsContract;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class MeituFragment extends MvpFragment<GirlsPresenter> implements GirlsContract.View{
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
        return R.layout.fragment_meitu;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initInject() {

    }
}
