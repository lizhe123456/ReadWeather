package com.readweather.presenter.read.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.read.ThemeNewsDetailBean;

/**
 * Created by lizhe on 2017/11/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface ThemeDetailContract {

    interface View extends BaseView{
        void showContent(ThemeNewsDetailBean bean);
    }

    interface Presenter extends BasePresenter<View>{
        void getThemeDetail(int id);
    }
}
