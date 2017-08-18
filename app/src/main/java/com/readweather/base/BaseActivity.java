package com.readweather.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.readweather.utils.LogUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /* 是否沉浸状态栏*/
    private boolean isSetStatusBar = true;
    /* 是否允许全屏*/
    private boolean isAllowFullScreen = true;
    /* 是否禁止旋转屏幕*/
    private boolean isAllowScreenRoate = false;
    /* 是否沉浸状态栏当前Activity渲染的视图*/
    private View mView;

    private LayoutInflater mLayoutInflater;
    protected Activity mActivity;
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (isAllowFullScreen){
            mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        if (isSetStatusBar){
            steepStatusBar();
        }

        if (!isAllowScreenRoate){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        mLayoutInflater = LayoutInflater.from(mActivity);
        mView = mLayoutInflater.inflate(setLayout(),null);
        if (mView != null){
            ButterKnife.bind(mActivity);
            setContentView(mView);
            init();
            setData();
        }else {
          setContentView(setLayout());
        }

    }



    protected abstract int setLayout();

    protected abstract void init();

    protected abstract void setData();

    /**
     * 是否设置沉浸状态栏
     * @param setStatusBar
     */
    public void setSetStatusBar(boolean setStatusBar) {
        isSetStatusBar = setStatusBar;
    }

    /**
     * 是否允许全屏
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        isAllowFullScreen = allowFullScreen;
    }

    /**
     * 是否允许屏幕旋转
     * @param allowScreenRoate
     */
    public void setAllowScreenRoate(boolean allowScreenRoate) {
        isAllowScreenRoate = allowScreenRoate;
    }

    /**
     * 防止快速点击
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy()");
    }

}
