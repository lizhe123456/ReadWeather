package com.readweather.presenter.read.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.read.NewListBean;

import java.util.List;

/**
 * Created by lizhe on 2017/10/23 0023.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface NewsListContract {

    interface View extends BaseView{

        void setStoriesBean(List<NewListBean.StoriesBean> storiesBeen);

        void setTopStoriesBean(List<NewListBean.TopStoriesBean> topStoriesBeen);
    }

    interface Presenter extends BasePresenter<View>{

        void getNewsList();

        void insertReadToDB(int id);

    }

}
