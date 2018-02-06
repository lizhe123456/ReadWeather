package com.readweather.model.http.api;

import com.readweather.model.bean.TodayOnhistory;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/2/5.
 */

public interface ToDayApi {

    @GET("queryEvent.php")
    Flowable<TodayOnhistory> getTodayOnhistoryInfo(@Query("key") String key, @Query("date") String date);
}
