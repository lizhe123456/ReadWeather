package com.readweather.di.component;

import android.app.Activity;

import com.readweather.di.module.FragmentModule;
import com.readweather.di.scope.FragmentScope;
import com.readweather.ui.meizi.fragment.GankFragment;
import com.readweather.ui.meizi.fragment.JiandanFragment;
import com.readweather.ui.meizi.fragment.MeituFragment;
import com.readweather.ui.meizi.fragment.MzituZiPaiFragment;
import com.readweather.ui.read.fragment.ColumnFragment;
import com.readweather.ui.read.fragment.HotNewsFragment;
import com.readweather.ui.read.fragment.MainNewsFragment;
import com.readweather.ui.read.fragment.ThemeFragment;

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

    void inject(MzituZiPaiFragment fragment);

    void inject(MainNewsFragment fragment);

    void inject(ColumnFragment fragment);

    void inject(ThemeFragment fragment);

    void inject(HotNewsFragment fragment);

}
