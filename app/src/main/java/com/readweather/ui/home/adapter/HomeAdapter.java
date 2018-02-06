package com.readweather.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.readweather.R;
import com.readweather.app.App;
import com.readweather.model.bean.TodayOnhistory;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.ui.read.adapter.ColumnAdapter;
import com.readweather.ui.read.adapter.ThemeAdapter;
import com.readweather.utils.GlideuUtil;
import com.readweather.view.RGridView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/1/26.
 * 类介绍：
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private List<Object> homeBean;
    private Context mContext;
    private LayoutInflater mInflater;

    private final static int WEATHER = 0;
    private final static int THEME = 1;
    private final static int SECTION = 2;
    private final static int TODAYONHISTORY = 3;
    private final static int NEW = 4;
    private final static int MORE = 5;

    public HomeAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void addData(List<Object> list){
        if (homeBean == null){
            homeBean = list;
        }else {
            homeBean.clear();
            homeBean.addAll(list);
        }
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        ViewHolder viewHolder1 = null;
        ViewHolder viewHolder2 = null;
        ViewHolder viewHolder3 = null;
        ViewHolder viewHolder4 = null;
        ViewHolder viewHolder5 = null;
        ViewHolder viewHolder9 = null;
        if (getItemViewType(position) == WEATHER){
            //头部布局
            if (viewHolder1 == null){
                View view = mInflater.inflate(R.layout.head_weather,null);
                viewHolder1 = new ViewHolder(view);
            }
            return viewHolder1;
        }else if (getItemViewType(position) == THEME){
            //推送布局
            if (viewHolder2 == null){
                View view = mInflater.inflate(R.layout.push_theme,null);
                viewHolder2 = new ViewHolder(view);
            }
            return viewHolder2;
        }else if (getItemViewType(position) == SECTION){
            //布局样式1
            if (viewHolder3 == null){
                View view = mInflater.inflate(R.layout.home_section,null);
                viewHolder3 = new ViewHolder(view);
            }
            return viewHolder3;
        }else if (getItemViewType(position) == TODAYONHISTORY){
            //布局样式2
            if (viewHolder4 == null){
                View view = mInflater.inflate(R.layout.home_today,null);
                viewHolder4 = new ViewHolder(view);
            }
            return viewHolder4;
        }else if (getItemViewType(position) == NEW){
            //布局样式3
            if (viewHolder5 == null){
                View view = mInflater.inflate(R.layout.home_new,null);
                viewHolder5 = new ViewHolder(view);
            }
            return viewHolder5;
        }else if (getItemViewType(position) == MORE){
            //底部更多
            if (viewHolder9 == null){
                View view = mInflater.inflate(R.layout.home_more,null);
                viewHolder9 = new ViewHolder(view);
            }
            return viewHolder9;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)) {
            case WEATHER :
                WeatherBean weatherBean = (WeatherBean) homeBean.get(position);
                String num = weatherBean.getDaily_forecast().get(0).getTmp_min() + " ~ " + weatherBean.getDaily_forecast().get(0).getTmp_max()+ " ℃";
                String code = weatherBean.getNow().getCond_code();
                viewHolder.setText(R.id.tv_update,weatherBean.getUpdate().getLoc());
                viewHolder.setText(R.id.tv_address,weatherBean.getBasic().getParent_city());
                viewHolder.setText(R.id.tv_cond_txt,weatherBean.getNow().getCond_txt());
                viewHolder.setText(R.id.tv_num,num);
                viewHolder.setText(R.id.tv_now,"当前：" + weatherBean.getNow().getTmp() + " ℃");

                viewHolder.setWeatherGridDate(R.id.grid,weatherBean.getDaily_forecast());
                //设置背景
//                viewHolder.setBackgroundResource(R.id.weather_bg,100);
                break;
            case THEME:
                ThemeListBean themeListBean = (ThemeListBean) homeBean.get(position);
                viewHolder.setThemeList(R.id.recyclerView_theme,themeListBean.getOthers());
                break;
            case SECTION :
                SectionListBean sectionListBean = (SectionListBean) homeBean.get(position);
                viewHolder.setSectionList(R.id.recyclerView_section,sectionListBean.getData());
                break;
            case TODAYONHISTORY :
                TodayOnhistory todayOnhistory = (TodayOnhistory) homeBean.get(position);

                break;
            case NEW :
                NewListBean newListBean = (NewListBean) homeBean.get(position);

                break;
            case MORE :
                //底部更多
                viewHolder.setMoreItem(R.id.more);

                break;
        }
    }


    @Override
    public int getItemCount() {
        return homeBean == null ? 0: homeBean.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        Object object = homeBean.get(position);
        if (object instanceof WeatherBean){
            return WEATHER;
        }else if (object instanceof ThemeListBean){
            return THEME;
        }else if (object instanceof NewListBean){
            return NEW;
        }else if (object instanceof SectionListBean){
            return SECTION;
        }else if (object instanceof TodayOnhistory){
            return TODAYONHISTORY;
        }
        return MORE;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SparseArray<View> mViews;

        public ViewHolder(View itemView) {
            super(itemView);
            mViews = new SparseArray<>();
        }

        public  <V extends View> V getView(int id){
            View view = mViews.get(id);
            if (view == null){
                view = itemView.findViewById(id);
                mViews.put(id,view);
            }
            return (V) view;
        }

        public ViewHolder setBackgroundResource(int resId,int url){
            View view = getView(resId);
            view.setBackgroundResource(url);
            return this;
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


        public void setWeatherGridDate(int viewId,List<WeatherBean.DailyForecastBean> classifies) {
            GridView gridView = getView(viewId);
            WeatherGridViewAdapter adapter = new WeatherGridViewAdapter(mContext);
            // item宽度
            int itemWidth;
            //item之间的间隔
            int itemPaddingH = DensityUtil.dp2px(10);
            if (classifies.size() < 5) {
                itemWidth = (App.SCREEN_WIDTH - itemPaddingH * 2) / classifies.size();
            }else {
                itemWidth = (int) ((App.SCREEN_WIDTH - itemPaddingH * 2)  / 4.5);
            }

            //计算GridView宽度
            int gridviewWidth = classifies.size() * itemWidth;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    gridviewWidth, DensityUtil.dp2px(100));
            gridView.setLayoutParams(params);
            gridView.setColumnWidth(itemWidth);
            gridView.setStretchMode(GridView.NO_STRETCH);
            gridView.setNumColumns(classifies.size());
            gridView.setAdapter(adapter);
            adapter.addList(classifies);
        }

        public void setMoreItem(int viewId) {
            TextView tvMore = getView(viewId);
            tvMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "没有更多了...", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setThemeList(int viewId,List<ThemeListBean.OthersBean> data) {
            ThemeAdapter adapter = new ThemeAdapter(mContext);
            List<ThemeListBean.OthersBean> adapterData = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                adapterData.add(data.get(i));
            }
            RecyclerView recyclerView = getView(viewId);
            StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
            adapter.addFirstDataSet(adapterData);
        }

        public void setSectionList(int viewId, List<SectionListBean.DataBean> data) {
            ColumnAdapter columnAdapter = new ColumnAdapter(mContext);
            List<SectionListBean.DataBean> adapterData = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                adapterData.add(data.get(i));
            }
            RecyclerView recyclerView = getView(viewId);
            StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(columnAdapter);
            columnAdapter.addFirstDataSet(adapterData);
        }
    }


}
