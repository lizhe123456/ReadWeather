package com.readweather.di.component;

import android.app.Activity;

import com.readweather.di.module.FragmentModule;
import com.readweather.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
