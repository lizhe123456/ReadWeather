package com.readweather.model.http;

import com.readweather.model.bean.BusBean;
import com.readweather.model.http.api.BusApi;
import com.readweather.model.http.response.BaseResponse;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class HttpHelperImpl  implements HttpHelper{

    public BusApi busApi;

    @Inject
    public HttpHelperImpl(BusApi busApi){
        this.busApi = busApi;
    }

    @Override
    public Observable<BaseResponse<BusBean>> fetchBusBeanInfo(String city, String bus) {
        return busApi.getBusBeanInfo(city,bus);
    }

}
