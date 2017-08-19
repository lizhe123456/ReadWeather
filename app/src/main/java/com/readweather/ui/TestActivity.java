package com.readweather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.readweather.R;
import com.readweather.base.MvpActivity;
import com.readweather.presenter.contract.TestContract;
import com.readweather.utils.LogUtil;


public class TestActivity extends MvpActivity<TestContract.Presenter> implements TestContract.View{


    @Override
    protected int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void setData() {
        mPresenter.getTest();
    }

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
    public void setTest(String msg) {
        LogUtil.d(TAG,msg);
    }

    @Override
    protected void initInject() {
//        getActivityComponent().inject(this);
    }
}
