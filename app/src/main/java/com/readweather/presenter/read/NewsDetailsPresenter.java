package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.ZhihuDetailBean;
import com.readweather.presenter.read.contract.NewsDetailsContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class NewsDetailsPresenter extends BasePresenterImpl<NewsDetailsContract.View> implements NewsDetailsContract.Presenter{

    DataManager dataManager;

    ZhihuDetailBean bean;

    @Inject
    public NewsDetailsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getDetailData(int id) {
        addSubscribe(dataManager.fetchNewsDailyInfo(id)
                .compose(RxUtil.<ZhihuDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<ZhihuDetailBean>(mView) {
                    @Override
                    public void onNext(ZhihuDetailBean zhihuDetailBean) {
                        mView.showContent(zhihuDetailBean);
                    }
                })
        );
    }

    @Override
    public void getExtraData(int id) {

    }

    @Override
    public void insertLikeData() {

    }

    @Override
    public void deleteLikeData() {

    }

    @Override
    public void queryLikeData(int id) {

    }

    @Override
    public boolean getNoImageState() {
        return false;
    }

    @Override
    public boolean getAutoCacheState() {
        return false;
    }


}
