package com.readweather.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by lizhe on 2017/9/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 * 定位工具类
 */

public class LocationUtil {

    public static boolean openGPSSetting(Activity context){
        LocationManager alm = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        if (alm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            return true;
        } else {

            Toast.makeText(context, "请开启GPS！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
            context.startActivityForResult(intent, 0); // 此为设置完成后返回到获取界面
            return false;
        }
    }

}
