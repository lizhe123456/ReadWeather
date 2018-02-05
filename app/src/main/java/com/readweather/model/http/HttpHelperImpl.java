package com.readweather.model.http;

import com.readweather.app.Constants;
import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.Girl;
import com.readweather.model.bean.HomeBean;
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
import com.readweather.model.http.api.BusApi;
import com.readweather.model.http.api.GirlsApi;
import com.readweather.model.http.api.HomeApi;
import com.readweather.model.http.api.ReadApi;
import com.readweather.model.http.api.ToDayApi;
import com.readweather.model.http.api.WeatherApi;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.model.http.response.JiandanResponse;
import com.readweather.model.http.response.WeatherResponse;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.utils.DateUtil;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class HttpHelperImpl implements HttpHelper{

    public BusApi busApi;
    public GirlsApi girlsApi;
    public ReadApi readApi;
    public WeatherApi weatherApi;
    public ToDayApi toDayApi;

    @Inject
    public HttpHelperImpl(BusApi busApi,GirlsApi girlsApi, ReadApi readApi, WeatherApi weatherApi,ToDayApi toDayApi){
        this.busApi = busApi;
        this.girlsApi = girlsApi;
        this.readApi = readApi;
        this.weatherApi = weatherApi;
        this.toDayApi = toDayApi;
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

    @Override
    public Flowable<NewListBean> fetchNewsListInfo() {
        return readApi.getNewsList();
    }

    @Override
    public Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String data) {
        return readApi.getDailyBeforeList(data);
    }

    @Override
    public Flowable<ThemeListBean> fetchThemeListInfo() {
        return readApi.getThemeList();
    }

    @Override
    public Flowable<ThemeNewsDetailBean> fetchThemeDetailListInfo(int id) {
        return readApi.getThemeNewsDetailList(id);
    }

    @Override
    public Flowable<SectionListBean> fetchSectionListInfo() {
        return readApi.getSectionList();
    }

    @Override
    public Flowable<SectionListDetailBean> fetchSectionListDetailInfo(int id) {
        return readApi.getSectionNewsDetailList(id);
    }

    @Override
    public Flowable<HotListBean> fetchHotListBeanInfo() {
        return readApi.getHotList();
    }

    @Override
    public Flowable<ZhihuDetailBean> fetchNewsDailyInfo(int id) {
        return readApi.getDetailInfo(id);
    }

    @Override
    public Flowable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return readApi.getDetailExtraInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchLongCommentInfo(int id) {
        return readApi.getLongCommentInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchShortCommentInfo(int id) {
        return readApi.getShortCommentInfo(id);
    }

    @Override
    public Flowable<WeatherResponse<WeatherBean>> fetchWeatherInfo(String location) {
        return weatherApi.getWeatherInfo(Constants.WEATHER_KEY,location);
    }

    @Override
    public Flowable<ForecastBean> fetchForecastInfo(String location) {
        return weatherApi.getForecastInfo(Constants.WEATHER_KEY,location);
    }

    @Override
    public Flowable<HomeBean.TodayOnhistory> fetchTodayOnhistoryInfo() {
        return toDayApi.getTodayOnhistoryInfo(Constants.TODAY_KEY, DateUtil.dateToStr1(new Date()));
    }


}
