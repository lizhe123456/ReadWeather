package com.readweather.utils;

import com.readweather.model.http.exception.ApiException;
import com.readweather.model.http.response.BaseResponse;

import rx.Emitter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Function;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/19 0019.
 * Rx帮助类，统一返回结果集
 */

public class RxUtil {

    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T,T> rxSchedulerHelper(){
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<BaseResponse<T>,T> handleBus(){
        return new Observable.Transformer<BaseResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResponse<T>> baseResponseObservable) {
                return baseResponseObservable.flatMap(new Func1<BaseResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(BaseResponse<T> tBaseResponse) {
                        if (!tBaseResponse.getError().equals("")){
                            return Observable.error(new ApiException("服务器返回error"));
                        }else {
                            return createData(tBaseResponse.getResult());
                        }
                    }
                });
            }

        };
    }


    /**
     * 生成Flowable
     * @param <T>
     * @return
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new Action1<Emitter<T>>() {
            @Override
            public void call(Emitter<T> tEmitter) {
                try {
                    tEmitter.onNext(t);
                    tEmitter.onCompleted();
                } catch (Exception e) {
                    tEmitter.onError(e);
                }
            }
        }, Emitter.BackpressureMode.BUFFER);
    }
}
