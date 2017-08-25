package com.readweather.base;

import com.readweather.app.App;
import com.readweather.di.component.DaggerFragmentComponent;
import com.readweather.di.component.FragmentComponent;
import com.readweather.di.module.FragmentModule;
import javax.inject.Inject;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public abstract class MvpFragment<T extends BasePresenter> extends BaseFrament implements BaseView{

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    protected void init() {
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null){
            mPresenter.datachView();
        }
        super.onDestroyView();

    }

    protected abstract void initInject();

    @Override
    public void loading() {

    }

    @Override
    public void unLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

}
