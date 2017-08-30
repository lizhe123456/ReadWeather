package com.readweather.presenter.meizi.contract;

import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.model.bean.JiandanBean;

import java.util.List;


/**
 * author：lizhe
 * time： 2017-08-29
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public interface JianDanContract {

    interface View extends BaseView{

        void showJianDan(List<JiandanBean> list);

    }

    interface Presenter extends BasePresenter<View>{

        void getJIanDan();

    }

}
