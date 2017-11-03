package com.readweather.ui.read.adapter;


import android.content.Context;
import android.view.View;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.NewListBean;

/**
 * Created by lizhe on 2017/11/3 0003.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class NewsAdapter extends BaseAdapter<NewListBean.StoriesBean> {


    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, NewListBean.StoriesBean item, int position) {
        if (item == null){
            if (position == 0) {
                holder.setText(R.id.title,"今日要闻");
            }else {
                holder.setText(R.id.title,item.getDate());
            }
        }else {
            holder.setGlieuImage(R.id.iv_news_img,item.getImages().get(0));
            holder.setText(R.id.tv_title,item.getTitle());
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, NewListBean.StoriesBean item) {
        if (item == null){
            return R.layout.news_list_title;
        }else {
            return R.layout.news_list_item;
        }
    }

}
