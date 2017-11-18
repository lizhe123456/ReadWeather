package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.SectionListDetailBean;
import com.readweather.presenter.read.contract.SectionDetailContract;
import com.readweather.presenter.read.contract.SectionListContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/11/18 0018.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class SectionDetailPresenter extends BasePresenterImpl<SectionDetailContract.View> implements SectionDetailContract.Presenter{

    DataManager dataManager;

    @Inject
    public SectionDetailPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getSectionDetail(int id) {
        addSubscribe(dataManager.fetchSectionListDetailInfo(id)
                .compose(RxUtil.<SectionListDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<SectionListDetailBean>(mView) {
                    @Override
                    public void onNext(SectionListDetailBean bean) {
                        mView.showContent(bean);
                    }
                })
        );
    }
}
