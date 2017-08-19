package com.readweather.di.module;

import android.app.Activity;

import com.readweather.di.scope.AcyivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @AcyivityScope
    public Activity provideActivity(){
        return mActivity;
    }
}
