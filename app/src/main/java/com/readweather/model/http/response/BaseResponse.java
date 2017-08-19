package com.readweather.model.http.response;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class BaseResponse<T> {

    private String reason;

    private T result;

    private String error;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
