package com.readweather.model.http;

import com.readweather.app.Constants;
import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.http.api.BusApi;
import com.readweather.model.http.response.BusResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

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
    public Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String station) {
        return busApi.getBusBeanInfo(Constants.BUS_KEY,city,station);
    }

    @Override
    public Flowable<BusResponse<List<BusNumberBean>>>  fetchBusNumberBeanInfo(String city, String bus) {
        return busApi.getBusNumberBeanInfo(Constants.BUS_KEY,city,bus);
    }


}
