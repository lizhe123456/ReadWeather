package com.readweather.model.http.response;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GirlsResponse<T> {

    public boolean error;
    public T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
