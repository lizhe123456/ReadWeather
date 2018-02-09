package com.readweather.ui.home.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.readweather.R;
import com.readweather.app.App;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.TodayOnhistory;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.ui.read.adapter.ColumnAdapter;
import com.readweather.ui.read.adapter.ThemeAdapter;
import com.readweather.view.LooperTextView;
import com.readweather.view.adpter.LooperTextAdapter;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/1/26.
 * 类介绍：
 */

public class HomeAdapter extends BaseAdapter<Object> {

    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, Object item, int position) {
        if (item instanceof WeatherBean){
            WeatherBean weatherBean = (WeatherBean) item;
            String num = weatherBean.getDaily_forecast().get(0).getTmp_min() + " ~ " + weatherBean.getDaily_forecast().get(0).getTmp_max()+ " ℃";
            String code = weatherBean.getNow().getCond_code();
            holder.setText(R.id.tv_update,weatherBean.getUpdate().getLoc());
            holder.setText(R.id.tv_address,weatherBean.getBasic().getParent_city());
            holder.setText(R.id.tv_cond_txt,weatherBean.getNow().getCond_txt());
            holder.setText(R.id.tv_num,num);
            holder.setText(R.id.tv_now,"当前：" + weatherBean.getNow().getTmp() + " ℃");
            setWeatherGridDate(holder,weatherBean.getDaily_forecast());
            //设置背景
//                viewHolder.setBackgroundResource(R.id.weather_bg,100);
        }else if (item instanceof ThemeListBean){
            ThemeListBean themeListBean = (ThemeListBean) item;
            setThemeList(holder,themeListBean.getOthers());
        }else if (item instanceof NewListBean){
            NewListBean newListBean = (NewListBean) item;
            setNewList(holder,newListBean.getTop_stories());
        }else if (item instanceof SectionListBean){
            SectionListBean sectionListBean = (SectionListBean) item;
            setSectionList(holder,sectionListBean.getData());
        }else if (item instanceof TodayOnhistory){
            TodayOnhistory todayOnhistory = (TodayOnhistory) item;
            setTodayOnhistory(holder,todayOnhistory.getResult());
        }else if (item == null){
            setMoreItem(holder);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, Object item) {
        Object object;
        try{
            object = getDataSource().get(position);
        }catch (IndexOutOfBoundsException e){
            object = null;
        }
        if (object instanceof WeatherBean){
            return R.layout.head_weather;
        }else if (object instanceof ThemeListBean){
            return R.layout.push_theme;
        }else if (object instanceof NewListBean){
            return R.layout.home_new;
        }else if (object instanceof SectionListBean){
            return R.layout.home_section;
        }else if (object instanceof TodayOnhistory){
            return R.layout.home_today;
        }else if (object == null){
            return R.layout.home_more;
        }
        return -1;
    }

    public void setWeatherGridDate(BaseViewHolder holder,List<WeatherBean.DailyForecastBean> classifies) {
        GridView gridView = holder.getView(R.id.grid);
        WeatherGridViewAdapter adapter = new WeatherGridViewAdapter(getContext());
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

    public void setMoreItem(BaseViewHolder holder) {
        TextView tvMore = holder.getView(R.id.more);
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "没有更多了...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setThemeList(BaseViewHolder holder,List<ThemeListBean.OthersBean> data) {
        TextView textView = holder.getView(R.id.tv_title);
        textView.setText("主题");
        LinearLayout itemGo = holder.getView(R.id.item_go);
        itemGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ThemeHomeAdapter adapter = new ThemeHomeAdapter(getContext());
        List<ThemeListBean.OthersBean> adapterData = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adapterData.add(data.get(i));
        }
        RecyclerView recyclerView = holder.getView(R.id.recyclerView_theme);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(adapterData);
    }

    public void setSectionList(BaseViewHolder holder, List<SectionListBean.DataBean> data) {
        TextView textView = holder.getView(R.id.tv_title);
        textView.setText("专栏");
        LinearLayout itemGo = holder.getView(R.id.item_go);
        itemGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        SectionAdapter columnAdapter = new SectionAdapter(getContext());
        List<SectionListBean.DataBean> adapterData = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adapterData.add(data.get(i));
        }
        RecyclerView recyclerView = holder.getView(R.id.recyclerView_section);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        recyclerView.setAdapter(columnAdapter);
        columnAdapter.addFirstDataSet(adapterData);
    }

    private void setNewList(BaseViewHolder holder, List<NewListBean.TopStoriesBean> top_stories) {
        RecyclerView recyclerView = holder.getView(R.id.recyclerView_new);
        TextView mTvTitle = holder.getView(R.id.tv_title);
        mTvTitle.setText("日报");
        LinearLayout itemGo = holder.getView(R.id.item_go);
        itemGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        HomeNewAdapter homeNewAdapter = new HomeNewAdapter(getContext());
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeNewAdapter);
        homeNewAdapter.addFirstDataSet(top_stories);
    }

    private void setTodayOnhistory(BaseViewHolder holder, List<TodayOnhistory.ResultBean> result) {
        if (result == null){
            return;
        }
        LooperTextView looperTextView = holder.getView(R.id.looper_view);
        TodayAdapter adapter = new TodayAdapter(getContext(),result);
        looperTextView.setAdapter(adapter);
        looperTextView.setOnLooperItemClickListener(new LooperTextView.OnLooperItemClickListener() {
            @Override
            public void onLooperItemClick(int position) {

            }
        });

    }
    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }

        }

        public SpaceItemDecoration(int space) {
            this.mSpace = space;
        }
    }
}
