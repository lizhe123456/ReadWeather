package com.readweather.presenter.db;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.presenter.db.contract.LikeContract;

import javax.inject.Inject;

/**
 * Created by lizhe on 2017/9/15 0015.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class LikePresenter extends BasePresenterImpl<LikeContract.View> implements LikeContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public LikePresenter(DataManager mDataManager){
        this.mDataManager = mDataManager;
    }

    @Override
    public void getLikeData() {
        mView.showContent(mDataManager.getLikeList());
    }

    @Override
    public void deleteLikeData(String id) {
        mDataManager.deleteLikeBean(id);
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mDataManager.changeLikeTime(id,time,isPlus);
    }

}
