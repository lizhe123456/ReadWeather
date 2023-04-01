package com.readweather.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.readweather.BuildConfig;
import com.readweather.app.Constants;
import com.readweather.utils.LogUtil;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public class InitService extends IntentService {

    private static final String ACTION_INIT = "initAPP";

    public InitService() {
        super("IntentService");
    }

    public static void start(Context context){
        Intent intent = new Intent(context,InitService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            final String action = intent.getAction();
            if (ACTION_INIT.equals(action)){
                initApplication();
            }
        }
    }

    private void initApplication() {
        LogUtil.init(Constants.IS_DEBUG);

    }
}
