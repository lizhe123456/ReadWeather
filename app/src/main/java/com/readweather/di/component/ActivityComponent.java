package com.readweather.di.component;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.readweather.di.module.ActivityModule;
import com.readweather.di.scope.AcyivityScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@AcyivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

}
