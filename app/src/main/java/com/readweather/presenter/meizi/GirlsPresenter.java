package com.readweather.presenter.meizi;

import com.readweather.base.BasePresenter;
import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.GankBean;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GirlsPresenter extends BasePresenterImpl<GirlsContract.View> implements GirlsContract.Presenter{

    private DataManager mDataManager;

    public static final int NUM = 20;
    public static final int MORENUM = 10;

    private int currentPage = 1;

    @Inject
    public GirlsPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }


    @Override
    public void getGirlsData() {
        addSubscribe(mDataManager.fetchGrilsBeanInfo(NUM,currentPage++)
                    .compose(RxUtil.<GirlsResponse<List<GankBean>>>rxSchedulerHelper())
                    .compose(RxUtil.<List<GankBean>>handleGank())
                    .subscribeWith(new CommonSubscriber<List<GankBean>>(mView) {
                        @Override
                        public void onNext(List<GankBean> list) {
                            mView.showContent(list);
                        }
                    })
        );
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
