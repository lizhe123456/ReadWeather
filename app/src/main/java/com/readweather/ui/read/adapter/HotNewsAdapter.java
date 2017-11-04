package com.readweather.ui.read.adapter;


import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.model.bean.read.NewListBean;

/**
 * Created by lizhe on 2017/11/3 0003.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class HotNewsAdapter extends BaseAdapter<HotListBean.RecentBean> {

    public HotNewsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HotListBean.RecentBean item, int position) {
        holder.setGlieuImage(R.id.iv_news_img,item.getThumbnail());
        holder.setText(R.id.tv_title,item.getTitle());
    }

    @Override
    protected int getItemViewLayoutId(int position,HotListBean.RecentBean item) {
        return R.layout.news_list_item;
    }

}
