package com.readweather.di.component;

import android.app.Activity;


import com.readweather.di.module.ActivityModule;
import com.readweather.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

//    void inject(TestActivity activity);

//    void inject(MainActivity activity);

}
