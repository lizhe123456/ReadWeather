package com.readweather.ui.weather.adapter;

import android.content.Context;

import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.weather.WeatherBean;

import java.util.List;

/**
 * Created by lizhe on 2018/1/22.
 * 类介绍：
 */

public class PageItemAdapter extends BaseAdapter<WeatherBean>{

    //地址信息
    private WeatherBean.BasicBean basicBean;
    //现在天气
    private WeatherBean.NowBean nowBean;
    //更新时间
    private WeatherBean.UpdateBean updateBean;
    //3日预报天气
    private List<WeatherBean.DailyForecastBean> dailyForecastBeanList;
    //生活指数
    private List<WeatherBean.LifestyleBean> lifestyleBeanList;


    public PageItemAdapter(Context context) {
        super(context);
    }

    public PageItemAdapter(Context context, List<WeatherBean> data) {
        super(context, data);
    }

    @Override
    public void addFirstDataSet(List<WeatherBean> data) {
        super.addFirstDataSet(data);
        basicBean = data.get(0).getBasic();
        nowBean = data.get(0).getNow();
        updateBean = data.get(0).getUpdate();
        dailyForecastBeanList = data.get(0).getDaily_forecast();
        lifestyleBeanList = data.get(0).getLifestyle();
    }


    @Override
    protected void bindDataToItemView(BaseViewHolder holder, WeatherBean item, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, WeatherBean item) {
        switch (position){

        }
        return 0;
    }
}
