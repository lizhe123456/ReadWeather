package com.readweather.ui.home.adapter;

import android.content.Context;

import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.SectionListBean;

/**
 * Created by Administrator on 2018/2/9.
 */

public class SectionAdapter extends BaseAdapter<SectionListBean.DataBean> {

    public SectionAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, SectionListBean.DataBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getThumbnail());
        holder.setText(R.id.tv_text,item.getName());
    }

    @Override
    protected int getItemViewLayoutId(int position, SectionListBean.DataBean item) {
        return R.layout.section_list_item2;
    }
}
