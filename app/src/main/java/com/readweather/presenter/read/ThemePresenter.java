package com.readweather.presenter.read;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.presenter.read.contract.ThemeListContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ThemePresenter extends BasePresenterImpl<ThemeListContract.View> implements ThemeListContract.Presenter {

    DataManager dataManager;

    @Inject
    public ThemePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getThemeListBean() {
        addSubscribe(dataManager.fetchThemeListInfo()
                    .compose(RxUtil.<ThemeListBean>rxSchedulerHelper())
                    .subscribeWith(new CommonSubscriber<ThemeListBean>(mView){

                        @Override
                        public void onNext(ThemeListBean themeListBean) {
                            mView.showThemeList(themeListBean.getOthers());
                        }
                    })
        );
    }
}
