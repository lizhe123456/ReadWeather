package com.readweather.model.http.api;

import com.readweather.model.bean.weather.ForecastBean;
import com.readweather.model.bean.weather.HeWeather6;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.model.http.response.WeatherResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2017/8/17 0017.
 */

public interface WeatherApi {

    @GET("weather/forecast")
    Flowable<ForecastBean> getForecastInfo(@Query("key") String key,@Query("location") String location);

    /**
     *
     * @return
     */
    @GET("weather")
    Flowable<WeatherResponse<WeatherBean>> getWeatherInfo(@Query("key") String key, @Query("location") String location);
}
