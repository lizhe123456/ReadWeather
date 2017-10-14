package com.readweather.model.http;

import com.readweather.app.Constants;
import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.Girl;
import com.readweather.model.bean.JiandanBean;
import com.readweather.model.http.api.BusApi;
import com.readweather.model.http.api.GirlsApi;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.model.http.response.JiandanResponse;
import com.readweather.presenter.meizi.contract.GirlsContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class HttpHelperImpl implements HttpHelper{

    public BusApi busApi;
    public GirlsApi girlsApi;

    @Inject
    public HttpHelperImpl(BusApi busApi,GirlsApi girlsApi){
        this.busApi = busApi;
        this.girlsApi = girlsApi;
    }

    @Override
    public Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String station) {
        return busApi.getBusBeanInfo(Constants.BUS_KEY,city,station);
    }

    @Override
    public Flowable<BusResponse<List<BusNumberBean>>>  fetchBusNumberBeanInfo(String city, String bus) {
        return busApi.getBusNumberBeanInfo(Constants.BUS_KEY,city,bus);
    }

    @Override
    public Flowable<GirlsResponse<List<GankBean>>> fetchGrilsBeanInfo(int num, int page) {
        return girlsApi.getGirlList(num,page);
    }

    @Override
    public Flowable<GirlsResponse<List<GankBean>>> fetchRandomGirlInfo(int num) {
        return girlsApi.getRandomGirl(num);
    }

    @Override
    public Flowable<JiandanResponse<List<JiandanBean>>> fetchJiandanInfo(int page) {
        return girlsApi.getXXOO(page);
    }

    @Override
    public Flowable<String> fetchMeizituInfo(String url) {
        return girlsApi.getMeizitu(url);
    }

    @Override
    public Flowable<String> fetchMeizitusInfo(String url) {
        return girlsApi.getMeizitus(url);
    }

}
