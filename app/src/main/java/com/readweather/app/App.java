package com.readweather.app;

import android.app.Application;
import android.content.Context;
import com.readweather.BuildConfig;
import com.readweather.utils.LogUtil;
import io.realm.Realm;
import io.realm.RealmConfiguration;

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

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

    }
}
