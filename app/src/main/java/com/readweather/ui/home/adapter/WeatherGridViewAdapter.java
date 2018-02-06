package com.readweather.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.utils.GlideuUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 */

public class WeatherGridViewAdapter extends BaseAdapter {

    private List<WeatherBean.DailyForecastBean> list;
    private Context mContext;

    public void addList(List<WeatherBean.DailyForecastBean> list) {
        if (this.list == null){
            this.list = list;
        }else {
            this.list.clear();
            this.list.addAll(list);
        }
        this.notifyDataSetChanged();
    }

    public WeatherGridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_weather_grid,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.setGridView(list.get(position).getDate()
                ,"https://cdn.heweather.com/cond_icon/" +list.get(position).getCond_code_d() + ".png"
                ,list.get(position).getTmp_min() + " ~ " + list.get(position).getTmp_min());

        return convertView;
    }



    class ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView tvNum;

        public ViewHolder(View itemView) {
            textView = itemView.findViewById(R.id.tv_date);
            imageView = itemView.findViewById(R.id.iv_icon);
            tvNum = itemView.findViewById(R.id.tv_tem);
        }

        public void setGridView(String update, String url, String tem){
            textView.setText(update);
            GlideuUtil.loadImageView(mContext,url,imageView);
            tvNum.setText(tem);
        }
    }
}
