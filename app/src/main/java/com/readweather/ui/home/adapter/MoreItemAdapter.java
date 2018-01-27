package com.readweather.ui.home.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.HomePageBean;

/**
 * Created by Administrator on 2018/1/27.
 */

public class MoreItemAdapter extends BaseAdapter<HomePageBean.MoreData> {



    public MoreItemAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.MoreData item, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.MoreData item) {
        return R.layout.more_item;
    }
}
