package com.readweather.base;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void datachView();
}
