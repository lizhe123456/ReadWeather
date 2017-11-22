package com.readweather.model.http;

import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.Girl;
import com.readweather.model.bean.JiandanBean;
import com.readweather.model.bean.read.CommentBean;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.DetailExtraBean;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.SectionListDetailBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.read.ThemeNewsDetailBean;
import com.readweather.model.bean.read.ZhihuDetailBean;
import com.readweather.model.bean.weather.ForecastBean;
import com.readweather.model.bean.weather.HeWeather6;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.model.http.response.JiandanResponse;
import com.readweather.model.http.response.WeatherResponse;

import java.util.List;
import java.util.logging.FileHandler;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface HttpHelper {

    Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String station);

    Flowable<BusResponse<List<BusNumberBean>>> fetchBusNumberBeanInfo(String city, String bus);

    Flowable<GirlsResponse<List<GankBean>>> fetchGrilsBeanInfo(int num, int page);

    Flowable<GirlsResponse<List<GankBean>>> fetchRandomGirlInfo(int num);

    Flowable<JiandanResponse<List<JiandanBean>>> fetchJiandanInfo(int page);

    Flowable<String> fetchMeizituInfo(String url);

    Flowable<String> fetchMeizitusInfo(String url);

    Flowable<NewListBean> fetchNewsListInfo();

    Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String data);

    Flowable<ThemeListBean> fetchThemeListInfo();

    Flowable<ThemeNewsDetailBean> fetchThemeDetailListInfo(int id);

    Flowable<SectionListBean> fetchSectionListInfo();

    Flowable<SectionListDetailBean> fetchSectionListDetailInfo(int id);

    Flowable<HotListBean> fetchHotListBeanInfo();

    Flowable<ZhihuDetailBean> fetchNewsDailyInfo(int id);

    Flowable<DetailExtraBean> fetchDetailExtraInfo(int id);

    Flowable<CommentBean> fetchLongCommentInfo(int id);

    Flowable<CommentBean> fetchShortCommentInfo(int id);

    Flowable<WeatherResponse<WeatherBean>> fetchWeatherInfo(String location);

    Flowable<ForecastBean> fetchForecastInfo(String location);

}
