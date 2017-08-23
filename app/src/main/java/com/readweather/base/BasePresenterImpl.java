package com.readweather.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T>{

    protected T mView;
    protected CompositeDisposable mCompositeDisposable;


    /**
     * 订阅
     */
    protected void addSubscribe(Disposable s){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(s);
    }

    /**
     * 解绑
     */
    private void unSubscribe() {
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
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
