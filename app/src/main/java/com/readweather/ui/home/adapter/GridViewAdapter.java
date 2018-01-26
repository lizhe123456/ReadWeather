package com.readweather.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.model.bean.HomePageBean;
import com.readweather.utils.GlideuUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */

public class GridViewAdapter extends BaseAdapter {

    private List<HomePageBean.Classify> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public GridViewAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        mData = new ArrayList<>();
    }



    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setmData(List<HomePageBean.Classify> data) {
        mData.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.grid_item,
                    parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text_title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon_img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        GlideuUtil.loadImageView(mContext,mData.get(position).getGridImg(),holder.imageView);
        holder.textView.setText(mData.get(position).getGridText());
        return convertView;
    }

    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

}
