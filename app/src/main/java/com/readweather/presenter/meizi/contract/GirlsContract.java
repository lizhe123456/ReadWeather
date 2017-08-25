package com.readweather.presenter.meizi.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.GankBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public interface GirlsContract {

    interface View extends BaseView {

        void showContent(List<GankBean> list);

        void showMore(List<GankBean> list);
    }

    interface Presenter extends BasePresenter<View> {

        void getGirlsData();

        void getMore();
    }

}
