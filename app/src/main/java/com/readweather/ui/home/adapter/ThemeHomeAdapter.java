package com.readweather.ui.home.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.ThemeListBean;

/**
 * Created by Administrator on 2018/2/9.
 */

public class ThemeHomeAdapter extends BaseAdapter<ThemeListBean.OthersBean> {

    public ThemeHomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ThemeListBean.OthersBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getThumbnail());
        holder.setText(R.id.tv_text,item.getName());
    }

    @Override
    protected int getItemViewLayoutId(int position, ThemeListBean.OthersBean item) {
        return R.layout.column_list_item2;
    }
}
