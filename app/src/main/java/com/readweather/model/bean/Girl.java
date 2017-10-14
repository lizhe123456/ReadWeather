package com.readweather.model.bean;

import java.io.Serializable;

/**
 * Created by liyu on 2016/12/9.
 */

public class Girl implements Serializable {
    private String id;
    private String url;
    private int width = 0;
    private int height = 0;
    private String link;//仅妹子图网站需要

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Girl(String id,String url) {
        this.id = id;
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
