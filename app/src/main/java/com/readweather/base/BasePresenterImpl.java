package com.readweather.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T>{

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;


    /**
     * 订阅
     */
    protected void addSubscribe(Subscription s){
        if (mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(s);
    }

    /**
     * 解绑
     */
    private void unSubscribe() {
        if (mCompositeSubscription != null){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void datachView() {
        this.mView = null;
        unSubscribe();
    }


}
