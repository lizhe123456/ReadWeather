package com.readweather.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.readweather.BuildConfig;
import com.readweather.di.component.AppComponent;
import com.readweather.di.component.DaggerAppComponent;
import com.readweather.di.module.AppModule;
import com.readweather.di.module.HttpModule;
import com.readweather.service.InitService;
import java.util.HashSet;
import java.util.Set;
import io.realm.Realm;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class App extends Application{

    private static Context mContext;
    public static AppComponent appComponent;
    private Set<Activity> allActivitySet;
    private static App instance;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static Context getContext() {
        return mContext;
    }

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (!Constants.IS_DEBUG) {
            AppExceptionHandler.getInstance().setCrashHanler(this);
        }
        instance = this;
        mContext = getApplicationContext();
        //初始化屏幕宽高
        getScreenSize();

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

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
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
