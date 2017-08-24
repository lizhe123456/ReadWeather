package com.readweather.utils;

import com.readweather.model.http.exception.ApiException;
import com.readweather.model.http.response.BusResponse;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


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
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper(){
        return new FlowableTransformer<T,T>(){

            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<BusResponse<T>, T>  handleBus(){
        return new FlowableTransformer<BusResponse<T>, T> () {
            @Override
            public Publisher<T> apply(Flowable<BusResponse<T>> upstream) {
                return upstream.flatMap(new Function<BusResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull BusResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.getReason().equals("success")) {
                            return createData(tBaseResponse.getResult());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
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
        public static <T> Flowable<T> createData(final T t) {
            return Flowable.create(new FlowableOnSubscribe<T>() {
                @Override
                public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                    try {
                        emitter.onNext(t);
                        emitter.onComplete();
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }
            }, BackpressureStrategy.BUFFER);
        }
}
