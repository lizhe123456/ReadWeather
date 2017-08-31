package com.readweather.presenter.meizi.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.Girl;
import java.util.List;

/**
 * author：lizhe
 * time： 2017-08-30
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public interface MeitiContract {

    interface View extends BaseView {

        void showMeitu(List<Girl> list);

    }

    interface Presenter extends BasePresenter<View> {

        void getMeitu(String url,String realUrl, String fakeRefer);

        void getMeitu(String url);
    }
}
