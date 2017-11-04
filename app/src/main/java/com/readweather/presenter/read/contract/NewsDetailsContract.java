package com.readweather.presenter.read.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.read.DetailExtraBean;
import com.readweather.model.bean.read.ZhihuDetailBean;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface NewsDetailsContract {

    interface View extends BaseView{
        void showContent(ZhihuDetailBean zhihuDetailBean);

        void showExtraInfo(DetailExtraBean detailExtraBean);

        void setLikeButtonState(boolean isLiked);
    }

    interface Presenter extends BasePresenter<View>{
        void getDetailData(int id);

        void getExtraData(int id);

        void insertLikeData();

        void deleteLikeData();

        void queryLikeData(int id);

        boolean getNoImageState();

        boolean getAutoCacheState();

    }

}
