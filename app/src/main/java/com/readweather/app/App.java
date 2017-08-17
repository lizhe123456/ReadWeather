package com.readweather.app;

import android.app.Application;
import android.content.Context;
import android.os.Binder;

import com.readweather.BuildConfig;
import com.readweather.utils.LogUtil;

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
        LogUtil.init(Constants.IS_DEBUG);
    }
}
