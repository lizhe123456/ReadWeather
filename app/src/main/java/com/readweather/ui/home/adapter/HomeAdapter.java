package com.readweather.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.model.bean.HomePageBean;
import com.readweather.utils.GlideuUtil;
import com.readweather.widgets.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/1/26.
 * 类介绍：
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private HomePageBean homePageBean;
    private Context mContext;
    private LayoutInflater mInflater;

    private final static int HEAD = 0;
    private final static int PUSH = 1;
    private final static int ITEM1 = 2;
    private final static int ITEM2 = 3;
    private final static int ITEM3 = 4;
    private final static int ITEM4 = 5;
    private final static int ITEM5 = 6;
    private final static int ITEM6 = 7;
    private final static int MORE = 8;

    public HomeAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        ViewHolder viewHolder1 = null;
        ViewHolder viewHolder2 = null;
        ViewHolder viewHolder3 = null;
        ViewHolder viewHolder4 = null;
        ViewHolder viewHolder5 = null;
        ViewHolder viewHolder6 = null;
        ViewHolder viewHolder7 = null;
        ViewHolder viewHolder8 = null;
        ViewHolder viewHolder9 = null;
        if (getItemViewType(position) == HEAD){
            //头部布局
            if (viewHolder1 == null){
                View view = mInflater.inflate(R.layout.head_item,null);
                viewHolder1 = new ViewHolder(view);
            }
            return viewHolder1;
        }else if (getItemViewType(position) == PUSH){
            //推送布局
            if (viewHolder2 == null){
                View view1 = mInflater.inflate(R.layout.push_item,null);
                viewHolder2 = new ViewHolder(view1);
            }
            return viewHolder2;
        }else if (getItemViewType(position) == ITEM1){
            //布局样式1
            if (viewHolder3 == null){
                View view2 = mInflater.inflate(R.layout.home_item1,null);
                viewHolder3 = new ViewHolder(view2);
            }
            return viewHolder3;
        }else if (getItemViewType(position) == ITEM2){
            //布局样式2
            if (viewHolder4 == null){
                View view3 = mInflater.inflate(R.layout.home_item2,null);
                viewHolder4 = new ViewHolder(view3);
            }
            return viewHolder4;
        }else if (getItemViewType(position) == ITEM3){
            //布局样式3
            if (viewHolder5 == null){
                View view4 = mInflater.inflate(R.layout.home_item3,null);
                viewHolder5 = new ViewHolder(view4);
            }
            return viewHolder5;
        }else if (getItemViewType(position) == ITEM4){
            //布局样式4
            if (viewHolder6 == null){
                View view5 = mInflater.inflate(R.layout.home_item4,null);
                viewHolder6 = new ViewHolder(view5);
            }
            return viewHolder6;

        }else if (getItemViewType(position) == ITEM5){
            //布局样式5
            if (viewHolder7 == null){
                View view6 = mInflater.inflate(R.layout.home_item5,null);
                viewHolder7 = new ViewHolder(view6);
            }
            return viewHolder7;

        }else if (getItemViewType(position) == ITEM6){
            //布局样式6
            if (viewHolder8 == null){
                View view7 = mInflater.inflate(R.layout.home_item6,null);
                viewHolder8 = new ViewHolder(view7);
            }
            return viewHolder8;

        }else if (getItemViewType(position) == MORE){
            //底部更多
            if (viewHolder9 == null){
                View view8 = mInflater.inflate(R.layout.home_more,null);
                viewHolder9 = new ViewHolder(view8);
            }
            return viewHolder9;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)) {
            case HEAD :
                //头部布局
                viewHolder.setBannerImg(R.id.banner,homePageBean.getHeadData());
                break;
            case PUSH:
                //推送布局
                viewHolder.loadImage(R.id.image,homePageBean.getPushData().getPushImg());
                break;
            case ITEM1 :
                //布局样式1
                viewHolder.setGridDate(R.id.grid_view,homePageBean.getClassifies());
                break;
            case ITEM2 :
                //布局样式2

                break;
            case ITEM3 :
                //布局样式3
                break;
            case ITEM4 :
                //布局样式4
                break;
            case ITEM5 :
                //布局样式5
                break;
            case ITEM6 :
                //布局样式6
                break;
            case MORE :
                //底部更多
                break;
        }
    }


    @Override
    public int getItemCount() {
        return homePageBean == null ? 0: homePageBean.getSize();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return HEAD;
        }else if (position == 1){
            return PUSH;
        }else if (position == getItemCount() - 1){
            return MORE;
        }else {
            return homePageBean.getTimeLimitData().get(position).getType();
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SparseArray<View> mViews;

        public ViewHolder(View itemView) {
            super(itemView);
            mViews = new SparseArray<>();
        }

        private  <V extends View> V getView(int id){
            View view = mViews.get(id);
            if (view == null){
                view = itemView.findViewById(id);
                mViews.put(id,view);
            }
            return (V) view;
        }

        public ViewHolder setText(int resId,CharSequence text){
            TextView textView = getView(resId);
            textView.setText(text);
            return this;
        }

        public ViewHolder setTextColor(int resId,int colorId){
            TextView textView = getView(resId);
            textView.setTextColor(mContext.getResources().getColor(colorId));
            return this;
        }

        public ViewHolder setImageResource(int resId, int imageResId){
            ImageView imageView = getView(resId);
            imageView.setImageResource(imageResId);
            return this;
        }

        public ViewHolder loadImage(int resId, String url){
            ImageView imageView = getView(resId);
            GlideuUtil.loadImageView(mContext,url,imageView);
            return this;
        }

        public void setBannerImg(int viewId,List<HomePageBean.HeadData> bannerImg) {
            Banner banner = getView(viewId);
            //设置banner样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            List<String> imgs = new ArrayList<>();
            for (HomePageBean.HeadData headData: bannerImg) {
                imgs.add(headData.getHeadImg());
            }
            banner.setImages(bannerImg);
            //设置banner动画效果
            banner.setBannerAnimation(Transformer.DepthPage);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(1500);
            banner.start();
        }

        public void setGridDate(int viewId,List<HomePageBean.Classify> classifies) {
            GridView gridView = getView(viewId);
            GridViewAdapter adapter = new GridViewAdapter(mContext);
            gridView.setAdapter(adapter);
            adapter.setmData(classifies);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //跳转url
                }
            });
        }
    }


}
