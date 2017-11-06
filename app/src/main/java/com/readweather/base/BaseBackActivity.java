package com.readweather.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.readweather.R;
import com.readweather.app.App;
import com.readweather.utils.LogUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by lizhe on 2017/11/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public abstract class BaseBackActivity extends SwipeBackActivity {

    protected Activity mActivity;
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder mUnbinder;
    protected View mView;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mView = LayoutInflater.from(this).inflate(setLayout(),null);
        setContentView(mView);
        mUnbinder = ButterKnife.bind(mActivity);
        App.getInstance().addActivity(mActivity);
        init();
//        initFragment(savedInstanceState);
        LogUtil.d("s","sadas");
        setData();
    }


    @LayoutRes
    protected abstract int setLayout();

    protected abstract void init();

    protected abstract void setData();

    protected void initFragment(Bundle savedInstanceState){

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
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }


    /**
     * 检测view是否显示
     * @param view
     * @return
     */
    protected boolean isShow(View view){
        if (view.getVisibility() == View.VISIBLE){
            return true;
        }else {
            return false;
        }
    }


}
