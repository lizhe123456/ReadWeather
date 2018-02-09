package com.readweather.ui.home.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.NewListBean;

/**
 * Created by Administrator on 2018/2/8.
 */

public class HomeNewAdapter extends BaseAdapter<NewListBean.TopStoriesBean> {

    public HomeNewAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, NewListBean.TopStoriesBean item, int position) {
        holder.setGlieuImage(R.id.iv_news_img,item.getImage());
        holder.setText(R.id.tv_title,item.getTitle());
    }

    @Override
    protected int getItemViewLayoutId(int position, NewListBean.TopStoriesBean item) {
        return R.layout.news_list_item2;
    }
}
