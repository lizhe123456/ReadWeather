package com.readweather.ui;


import com.readweather.R;
import com.readweather.base.MvpActivity;
import com.readweather.presenter.TestPresenter;
import com.readweather.presenter.contract.TestContract;
import com.readweather.utils.LogUtil;


public class TestActivity extends MvpActivity<TestPresenter> implements TestContract.View{


    @Override
    protected int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void setData() {
        if (mPresenter == null){
            LogUtil.d("haha","null");

        }else {
           mPresenter.getTest();
        }
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
        LogUtil.d("hahaaaaa",msg);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
