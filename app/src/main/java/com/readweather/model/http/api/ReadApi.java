package com.readweather.model.http.api;

import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.NewListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lizhe on 2017/10/14 0014.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface ReadApi {

    @GET("new/latest")
    Flowable<NewListBean> getNewsList();

    /**
     * 往期日报
     */
    @GET("news/before/{date}")
    Flowable<DailyBeforeListBean> getDailyBeforeList(@Path("date") String date);
}
