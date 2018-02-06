package com.readweather.presenter.homepage.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 */

public interface HomePageContract {

    interface View extends BaseView{
        void showContent(List<Object> homeBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getHomePage(String location);
    }

}
