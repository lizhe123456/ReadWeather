package com.readweather.app;

import android.os.Environment;

import com.readweather.R;
import com.readweather.utils.FileUtil;

import java.io.File;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class Constants {

    public static final String BUS_API = "http://op.juhe.cn/";
    public static final String GIRLS_API = "http://gank.io/api/";
    public static final String GIRLS_API2 = "http://i.jandan.net/";

    public static final String WEATHER_API = "https://free-api.heweather.com/s6/";
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "lizhe" + File.separator + "ReadWeather";
    public static final String READ_API = "https://news-at.zhihu.com/api/4/";
    public static final String TODAY_API = "http://v.juhe.cn/todayOnhistory/";
    public static final String TODAY_KEY = "ececf0cc333cf4afa3da65d379f1b4b9";

    public static final String BUS_KEY = "ec47819b07a24015d5ed11e303d6eb57";
    //和风天气key 1000次访问量
    public static final String WEATHER_KEY = "d1f1aa4110264d5baef72f8f88b59560";

    public static final boolean IS_DEBUG = true;
    public static final int TYPE_GIRL = 105;

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

    public static int[] markers = {R.drawable.poi_marker_1,
            R.drawable.poi_marker_2,
            R.drawable.poi_marker_3,
            R.drawable.poi_marker_4,
            R.drawable.poi_marker_5,
            R.drawable.poi_marker_6,
            R.drawable.poi_marker_7,
            R.drawable.poi_marker_8,
            R.drawable.poi_marker_9,
            R.drawable.poi_marker_10
    };

}
