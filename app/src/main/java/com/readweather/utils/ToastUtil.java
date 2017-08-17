package com.readweather.utils;

import android.widget.Toast;

import com.readweather.R;
import com.readweather.app.App;

/**
 * Created by Administrator on 2017/8/17 0017.
 * Toast工具类
 */

public class ToastUtil {

    public static void showShort(int resId){
        Toast.makeText(App.getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resId){
        Toast.makeText(App.getContext(), resId, Toast.LENGTH_LONG).show();
    }

    public static void showShort(String msg){
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg){
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
