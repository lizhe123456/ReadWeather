package com.readweather.app;

import android.app.Application;
import android.content.Context;
import android.os.Binder;

import com.readweather.BuildConfig;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class App extends Application{

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        if (!BuildConfig.DEBUG){

        }
    }
}
