package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.presenter.read.contract.SectionListContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class SectionPresenter extends BasePresenterImpl<SectionListContract.View> implements SectionListContract.Presenter {

    DataManager dataManager;

    @Inject
    public SectionPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getSectionList() {
        addSubscribe(dataManager.fetchSectionListInfo()
                .compose(RxUtil.<SectionListBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<SectionListBean>(mView) {
                    @Override
                    public void onNext(SectionListBean bean) {
                        mView.showSectionList(bean.getData());
                    }
                })
        );
    }
}
