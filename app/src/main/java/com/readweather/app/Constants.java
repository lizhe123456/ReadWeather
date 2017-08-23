package com.readweather.app;

import com.readweather.utils.FileUtil;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class Constants {

    public static final String BUS_API = "http://op.juhe.cn/189/bus/busline/";
    public static final String GIRLS_API = "http://gank.io/api/";
    public static final String GIRLS_API2 = "http://i.jandan.net/";
    public static final String WEATHER_API = "https://free-api.heweather.com/v5/weather/";


    public static final boolean IS_DEBUG = true;

    public static final String PATH_CACHE = FileUtil.getFileDir("Http") + "/caches";


    public static String getURL(int type) {
        String url;
        switch (type) {
            case 0:
                url = BUS_API;
                break;

            case 1:
                url = GIRLS_API;
                break;
            case 2:
                url = GIRLS_API2;
                break;
            case 3:
                url = WEATHER_API;
                break;
            default:
                url =  null;
                break;
        }
        return url;
    }

}
