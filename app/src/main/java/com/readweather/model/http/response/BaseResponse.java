package com.readweather.model.http.response;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class BaseResponse<T> {

    private String reason;

    private T result;

    private String error;

}
