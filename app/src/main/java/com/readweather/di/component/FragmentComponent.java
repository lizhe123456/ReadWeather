package com.readweather.di.component;

import android.app.Activity;

import com.readweather.di.module.FragmentModule;
import com.readweather.di.scope.FragmentScope;
import com.readweather.ui.meizi.fragment.GankFragment;
import com.readweather.ui.meizi.fragment.JiandanFragment;
import com.readweather.ui.meizi.fragment.MeituFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(GankFragment fragment);

    void inject(JiandanFragment fragment);

    void inject(MeituFragment fragment);

}
