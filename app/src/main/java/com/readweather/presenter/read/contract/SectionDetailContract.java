package com.readweather.presenter.read.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.read.SectionListDetailBean;

/**
 * Created by lizhe on 2017/11/18 0018.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface SectionDetailContract {

    interface View extends BaseView{
        void showContent(SectionListDetailBean bean);
    }

    interface Presenter extends BasePresenter<View>{
        void getSectionDetail(int id);
    }
}
