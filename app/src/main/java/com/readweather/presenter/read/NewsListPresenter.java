package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.presenter.read.contract.NewsListContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by lizhe on 2017/10/23 0023.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class NewsListPresenter extends BasePresenterImpl<NewsListContract.View> implements NewsListContract.Presenter {


    DataManager dataManager;

    @Inject
    public NewsListPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getNewsList() {
        addSubscribe(dataManager.fetchNewsListInfo()
                .compose(RxUtil.<NewListBean>rxSchedulerHelper())
                .map(new Function<NewListBean, NewListBean>() {
                    @Override
                    public NewListBean apply(@NonNull NewListBean newListBean) throws Exception {
                        List<NewListBean.StoriesBean> list = newListBean.getStories();
                        for(NewListBean.StoriesBean item : list) {
                            item.setReadState(dataManager.queryNewsId(item.getId()));
                        }
                        return newListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<NewListBean>(mView) {
                    @Override
                    public void onNext(NewListBean dailyListBean) {
                        NewListBean.StoriesBean storiesBean = dailyListBean.getStories().get(dailyListBean.getStories().size()-1);
                        storiesBean.setDate(dailyListBean.getDate());
                        List<NewListBean.StoriesBean> list = dailyListBean.getStories();
                        list.remove(dailyListBean.getStories().size()-1);
                        list.add(storiesBean);
                        mView.setStoriesBean(list);
                        mView.setTopStoriesBean(dailyListBean.getTop_stories());
                    }
                })
        );
    }


    @Override
    public void insertReadToDB(int id) {
        dataManager.insertNewId(id);
    }

    @Override
    public void getBeforeData(String data) {
        addSubscribe(dataManager.fetchDailyBeforeListInfo(data)
                .compose(RxUtil.<DailyBeforeListBean>rxSchedulerHelper())
                .map(new Function<DailyBeforeListBean, DailyBeforeListBean>() {

                    @Override
                    public DailyBeforeListBean apply(@NonNull DailyBeforeListBean dailyBeforeListBean) throws Exception {
                        List<NewListBean.StoriesBean> list = dailyBeforeListBean.getStories();
                        for(NewListBean.StoriesBean item : list) {
                            item.setReadState(dataManager.queryNewsId(item.getId()));
                        }
                        return dailyBeforeListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<DailyBeforeListBean>(mView){

                    @Override
                    public void onNext(DailyBeforeListBean dailyBeforeListBean) {
                        int year = Integer.valueOf(dailyBeforeListBean.getDate().substring(0,4));
                        int month = Integer.valueOf(dailyBeforeListBean.getDate().substring(4,6));
                        int day = Integer.valueOf(dailyBeforeListBean.getDate().substring(6,8));
                        mView.showMoreContent(String.format("%d年%d月%d日",year,month,day),dailyBeforeListBean);
                    }
                })
        );
    }

}
