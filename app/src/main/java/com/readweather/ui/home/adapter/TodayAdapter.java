package com.readweather.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.model.bean.TodayOnhistory;
import com.readweather.view.adpter.LooperTextAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9.
 */

public class TodayAdapter extends LooperTextAdapter<TodayOnhistory.ResultBean> {

    public TodayAdapter(Context context, List<TodayOnhistory.ResultBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int position) {
        View view = getRootView(R.layout.item_today);
        TextView tvYear = view.findViewById(R.id.tv_year);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvYear.setText(mData.get(position).getDate());
        tvTitle.setText(mData.get(position).getTitle());
        return view;
    }
}
