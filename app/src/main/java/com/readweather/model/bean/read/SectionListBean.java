package com.readweather.model.bean.read;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class SectionListBean implements Serializable {

    /**
     * description : 看别人的经历，理解自己的生活
     * id : 1
     * name : 深夜惊奇
     * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String description;
        private int id;
        private String name;
        private String thumbnail;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }


}
