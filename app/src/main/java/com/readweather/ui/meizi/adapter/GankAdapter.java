package com.readweather.ui.meizi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.readweather.R;
import com.readweather.app.App;
import com.readweather.model.bean.GankBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankAdapter extends RecyclerView.Adapter<GankAdapter.ViewHolder>{

    private List<GankBean>  list;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;


    public GankAdapter(List<GankBean> list, Context context) {
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_girl, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.get(holder.getAdapterPosition()).getHeight() > 0){

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return Math.round((float) App.SCREEN_WIDTH / (float) list.get(position).getHeight() * 10f);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_girl)
        ImageView ivGirl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position,View view);
    }
}
