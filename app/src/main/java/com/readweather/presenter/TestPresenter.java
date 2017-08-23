//package com.readweather.presenter;
//
//import com.readweather.base.BasePresenterImpl;
//import com.readweather.model.DataManager;
//import com.readweather.model.bean.BusNumberBean;
//import com.readweather.model.http.response.BusResponse;
//import com.readweather.presenter.contract.TestContract;
//import com.readweather.utils.RxUtil;
//import com.readweather.widgets.CommonSubscriber;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//
///**
// * Created by Administrator on 2017/8/19 0019.
// */
//
//public class TestPresenter extends BasePresenterImpl<TestContract.View> implements TestContract.Presenter {
//
//    private DataManager mDataManager;
//
//    @Inject
//    public TestPresenter(DataManager mDataManager) {
//        this.mDataManager = mDataManager;
//    }
//
//    @Override
//    public void getTest() {
//        addSubscribe(mDataManager.fetchBusNumberBeanInfo("027","560")
//                        .compose(RxUtil.<BusResponse<List<BusNumberBean>>>rxSchedulerHelper())
//                        .compose(RxUtil.<List<BusNumberBean>>handleBus())
//                        .subscribeWith(new CommonSubscriber<List<BusNumberBean>>(mView, false) {
//                            @Override
//                            public void onNext(List<BusNumberBean> busNumberBeanList) {
//                                mView.setTest("chenggong");
//                            }
//                        })
//        );
//    }
//
//
//}
