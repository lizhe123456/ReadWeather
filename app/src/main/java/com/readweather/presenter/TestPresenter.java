package com.readweather.presenter;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.http.response.BaseResponse;
import com.readweather.presenter.contract.TestContract;
import com.readweather.utils.RxUtil;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public class TestPresenter extends BasePresenterImpl<TestContract.View> implements TestContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public TestPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getTest() {
        addSubscribe(mDataManager.fetchBusNumberBeanInfo("027","560")
                        .compose(RxUtil.<BaseResponse<BusNumberBean>>rxSchedulerHelper())
                        .compose(RxUtil.<BusNumberBean>handleBus())
                        .subscribe(new Action1<BusNumberBean>() {
                            @Override
                            public void call(BusNumberBean busNumberBean) {
                                mView.setTest("数据成功街道");
                            }
                        })
        );
    }
}
