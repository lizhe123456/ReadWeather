package com.readweather.model.bean.read;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2017/10/23 0023.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class NewListBean implements Serializable {


    /**
     * date : 20171023
     * stories : [{"images":["https://pic3.zhimg.com/v2-18a6604e08b5e90954802424008e7ba2.jpg"],"type":0,"id":9653431,"ga_prefix":"102315","title":"面试的时候，如何判断面试官的水平？"},{"images":["https://pic2.zhimg.com/v2-71d5b4ff993397a97310808e38085fa9.jpg"],"type":0,"id":9653148,"ga_prefix":"102314","title":"银行卡被异地盗刷了，做好这几点，钱才有可能赔给你"},{"images":["https://pic1.zhimg.com/v2-33815c80895f6877ae582dcb0849b7f8.jpg"],"type":0,"id":9653377,"ga_prefix":"102313","title":"扒一扒《王牌特工 2》反派这几身搭配，不亚于英伦绅士风的精彩"},{"images":["https://pic3.zhimg.com/v2-4ccd50fdd1732d44e76e5b3b322d2aa2.jpg"],"type":0,"id":9652902,"ga_prefix":"102312","title":"大误 · 游戏嘛，别太认真"},{"images":["https://pic2.zhimg.com/v2-6275dd7ff11d7544ea87f57f99142865.jpg"],"type":0,"id":9653411,"ga_prefix":"102311","title":"「drug」 同时表示毒品和药品，外国人不觉得尴尬吗？"},{"images":["https://pic1.zhimg.com/v2-80b6d7460536ca60d5d15329d02cf220.jpg"],"type":0,"id":9653316,"ga_prefix":"102310","title":"还在为房子太小、空间利用率低发愁的你，可能需要两个玄关"},{"images":["https://pic4.zhimg.com/v2-fe43ff408af6b84b5cdc6ddf4fa00883.jpg"],"type":0,"id":9652689,"ga_prefix":"102309","title":"一个创业团队到底有没有前景，怎么判断？"},{"images":["https://pic2.zhimg.com/v2-abb0f042e99ad73c6bc2b5ca85bdfdd1.jpg"],"type":0,"id":9652613,"ga_prefix":"102308","title":"从 8000 万到 2.2 亿，电竞正在诠释，甚至重塑「体育」"},{"images":["https://pic3.zhimg.com/v2-6449ece14730d6427322957670471552.jpg"],"type":0,"id":9653022,"ga_prefix":"102307","title":"铁路的发展愈发变快，以后坐火车想听「咣当、咣当」都难了"},{"images":["https://pic1.zhimg.com/v2-13f8b3916c4ddf08864e20fc99fcca70.jpg"],"type":0,"id":9653300,"ga_prefix":"102307","title":"零零后演《红楼梦》，比同龄人更早体验人生的难"},{"images":["https://pic1.zhimg.com/v2-9416959387129228541a2ad53e87d980.jpg"],"type":0,"id":9653264,"ga_prefix":"102307","title":"适合分享给你老板的财务知识，当然，你学了更好"},{"images":["https://pic1.zhimg.com/v2-5da4dd2ed89260216c90b5bb05cedb18.jpg"],"type":0,"id":9653231,"ga_prefix":"102306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-e071dc44bb91ccdbafc2c8ba2ef36362.jpg","type":0,"id":9653431,"ga_prefix":"102315","title":"面试的时候，如何判断面试官的水平？"},{"image":"https://pic3.zhimg.com/v2-1163773ad2b8cb697bfc59f478e0af2a.jpg","type":0,"id":9653315,"ga_prefix":"102215","title":"到底是选四大、投行还是 PE 或 VC，我陷入了沉思"},{"image":"https://pic4.zhimg.com/v2-fd916d617f0bb49bc8cc77c380cd023f.jpg","type":0,"id":9653313,"ga_prefix":"102211","title":"兄弟，S3 我们没做到的，今年我一定帮你做到"},{"image":"https://pic3.zhimg.com/v2-d25894761e00d445d0681e28947e02b6.jpg","type":0,"id":9653187,"ga_prefix":"102207","title":"Coach 的「奢侈」突袭"},{"image":"https://pic4.zhimg.com/v2-6c258822c49cc06cc16fb7fa23195de7.jpg","type":0,"id":9653114,"ga_prefix":"102119","title":"我们正在见证的，可能是发动机最好的时代"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean implements Serializable{
        /**
         * images : ["https://pic3.zhimg.com/v2-18a6604e08b5e90954802424008e7ba2.jpg"]
         * type : 0
         * id : 9653431
         * ga_prefix : 102315
         * title : 面试的时候，如何判断面试官的水平？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;
        private boolean readState;
        private String date;

        public boolean isReadState() {
            return readState;
        }

        public void setReadState(boolean readState) {
            this.readState = readState;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class TopStoriesBean implements Serializable{
        /**
         * image : https://pic3.zhimg.com/v2-e071dc44bb91ccdbafc2c8ba2ef36362.jpg
         * type : 0
         * id : 9653431
         * ga_prefix : 102315
         * title : 面试的时候，如何判断面试官的水平？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
