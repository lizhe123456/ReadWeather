package com.readweather.model.http.api;


import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.http.response.BaseResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by Administrator on 2017/8/17 0017.
 */

public interface BusApi {

    @GET("189/bus/busline")
    Observable<BaseResponse<BusNumberBean>> getBusNumberBeanInfo(@Query("city") String city, @Query("bus") String bus);

    @GET("189/bus/busline")
    Observable<BaseResponse<BusBean>> getBusBeanInfo(@Query("city") String city, @Query("station") String station);

}
