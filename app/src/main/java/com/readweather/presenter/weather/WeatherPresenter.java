package com.readweather.presenter.weather;

import android.text.TextUtils;
import android.widget.TextView;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.model.http.response.WeatherResponse;
import com.readweather.presenter.weather.contract.WeatherContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;
import javax.inject.Inject;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by lizhe on 2017/11/22 0022.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class WeatherPresenter extends BasePresenterImpl<WeatherContract.View> implements WeatherContract.Presenter {

    DataManager dataManager;

    @Inject
    public WeatherPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getWeatherInfo(final String city) {
        addSubscribe(dataManager.fetchWeatherInfo(city)
                .compose(RxUtil.<WeatherResponse<WeatherBean>>rxSchedulerHelper())
                .map(new Function<WeatherResponse<WeatherBean>, WeatherBean>() {
                    @Override
                    public WeatherBean apply(@NonNull WeatherResponse<WeatherBean> weatherBeanWeatherResponse) throws Exception {
                        return weatherBeanWeatherResponse.getData().get(0);
                    }
                })
                .subscribeWith(new CommonSubscriber<WeatherBean>(mView) {
                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        String code = weatherBean.getStatus();
                        if (!TextUtils.isEmpty(city) && code.equals("ok")){
                            mView.showBasic(weatherBean.getBasic());
                            mView.showDailyForecast(weatherBean.getDaily_forecast());
                            mView.showUpdateBean(weatherBean.getUpdate());
                            mView.showNowBean(weatherBean.getNow());
                            mView.showLifestyle(weatherBean.getLifestyle());
                        }else {
                            mView.showErrorMsg("服务器异常");
                        }
                    }
                })
        );
    }
}
