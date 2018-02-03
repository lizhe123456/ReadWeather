package com.readweather.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/3.
 */

public class HomeBean implements Serializable {

    Weather weather;
    Theme theme;
    Section section;
    New aNew;
    TodayOnhistory todayOnhistory;
    FootBall footBall;


    public class Weather implements Serializable{

    }

    /**
     * 首页主题
     */
    public class Theme implements Serializable{

    }

    /**
     * 首页专栏
     */
    public class Section implements Serializable{

    }

    /**
     * 首页日报
     */
    public class New implements Serializable{

    }

    /**
     * 首页历史上的今天
     */
    public class TodayOnhistory implements Serializable{

    }

    /**
     * 足球联赛信息
     */
    public class FootBall implements Serializable{

    }


}
