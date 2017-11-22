package com.readweather.ui.weather;

import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.weather.HeWeather6;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.presenter.weather.WeatherPresenter;
import com.readweather.presenter.weather.contract.WeatherContract;

import java.util.List;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class WeatherFragment extends MvpFragment<WeatherPresenter> implements WeatherContract.View {


    @Override
    protected int setLayout() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getWeatherInfo("武汉");
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showBasic(WeatherBean.BasicBean bean) {

    }

    @Override
    public void showUpdateBean(WeatherBean.UpdateBean bean) {

    }

    @Override
    public void showNowBean(WeatherBean.NowBean bean) {

    }

    @Override
    public void showDailyForecast(List<WeatherBean.DailyForecastBean> list) {

    }

    @Override
    public void showLifestyle(List<WeatherBean.LifestyleBean> list) {

    }
}
