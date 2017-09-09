package com.readweather.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：fragment基类
 */

public abstract class BaseFrament extends Fragment{

    // 标识fragment视图已经初始化完毕
    private boolean isViewPrepared;
    //标识已经触发过懒加载数据
    private boolean hasFetchData;

    protected View mRootView;

    private Unbinder mUnbinder;

    protected Bundle savedInstanceState;

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void init();

    protected abstract void setData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(),container,false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        this.savedInstanceState = savedInstanceState;
        init();
        return mRootView;

    }

    private void lazyFetchDataIfPrepared() {
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            setData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            lazyFetchDataIfPrepared();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
        mUnbinder.unbind();
    }
}
