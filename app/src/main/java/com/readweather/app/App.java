package com.readweather.app;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.readweather.di.component.AppComponent;
import com.readweather.di.component.DaggerAppComponent;
import com.readweather.di.module.AppModule;
import com.readweather.di.module.HttpModule;
import com.readweather.service.InitService;
import com.readweather.utils.LogUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

import java.util.HashSet;
import java.util.Set;
import io.realm.Realm;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class App extends MultiDexApplication {

    private static Context mContext;
    public static AppComponent appComponent;
    private Set<Activity> allActivitySet;
    private static App instance;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    private  AMapLocationClient mLocationClient;

    private AMapLocationClientOption mLocationClientOption;

    private AMapLocation mLocation;

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
        initTbs();
        InitService.start(this);


    }

    private void initTbs() {

        QbSdk.PreInitCallback callback = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                LogUtil.i("onViewInitFinished is " + b);
            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                LogUtil.i("onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                LogUtil.i("onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                LogUtil.i("onDownloadProgress:" + i);
            }
        });

        QbSdk.initX5Environment(getApplicationContext(), QbSdk.WebviewInitType.FIRSTUSE_AND_PRELOAD, callback);


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

    /**
     * 用于定位
     */
    public void getLoction(final RWLocationListener listener){
        if (mLocation != null){
            listener.onLocationChanged(mLocation);
            return;
        }
        getCurrentLocation(listener);
    }

    /**
     * 获取当前地址
     * @param listener
     */
    private void getCurrentLocation(final RWLocationListener listener) {
        mLocationClient = new AMapLocationClient(mContext);
        mLocationClient.setLocationListener(new AMapLocationListener() {
                @Override
                public void onLocationChanged(AMapLocation location) {
                    if (location != null) {
                        mLocationClient.stopLocation();
                        mLocation = location;
                        listener.onLocationChanged(location);
                    }
                }
            });
        // 初始化AMapLocationClientOption对象
        mLocationClientOption = new AMapLocationClientOption();
        // 设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClientOption.setOnceLocationLatest(true);
        // 给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationClientOption);
        // 启动定位
        mLocationClient.startLocation();

    }

    public void stopLocation(){
        mLocationClient.stopLocation();
    }

    /**
     * 定位回调借口
     */
    public interface RWLocationListener{
        void onLocationChanged(AMapLocation location);
    }


}
