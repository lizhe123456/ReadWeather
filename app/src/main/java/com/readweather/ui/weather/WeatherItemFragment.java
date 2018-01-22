package com.readweather.ui.weather;

import android.support.v7.widget.RecyclerView;
import com.amap.api.location.AMapLocation;
import com.readweather.R;
import com.readweather.app.App;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.presenter.weather.WeatherPresenter;
import com.readweather.presenter.weather.contract.WeatherContract;
import java.util.List;
import butterknife.BindView;


/**
 * Created by lizhe on 2017/11/22 0022.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class WeatherItemFragment extends MvpFragment<WeatherPresenter> implements WeatherContract.View
        , App.RWLocationListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String city = "";

    @Override
    protected int setLayout() {
        return R.layout.fragment_weather_item;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        String city = getArguments().getString("city");
        if (city == null) {
            return;
        }
        if (city.equals("location")) {
            App.getInstance().getLoction(this);
        } else {
            mPresenter.getWeatherInfo(city);
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showBasic(WeatherBean.BasicBean bean) {
        ((WeatherFragment) (getParentFragment())).setCity(bean.getLocation());
    }

    @Override
    public void showUpdateBean(WeatherBean.UpdateBean bean) {
        //时间
    }

    @Override
    public void showNowBean(WeatherBean.NowBean bean) {
        //标题天气
    }

    @Override
    public void showDailyForecast(List<WeatherBean.DailyForecastBean> list) {
        //3天天气
    }

    @Override
    public void showLifestyle(List<WeatherBean.LifestyleBean> list) {
        //生活指数
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        mPresenter.getWeatherInfo(location.getCity());
        App.getInstance().stopLocation();
    }

}
