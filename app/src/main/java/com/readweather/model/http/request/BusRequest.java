package com.readweather.model.http.request;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class BusRequest {

    //城市名称(如：苏州)或者城市代码（如：0512）
    private String city;
    //公交线路
    private String bus;
    //应用APPKEY(应用详细页查询)
    private String key;
    //公交站台名称
    private String station;
    //途经点坐标集合
    private String xys;
    //行驶类型 0表示最快捷模式，尽可能乘坐轨道交通和快速公交线路； 2表示最少换乘模式，尽可能减少换乘次数； 3表示最少步行模式，尽可能减少步行距离； 4表示最舒适模式，；乘坐有空调的车线； 5表示纯地铁模式，只选择地铁换乘
    private String type;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getXys() {
        return xys;
    }

    public void setXys(String xys) {
        this.xys = xys;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
