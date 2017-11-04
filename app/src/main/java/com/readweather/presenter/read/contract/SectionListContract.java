package com.readweather.presenter.read.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.read.SectionListBean;

import java.util.List;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface SectionListContract {

    interface View extends BaseView{
        void showSectionList(List<SectionListBean.DataBean> bean);
    }

    interface Presenter extends BasePresenter<View>{
        void getSectionList();
    }
}
