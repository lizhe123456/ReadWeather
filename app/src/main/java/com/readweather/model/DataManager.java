package com.readweather.model;

import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.Girl;
import com.readweather.model.bean.HomeBean;
import com.readweather.model.bean.JiandanBean;
import com.readweather.model.bean.RealmLikeBean;
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
import com.readweather.model.db.RealmHelper;
import com.readweather.model.http.HttpHelper;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.model.http.response.JiandanResponse;
import com.readweather.model.http.response.WeatherResponse;
import com.readweather.model.prefs.PreferencesHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 * 数据管理中心
 */

public class DataManager implements HttpHelper,RealmHelper,PreferencesHelper{

    HttpHelper mHttpHelper;
    RealmHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(HttpHelper mHttpHelper, RealmHelper mDbHelper, PreferencesHelper mPreferencesHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mDbHelper = mDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public void insertNewId(int id) {
        mDbHelper.insertNewId(id);
    }

    @Override
    public boolean queryNewsId(int id) {
        return mDbHelper.queryNewsId(id);
    }

    @Override
    public void insertLike(RealmLikeBean bean) {
        mDbHelper.insertLike(bean);
    }

    @Override
    public boolean deleteLikeBean(String id) {
        return mDbHelper.deleteLikeBean(id);
    }

    @Override
    public boolean queryLikeBean(String id) {
        return mDbHelper.queryLikeBean(id);
    }

    @Override
    public List<RealmLikeBean> getLikeList() {
        return mDbHelper.getLikeList();
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mDbHelper.changeLikeTime(id,time,isPlus);
    }

    @Override
    public Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String bus) {
        return mHttpHelper.fetchBusBeanInfo(city,bus);
    }

    @Override
    public Flowable<BusResponse<List<BusNumberBean>>> fetchBusNumberBeanInfo(String city, String bus) {
        return mHttpHelper.fetchBusNumberBeanInfo(city,bus);
    }

    @Override
    public Flowable<GirlsResponse<List<GankBean>>> fetchGrilsBeanInfo(int num, int page) {
        return mHttpHelper.fetchGrilsBeanInfo(num,page);
    }

    @Override
    public Flowable<GirlsResponse<List<GankBean>>> fetchRandomGirlInfo(int num) {
        return mHttpHelper.fetchRandomGirlInfo(num);
    }

    @Override
    public Flowable<JiandanResponse<List<JiandanBean>>> fetchJiandanInfo(int page) {
        return mHttpHelper.fetchJiandanInfo(page);
    }

    @Override
    public Flowable<String> fetchMeizituInfo(String url) {
        return mHttpHelper.fetchMeizituInfo(url);
    }

    @Override
    public Flowable<String> fetchMeizitusInfo(String url) {
        return mHttpHelper.fetchMeizitusInfo(url);
    }

    @Override
    public Flowable<NewListBean> fetchNewsListInfo() {
        return mHttpHelper.fetchNewsListInfo();
    }

    @Override
    public Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String data) {
        return mHttpHelper.fetchDailyBeforeListInfo(data);
    }

    @Override
    public Flowable<ThemeListBean> fetchThemeListInfo() {
        return mHttpHelper.fetchThemeListInfo();
    }

    @Override
    public Flowable<ThemeNewsDetailBean> fetchThemeDetailListInfo(int id) {
        return mHttpHelper.fetchThemeDetailListInfo(id);
    }

    @Override
    public Flowable<SectionListBean> fetchSectionListInfo() {
        return mHttpHelper.fetchSectionListInfo();
    }

    @Override
    public Flowable<SectionListDetailBean> fetchSectionListDetailInfo(int id) {
        return mHttpHelper.fetchSectionListDetailInfo(id);
    }

    @Override
    public Flowable<HotListBean> fetchHotListBeanInfo() {
        return mHttpHelper.fetchHotListBeanInfo();
    }

    @Override
    public Flowable<ZhihuDetailBean> fetchNewsDailyInfo(int id) {
        return mHttpHelper.fetchNewsDailyInfo(id);
    }

    @Override
    public Flowable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return mHttpHelper.fetchDetailExtraInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchLongCommentInfo(int id) {
        return mHttpHelper.fetchLongCommentInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchShortCommentInfo(int id) {
        return mHttpHelper.fetchShortCommentInfo(id);
    }

    @Override
    public Flowable<WeatherResponse<WeatherBean>> fetchWeatherInfo(String location) {
        return mHttpHelper.fetchWeatherInfo(location);
    }

    @Override
    public Flowable<ForecastBean> fetchForecastInfo(String location) {
        return mHttpHelper.fetchForecastInfo(location);
    }

    @Override
    public Flowable<HomeBean.TodayOnhistory> fetchTodayOnhistoryInfo() {
        return mHttpHelper.fetchTodayOnhistoryInfo();
    }


}
