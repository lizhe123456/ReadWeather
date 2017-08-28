package com.readweather.base;

import android.util.Log;

import com.readweather.app.App;
import com.readweather.di.component.DaggerFragmentComponent;
import com.readweather.di.component.FragmentComponent;
import com.readweather.di.module.FragmentModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

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
        //订阅
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null){
            mPresenter.datachView();
        }
        //解除订阅
        EventBus.getDefault().unregister(this);
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
