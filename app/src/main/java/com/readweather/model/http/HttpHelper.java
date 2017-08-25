package com.readweather.model.http;

import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.bean.GankBean;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface HttpHelper {

    Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String station);

    Flowable<BusResponse<List<BusNumberBean>>> fetchBusNumberBeanInfo(String city, String bus);

    Flowable<GirlsResponse<List<GankBean>>> fetchGrilsBeanInfo(int num, int page);

    Flowable<GirlsResponse<List<GankBean>>> fetchRandomGirlInfo(int num);
}
