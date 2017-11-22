package com.readweather.model.http.response;
import java.io.Serializable;
import java.util.List;


/**
 * Created by lizhe on 2017/11/22 0022.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */


public class WeatherResponse<T> implements Serializable {

    private List<T> HeWeather6;

    public List<T> getData() {
        return HeWeather6;
    }

    public void setData(List<T> data) {
        this.HeWeather6 = data;
    }
}
