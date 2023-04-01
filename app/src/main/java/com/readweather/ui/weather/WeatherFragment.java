package com.readweather.ui.weather;

import android.os.Bundle;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.ui.weather.adapter.WeatherPageAdapter;
import com.readweather.utils.SpUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class WeatherFragment extends BaseFrament {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.city)
    TextView city;

    private List<String> cityList;
    private WeatherPageAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_weather;
    }


    @Override
    protected void init() {
        adapter = new WeatherPageAdapter(getChildFragmentManager());
        cityList = SpUtil.getList(getContext(), "city");
        if (cityList == null || cityList.size() == 0) {
            WeatherItemFragment fragment = new WeatherItemFragment();
            Bundle data = new Bundle();
            data.putString("city", "location");
            fragment.setArguments(data);
            adapter.addFrag(fragment);
        } else {
            for (int i = 0; i < cityList.size() + 1; i++) {
                Bundle data = new Bundle();
                WeatherItemFragment fragment = new WeatherItemFragment();
                if (i == 0) {
                    data.putString("city", "location");
                } else {
                    data.putString("city", cityList.get(i - 1));
                }
                fragment.setArguments(data);
                adapter.addFrag(fragment);
            }
        }
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(0);
        viewPager.setCurrentItem(0);
    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.weather_setting)
    public void onViewClicked() {
    }

    public void setCity(String city){
        this.city.setText(city);
    }

}
