package com.readweather.presenter.weather.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.weather.WeatherBean.*;

import java.util.List;

/**
 * Created by lizhe on 2017/11/22 0022.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface WeatherContract {
    interface View extends BaseView{

        void showBasic(BasicBean bean);

        void showUpdateBean(UpdateBean bean);

        void showNowBean(NowBean bean);

        void showDailyForecast(List<DailyForecastBean> list);

        void showLifestyle(List<LifestyleBean> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getWeatherInfo(String city);


    }
}
