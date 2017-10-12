package com.readweather.ui.meizi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.readweather.R;
import com.readweather.model.bean.Girl;
import com.readweather.utils.DensityUtils;
import com.readweather.view.RatioImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankAdapter extends RecyclerView.Adapter<GankAdapter.ViewHolder> {

    private List<Girl> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener onItemClickListener;

    public GankAdapter(List<Girl> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public void setNewData(List<Girl> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();

    }

    public List<Girl> getmList() {
        return mList;
    }

    public void addData(int position, List<Girl> data) {
        this.mList.addAll(position, data);
        this.notifyItemRangeInserted(position, data.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_girl, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Girl girl = mList.get(position);
        if (girl.getHeight() != 0) {
            holder.ivGirl.setOriginalSize(DensityUtils.px2dip(mContext,girl.getWidth()), DensityUtils.px2dip(mContext,girl.getHeight()));
        } else {
            holder.ivGirl.setOriginalSize(236, 354);
        }



        holder.ivGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(position, v);
                }
            }
        });

        Glide.with(mContext).load(girl.getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_glide_holder).crossFade(500).into(holder.ivGirl);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Girl girl = mList.get(position);
        return Math.round((float) girl.getWidth() / (float) girl.getHeight() * 10f);
    }

    public void setLoadMoreData(List<Girl> list) {
        int size = mList.size();
        mList.addAll(list);
        notifyItemInserted(size);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_girl)
        RatioImageView ivGirl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position, View view);
    }

}
