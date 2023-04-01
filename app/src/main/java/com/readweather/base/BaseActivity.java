package com.readweather.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.readweather.R;
import com.readweather.app.App;
import com.readweather.utils.LogUtil;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public abstract class BaseActivity extends AppCompatActivity {

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

    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
