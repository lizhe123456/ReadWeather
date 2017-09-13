package com.readweather.ui.map.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.amap.api.services.help.Tip;
import com.readweather.R;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;

/**
 * Created by lizhe on 2017/9/13 0013.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class SearchAdapter extends BaseAdapter<Tip> {

    public SearchAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, Tip item, int position) {
        holder.setText(R.id.tv_info,item.getAddress())
            .setText(R.id.tv_desc,item.getDistrict());
    }

    @Override
    protected int getItemViewLayoutId(int position, Tip item) {
        return R.layout.search_list_item;
    }

}
