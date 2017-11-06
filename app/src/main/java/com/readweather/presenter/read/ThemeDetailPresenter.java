package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.ThemeNewsDetailBean;
import com.readweather.presenter.read.contract.ThemeDetailContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/11/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ThemeDetailPresenter extends BasePresenterImpl<ThemeDetailContract.View>
        implements ThemeDetailContract.Presenter {

    DataManager dataManager;

    @Inject
    public ThemeDetailPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getThemeDetail(int id) {
        addSubscribe(dataManager.fetchThemeDetailListInfo(id)
                .compose(RxUtil.<ThemeNewsDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<ThemeNewsDetailBean>(mView) {
                    @Override
                    public void onNext(ThemeNewsDetailBean bean) {
                        mView.showContent(bean);
                    }
                })
        );
    }

}
