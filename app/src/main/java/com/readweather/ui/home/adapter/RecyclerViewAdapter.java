package com.readweather.ui.home.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.weather.WeatherBean;

/**
 * Created by Administrator on 2018/2/6.
 */

public class RecyclerViewAdapter extends BaseAdapter<WeatherBean.DailyForecastBean>{


    public RecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, WeatherBean.DailyForecastBean item, int position) {
        holder.setText(R.id.tv_date,item.getDate())
                .setText(R.id.tv_tem,item.getTmp_min()+" ~ " + item.getTmp_max())
                .setGlieuImage(R.id.iv_icon,"https://cdn.heweather.com/cond_icon/" +item.getCond_code_d() + ".png");
    }

    @Override
    protected int getItemViewLayoutId(int position, WeatherBean.DailyForecastBean item) {
        return R.layout.item_weather_grid;
    }
}
