package com.readweather.base;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface BaseView {

    void showErrorMsg(String msg);


    void stateError();

    void loading();

    void unLoading();

}
