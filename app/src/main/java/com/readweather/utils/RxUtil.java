package com.readweather.utils;

import com.readweather.model.bean.Girl;
import com.readweather.model.http.exception.ApiException;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.http.response.GirlsResponse;
import com.readweather.model.http.response.JiandanResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.reactivestreams.Publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            public Flowable<T> apply(Flowable<BusResponse<T>> upstream) {
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

    public static <T> FlowableTransformer<GirlsResponse<T>, T>  handleGank(){
        return new FlowableTransformer<GirlsResponse<T>, T> () {
            @Override
            public Flowable<T> apply(Flowable<GirlsResponse<T>> upstream) {
                return upstream.flatMap(new Function<GirlsResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull GirlsResponse<T> tBaseResponse) throws Exception {
                        if (!tBaseResponse.isError()) {
                            return createData(tBaseResponse.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    public static <T> FlowableTransformer<JiandanResponse<T>, T> handleJiandan(){
        return new FlowableTransformer<JiandanResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<JiandanResponse<T>> upstream) {
                return upstream.flatMap(new Function<JiandanResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull JiandanResponse<T> tJiandanResponse) throws Exception {
                        if (tJiandanResponse.getStatus().equals("ok")){
                            return createData(tJiandanResponse.getComments());
                        }else {
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
