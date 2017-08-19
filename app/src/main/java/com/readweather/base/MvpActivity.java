package com.readweather.base;

import com.readweather.app.App;
import com.readweather.di.component.ActivityComponent;

import com.readweather.di.component.DaggerActivityComponent;
import com.readweather.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public abstract class MvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
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
    protected void onDestroy() {
        if (mPresenter != null){
            mPresenter.datachView();
        }
        super.onDestroy();
    }



    protected abstract void initInject();

}
