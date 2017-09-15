package com.readweather.presenter.db.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.RealmLikeBean;

import java.util.List;

/**
 * Created by lizhe on 2017/9/15 0015.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface LikeContract {

    interface View extends BaseView{
        void showContent(List<RealmLikeBean> mList);
    }

    interface Presenter extends BasePresenter<View> {
        void getLikeData();

        void deleteLikeData(String id);

        void changeLikeTime(String id, long time, boolean isPlus);

    }
}
