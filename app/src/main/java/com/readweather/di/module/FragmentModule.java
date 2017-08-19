package com.readweather.di.module;

import android.app.Activity;
import android.app.Fragment;

import com.readweather.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return fragment.getActivity();
    }
}
