package com.readweather.model.bean;

import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.weather.HeWeather6;
import com.readweather.model.bean.weather.WeatherBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */

public class HomeBean implements Serializable {

    Weather weather;
    List<ThemeListBean.OthersBean> othersBeans;
    List<SectionListBean.DataBean> sectionList;
    List<NewListBean.TopStoriesBean> aNew;
    TodayOnhistory todayOnhistory;
    FootBall footBall;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public List<ThemeListBean.OthersBean> getOthersBeans() {
        return othersBeans;
    }

    public void setOthersBeans(List<ThemeListBean.OthersBean> othersBeans) {
        this.othersBeans = othersBeans;
    }

    public List<SectionListBean.DataBean> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionListBean.DataBean> sectionList) {
        this.sectionList = sectionList;
    }

    public List<NewListBean.TopStoriesBean> getaNew() {
        return aNew;
    }

    public void setaNew(List<NewListBean.TopStoriesBean> aNew) {
        this.aNew = aNew;
    }

    public TodayOnhistory getTodayOnhistory() {
        return todayOnhistory;
    }

    public void setTodayOnhistory(TodayOnhistory todayOnhistory) {
        this.todayOnhistory = todayOnhistory;
    }

    public FootBall getFootBall() {
        return footBall;
    }

    public void setFootBall(FootBall footBall) {
        this.footBall = footBall;
    }

    public static class Weather implements Serializable {
        private String parent_city;
        private String loc;
        private String cond_txt;
        private String tmp;
        private List<WeatherBean.DailyForecastBean> daily_forecast;
        private List<WeatherBean.LifestyleBean> lifestyle;

        public Weather(String parent_city, String loc, String cond_txt, String tmp, List<WeatherBean.DailyForecastBean> daily_forecast, List<WeatherBean.LifestyleBean> lifestyle) {
            this.parent_city = parent_city;
            this.loc = loc;
            this.cond_txt = cond_txt;
            this.tmp = tmp;
            this.daily_forecast = daily_forecast;
            this.lifestyle = lifestyle;
        }

        public String getParent_city() {
            return parent_city;
        }

        public void setParent_city(String parent_city) {
            this.parent_city = parent_city;
        }

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getCond_txt() {
            return cond_txt;
        }

        public void setCond_txt(String cond_txt) {
            this.cond_txt = cond_txt;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public List<WeatherBean.DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<WeatherBean.DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<WeatherBean.LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<WeatherBean.LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }
    }

    public class TodayOnhistory implements Serializable{

    }


    public class FootBall implements Serializable{

    }

}
