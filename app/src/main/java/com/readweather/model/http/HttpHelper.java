package com.readweather.model.http;

import com.readweather.model.bean.BusBean;
import com.readweather.model.http.response.BaseResponse;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface HttpHelper {

    Observable<BaseResponse<BusBean>> fetchBusBeanInfo(String city, String bus);

}
