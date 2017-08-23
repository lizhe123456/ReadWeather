package com.readweather.model.http;

import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.http.response.BaseResponse;
import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface HttpHelper {

    Flowable<BaseResponse<BusBean>> fetchBusBeanInfo(String city, String station);

    Flowable<BaseResponse<BusNumberBean>> fetchBusNumberBeanInfo(String city, String bus);
}
