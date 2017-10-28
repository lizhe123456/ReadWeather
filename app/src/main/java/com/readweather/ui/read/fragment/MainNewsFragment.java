package com.readweather.ui.read.fragment;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.presenter.read.NewsListPresenter;
import com.readweather.presenter.read.contract.NewsListContract;

import java.util.List;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class MainNewsFragment extends MvpFragment<NewsListPresenter> implements NewsListContract.View{

    @Override
    public void stateError() {

    }

    @Override
    public void setStoriesBean(List<NewListBean.StoriesBean> storiesBeen) {

    }

    @Override
    public void setTopStoriesBean(List<NewListBean.TopStoriesBean> topStoriesBeen) {

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

    }

    @Override
    protected void initInject() {

    }

}
