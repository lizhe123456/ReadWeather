package com.readweather.event;

import com.readweather.model.bean.GankBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyu on 2016/12/8.
 */

public class GirlsComingEvent {

    private List<GankBean> girls;

    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public GirlsComingEvent(String from, List<GankBean> girls) {
        this.girls = girls;
        this.from = from;
    }

    public GirlsComingEvent(String from, GankBean girl) {
        this.girls = new ArrayList<>();
        girls.add(girl);
        this.from = from;
    }

    public List<GankBean> getGirls() {
        return girls;
    }

    public void setGirls(List<GankBean> girls) {
        this.girls = girls;
    }
}
