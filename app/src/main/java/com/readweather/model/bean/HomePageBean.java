package com.readweather.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */

public class HomePageBean {

    private int size;

    private List<HeadData> headData;
    private List<Classify> classifies;
    private PushData pushData;
    private List<TimeLimitData> timeLimitData;
    private List<MoreData> moreData;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<HeadData> getHeadData() {
        return headData;
    }

    public void setHeadData(List<HeadData> headData) {
        this.headData = headData;
    }

    public PushData getPushData() {
        return pushData;
    }

    public void setPushData(PushData pushData) {
        this.pushData = pushData;
    }

    public List<TimeLimitData> getTimeLimitData() {
        return timeLimitData;
    }

    public void setTimeLimitData(List<TimeLimitData> timeLimitData) {
        this.timeLimitData = timeLimitData;
    }

    public List<Classify> getClassifies() {
        return classifies;
    }

    public void setClassifies(List<Classify> classifies) {
        this.classifies = classifies;
    }

    public List<MoreData> getMoreData() {
        return moreData;
    }

    public void setMoreData(List<MoreData> moreData) {
        this.moreData = moreData;
    }

    public class Classify implements Serializable{
        String gridImg;
        String gridText;

        public String getGridImg() {
            return gridImg;
        }

        public void setGridImg(String gridImg) {
            this.gridImg = gridImg;
        }

        public String getGridText() {
            return gridText;
        }

        public void setGridText(String gridText) {
            this.gridText = gridText;
        }
    }

    public class HeadData implements Serializable{
        String headImg;
        String headUrl;

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }
    }

    public class PushData implements Serializable{
        String pushImg;
        String pushUrl;

        public String getPushImg() {
            return pushImg;
        }

        public void setPushImg(String pushImg) {
            this.pushImg = pushImg;
        }

        public String getPushUrl() {
            return pushUrl;
        }

        public void setPushUrl(String pushUrl) {
            this.pushUrl = pushUrl;
        }
    }

    public class TimeLimitData implements Serializable{
        int type;
        String title;
        String color;
        List<ItemData> list;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public List<ItemData> getList() {
            return list;
        }

        public void setList(List<ItemData> list) {
            this.list = list;
        }

        public class ItemData implements Serializable{
            String itemUrl;
            String itemImg;
            int type;

            public String getItemUrl() {
                return itemUrl;
            }

            public void setItemUrl(String itemUrl) {
                this.itemUrl = itemUrl;
            }

            public String getItemImg() {
                return itemImg;
            }

            public void setItemImg(String itemImg) {
                this.itemImg = itemImg;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

    }

    public class MoreData implements Serializable{

    }

}
