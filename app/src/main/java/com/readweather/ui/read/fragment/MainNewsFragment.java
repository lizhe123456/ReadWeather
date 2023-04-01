package com.readweather.ui.read.fragment;

import android.content.Intent;
import android.view.View;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.presenter.read.NewsListPresenter;
import com.readweather.presenter.read.contract.NewsListContract;
import com.readweather.ui.read.activity.NewsDetailsActivity;
import com.readweather.ui.read.adapter.NewsAdapter;
import com.readweather.utils.DateUtil;
import com.readweather.utils.LogUtil;
import com.readweather.widgets.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class MainNewsFragment extends MvpFragment<NewsListPresenter> implements NewsListContract.View {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    private NewsAdapter mAdapter;
    //日报数据
    private List<NewListBean.StoriesBean> storiesList;
    //头部banner
    private List<NewListBean.TopStoriesBean> topStoriesList;
    private String date;

    @Override
    public void stateError() {

    }

    @Override
    public void setStoriesBean(List<NewListBean.StoriesBean> storiesBeen) {
        storiesList = storiesBeen;
        storiesList.add(0, null);
        mAdapter.addFirstDataSet(storiesList);
        date = DateUtil.getNextDay(storiesBeen.get(storiesBeen.size() - 1).getDate(), "0");
        unLoading();
    }

    @Override
    public void setTopStoriesBean(List<NewListBean.TopStoriesBean> topStoriesBeen) {
        topStoriesList = topStoriesBeen;
        setBanners();
    }

    @Override
    public void showMoreContent(String format, DailyBeforeListBean dailyBeforeListBean) {
        date = dailyBeforeListBean.getDate();
        List<NewListBean.StoriesBean> list = new ArrayList<>();
        list.add(null);
        list.addAll(dailyBeforeListBean.getStories());
        mAdapter.setDate(format);
        mAdapter.addMoreDataSet(list);
        unLoading();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_main_news;
    }

    @Override
    protected void setData() {
        loading();
        mPresenter.getNewsList();
        //如果布局大小一致有利于优化
        recyclerView.setHasFixedSize(true);

        //使用线性布局管理器
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        mAdapter = new NewsAdapter(getContext());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    //加载更多功能的代码
                    getMore();
                }
            }
        });
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                NewListBean.StoriesBean bean = (NewListBean.StoriesBean) item;
                Intent intent = new Intent();
                intent.putExtra("id",bean.getId());
                intent.setClass(getContext(), NewsDetailsActivity.class);
                startActivity(intent);
            }
        });




    }

    public void getMore() {
        mPresenter.getBeforeData(date);
        loading();
    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    private void setBanners() {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < topStoriesList.size(); i++) {
            images.add(topStoriesList.get(i).getImage());
            titles.add(topStoriesList.get(i).getTitle());
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


}
