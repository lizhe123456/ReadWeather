package com.readweather.presenter.meizi.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.Girl;

import java.util.List;

/**
 * Created by lizhe on 2017/10/13 0013.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface MeitusContract {

    interface View extends BaseView {

        void showMeitu(List<Girl> list);

        void getMeiziFromServer(int page);

    }

    interface Presenter extends BasePresenter<View> {

        void getMeitus(String url,String realUrl, String fakeRefer);

        void getMeitus(String url,int totalPages);
    }
}
