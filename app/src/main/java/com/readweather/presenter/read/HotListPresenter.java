package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.presenter.read.contract.HotListContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class HotListPresenter extends BasePresenterImpl<HotListContract.View> implements HotListContract.Presenter{

    DataManager dataManager;

    @Inject
    public HotListPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void insertReadToDB(int id) {
        dataManager.insertNewId(id);
    }

    @Override
    public void getHotList() {
        addSubscribe(dataManager.fetchHotListBeanInfo()
                .compose(RxUtil.<HotListBean>rxSchedulerHelper())
                .map(new Function<HotListBean, HotListBean>() {
                    @Override
                    public HotListBean apply(@NonNull HotListBean newListBean) throws Exception {
                        List<HotListBean.RecentBean> list = newListBean.getRecent();
                        for(HotListBean.RecentBean item : list) {
                            item.setReadState(dataManager.queryNewsId(item.getNews_id()));
                        }
                        return newListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<HotListBean>(mView) {
                    @Override
                    public void onNext(HotListBean bean) {
                        mView.showHotList(bean.getRecent());
                    }
                })
        );
    }
}
