package com.readweather.model.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * author：lizhe
 * time： 2017-08-29
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class JiandanResponse<T> implements Serializable{

    public String status;
    public int current_page;
    public int total_comments;
    public int page_count;
    public int count;
    private T comments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(int total_comments) {
        this.total_comments = total_comments;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getComments() {
        return comments;
    }

    public void setComments(T comments) {
        this.comments = comments;
    }
}
