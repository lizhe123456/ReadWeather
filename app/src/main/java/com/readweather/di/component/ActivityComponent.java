package com.readweather.di.component;

import android.app.Activity;


import com.readweather.di.module.ActivityModule;
import com.readweather.di.scope.ActivityScope;
import com.readweather.ui.meizi.activity.MzituPictureActivity;
import com.readweather.ui.meizi.activity.PhotosActivity;
import com.readweather.ui.meizi.fragment.MzituZiPaiFragment;
import com.readweather.ui.read.activity.NewsDetailsActivity;
import com.readweather.ui.read.activity.ThemeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MzituPictureActivity activity);

    void inject(NewsDetailsActivity activity);

    void inject(ThemeActivity activity);

}
