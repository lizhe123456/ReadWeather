package com.readweather.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.readweather.BuildConfig;
import com.readweather.di.component.AppComponent;
import com.readweather.di.component.DaggerActivityComponent;
import com.readweather.di.component.DaggerAppComponent;
import com.readweather.di.module.AppModule;
import com.readweather.di.module.HttpModule;
import com.readweather.service.InitService;
import com.readweather.utils.LogUtil;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class App extends Application{

    private static Context mContext;
    public static AppComponent appComponent;
    private Set<Activity> allActivitySet;
    private static App instance;

    public static Context getContext() {
        return mContext;
    }

    public static synchronized void setInstance(App instance) {
        App.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Realm.init(mContext);

        InitService.start(this);
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public void exitApp(){
        if (allActivitySet != null){
            synchronized (allActivitySet){
                for (Activity activity : allActivitySet){
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    protected void attachBaseContext(Context base){
        super.attachBaseContext(base);

    }

    public void addActivity(Activity activity){
        if (allActivitySet == null){
            allActivitySet = new HashSet<>();
        }
        allActivitySet.add(activity);
    }

    public void removeActivity(Activity activity){
        if (activity != null){
            allActivitySet.remove(activity);
        }
    }

}
