package com.readweather.ui.read.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.ThemeListBean;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ThemeAdapter extends BaseAdapter<ThemeListBean.OthersBean>{

    public ThemeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ThemeListBean.OthersBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getThumbnail());
        holder.setText(R.id.tv_text,item.getName());
    }

    @Override
    protected int getItemViewLayoutId(int position, ThemeListBean.OthersBean item) {
        return R.layout.column_list_item;
    }
}
