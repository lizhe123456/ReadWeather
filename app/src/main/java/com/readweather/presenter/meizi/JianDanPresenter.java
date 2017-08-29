package com.readweather.presenter.meizi;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.JiandanBean;
import com.readweather.model.http.response.JiandanResponse;
import com.readweather.presenter.meizi.contract.JianDanContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * author：lizhe
 * time： 2017-08-29
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class JianDanPresenter extends BasePresenterImpl<JianDanContract.View> implements JianDanContract.Presenter {

    private DataManager mDataManager;

    private int PAGE = 1;


    @Inject
    public JianDanPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getJIanDan() {
        addSubscribe(mDataManager.fetchJiandanInfo(PAGE)
                    .compose(RxUtil.<JiandanResponse<List<JiandanBean>>>rxSchedulerHelper())
                    .compose(RxUtil.<List<JiandanBean>>handleJiandan())
                    .subscribeWith(new CommonSubscriber<List<JiandanBean>>(mView) {
                        @Override
                        public void onNext(List<JiandanBean> list) {
                            mView.showJianDan(list);
                        }
                    })
        );
    }

    @Override
    public void getMore() {
        addSubscribe(mDataManager.fetchJiandanInfo(++PAGE)
                .compose(RxUtil.<JiandanResponse<List<JiandanBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<JiandanBean>>handleJiandan())
                .subscribeWith(new CommonSubscriber<List<JiandanBean>>(mView) {
                    @Override
                    public void onNext(List<JiandanBean> list) {
                        mView.showJianDan(list);
                    }
                })
        );
    }
}
