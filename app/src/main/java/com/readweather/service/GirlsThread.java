package com.readweather.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.ScriptIntrinsicYuvToRGB;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.readweather.event.GirlsComingEvent;
import com.readweather.model.bean.Girl;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

public class GirlsThread extends Thread {

    private static Context mContext;
    private List<Girl> mList;
    private static String from;
    private static GirlsThread t;
    //此变量必须加上volatile
    private static volatile boolean stop = false;

    private GirlsThread(Context context, @Nullable List<Girl> mList, String from){
        this.mContext = context;
        this.mList = mList;
        this.from = from;
    }

    @Override
    public void run() {
        List<Girl> list = null;
        while (!stop) {
            if (list == null) {
                list = new ArrayList<>();
            }
            for (final Girl gankBean : mList) {
                Bitmap bitmap = null;
                try {
                    bitmap = Glide.with(mContext)
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
                synchronized (Girl.class) {
                    if (bitmap != null) {
                        gankBean.setHeight(bitmap.getHeight());
                        gankBean.setWidth(bitmap.getWidth());
                    }
                }
                list.add(gankBean);
            }
            EventBus.getDefault().post(new GirlsComingEvent(from,list));
            stopWork();
        }
    }


    public static synchronized void startWork(Context context, @Nullable List<Girl> mList1, String from1){
        t = new GirlsThread(context, mList1, from1);
        t.start();
        stop = false;


    }

    public static void stopWork(){
        stop = true;
    }
}
