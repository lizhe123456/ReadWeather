package com.readweather.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.readweather.event.GirlsComingEvent;
import com.readweather.model.bean.GankBean;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

public class GirlService extends IntentService {

    private static final String KEY_EXTRA_GIRL_FROM = "from";
    private static final String KEY_EXTRA_GIRL_List = "data";

    public GirlService() {
        super("GirlService");
    }

    public static void start(Context context, String from, List<GankBean> list){
        Intent intent = new Intent(context,GirlService.class);
        intent.putExtra(KEY_EXTRA_GIRL_FROM,from);
        intent.putExtra(KEY_EXTRA_GIRL_List, (Serializable) list);
        context.startService(intent);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, GirlService.class));
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String from = intent.getStringExtra(KEY_EXTRA_GIRL_FROM);
        List<GankBean> list = (List<GankBean>) intent.getSerializableExtra(KEY_EXTRA_GIRL_List);

        for (final GankBean gankBean : list){
            Bitmap bitmap = null;
            try {
                bitmap = Glide.with(GirlService.this)
                        .load(gankBean.getUrl())
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if (bitmap != null) {
                gankBean.setHeight(bitmap.getHeight());
                gankBean.setWidth(bitmap.getWidth());
            }
            EventBus.getDefault().post(new GirlsComingEvent(from, gankBean));
        }
    }
}
