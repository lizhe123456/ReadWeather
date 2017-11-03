package com.readweather.ui.read.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.presenter.read.NewsListPresenter;
import com.readweather.presenter.read.contract.NewsListContract;
import com.readweather.ui.read.adapter.NewsAdapter;
import com.readweather.widgets.GlideImageLoader;
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
    private NewsAdapter mAdapter;
    //日报数据
    private List<NewListBean.StoriesBean> storiesList;
    //头部banner
    private List<NewListBean.TopStoriesBean> topStoriesList;

    @Override
    public void stateError() {

    }

    @Override
    public void setStoriesBean(List<NewListBean.StoriesBean> storiesBeen) {
        storiesList = storiesBeen;
        storiesList.add(0,null);
        mAdapter.addFirstDataSet(storiesList);
    }

    @Override
    public void setTopStoriesBean(List<NewListBean.TopStoriesBean> topStoriesBeen) {
        topStoriesList = topStoriesBeen;
        setBanners();
    }

    @Override
    public void showMoreContent(String format, DailyBeforeListBean dailyBeforeListBean) {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_main_news;
    }

    @Override
    protected void setData() {
        mPresenter.getNewsList();
        //如果布局大小一致有利于优化
        recyclerView.setHasFixedSize(true);

        //使用线性布局管理器
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layout);

        mAdapter = new NewsAdapter(getContext());
        recyclerView.setAdapter(mAdapter);
    }

    private void setBanners(){
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
