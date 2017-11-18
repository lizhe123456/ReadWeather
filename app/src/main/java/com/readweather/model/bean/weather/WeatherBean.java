package com.readweather.model.bean.weather;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2017/11/18 0018.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class WeatherBean implements Serializable {
    /**
     * basic : {"cid":"CN101010100","location":"北京","parent_city":"北京","admin_area":"北京","cnty":"中国","lat":"39.90498734","lon":"116.4052887","tz":"+8.0"}
     * update : {"loc":"2017-11-18 16:46","utc":"2017-11-18 08:46"}
     * status : ok
     * now : {"cloud":"0","cond_code":"100","cond_txt":"晴","fl":"0","hum":"36","pcpn":"0.0","pres":"1028","tmp":"4","vis":"8","wind_deg":"272","wind_dir":"西风","wind_sc":"3-4","wind_spd":"10"}
     * daily_forecast : [{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-11-18","hum":"15","mr":"06:25","ms":"17:11","pcpn":"0.0","pop":"0","pres":"1032","sr":"07:02","ss":"16:57","tmp_max":"5","tmp_min":"-6","uv_index":"3","vis":"20","wind_deg":"264","wind_dir":"西风","wind_sc":"微风","wind_spd":"12"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2017-11-19","hum":"19","mr":"07:22","ms":"17:47","pcpn":"0.0","pop":"0","pres":"1028","sr":"07:03","ss":"16:57","tmp_max":"7","tmp_min":"-5","uv_index":"3","vis":"20","wind_deg":"197","wind_dir":"西南风","wind_sc":"微风","wind_spd":"7"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2017-11-20","hum":"30","mr":"08:18","ms":"18:26","pcpn":"0.0","pop":"0","pres":"1027","sr":"07:04","ss":"16:56","tmp_max":"10","tmp_min":"-3","uv_index":"4","vis":"11","wind_deg":"217","wind_dir":"西南风","wind_sc":"微风","wind_spd":"5"}]
     * lifestyle : [{"brf":"较不舒适","txt":"白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。","type":"comf"},{"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。","type":"drsg"},{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。","type":"flu"},{"brf":"较适宜","txt":"天气较好，但考虑风力较强且气温较低，推荐您进行室内运动，若在户外运动注意防风并适当增减衣物。","type":"sport"},{"brf":"一般","txt":"天气较好，温度稍低，加之风稍大，让人感觉有点凉，会对外出有一定影响，外出注意防风保暖。","type":"trav"},{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。","type":"uv"},{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","type":"cw"},{"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","type":"air"}]
     */

    private BasicBean basic;
    private UpdateBean update;
    private String status;
    private NowBean now;
    private List<DailyForecastBean> daily_forecast;
    private List<LifestyleBean> lifestyle;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<LifestyleBean> getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(List<LifestyleBean> lifestyle) {
        this.lifestyle = lifestyle;
    }

    public static class BasicBean {
        /**
         * cid : CN101010100
         * location : 北京
         * parent_city : 北京
         * admin_area : 北京
         * cnty : 中国
         * lat : 39.90498734
         * lon : 116.4052887
         * tz : +8.0
         */

        private String cid;
        private String location;
        private String parent_city;
        private String admin_area;
        private String cnty;
        private String lat;
        private String lon;
        private String tz;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getParent_city() {
            return parent_city;
        }

        public void setParent_city(String parent_city) {
            this.parent_city = parent_city;
        }

        public String getAdmin_area() {
            return admin_area;
        }

        public void setAdmin_area(String admin_area) {
            this.admin_area = admin_area;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }
    }

    public static class UpdateBean {
        /**
         * loc : 2017-11-18 16:46
         * utc : 2017-11-18 08:46
         */

        private String loc;
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }

    public static class NowBean {
        /**
         * cloud : 0
         * cond_code : 100
         * cond_txt : 晴
         * fl : 0
         * hum : 36
         * pcpn : 0.0
         * pres : 1028
         * tmp : 4
         * vis : 8
         * wind_deg : 272
         * wind_dir : 西风
         * wind_sc : 3-4
         * wind_spd : 10
         */

        private String cloud;
        private String cond_code;
        private String cond_txt;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        private String wind_deg;
        private String wind_dir;
        private String wind_sc;
        private String wind_spd;

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getCond_code() {
            return cond_code;
        }

        public void setCond_code(String cond_code) {
            this.cond_code = cond_code;
        }

        public String getCond_txt() {
            return cond_txt;
        }

        public void setCond_txt(String cond_txt) {
            this.cond_txt = cond_txt;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getWind_deg() {
            return wind_deg;
        }

        public void setWind_deg(String wind_deg) {
            this.wind_deg = wind_deg;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }

        public String getWind_sc() {
            return wind_sc;
        }

        public void setWind_sc(String wind_sc) {
            this.wind_sc = wind_sc;
        }

        public String getWind_spd() {
            return wind_spd;
        }

        public void setWind_spd(String wind_spd) {
            this.wind_spd = wind_spd;
        }
    }

    public static class DailyForecastBean {
        /**
         * cond_code_d : 100
         * cond_code_n : 100
         * cond_txt_d : 晴
         * cond_txt_n : 晴
         * date : 2017-11-18
         * hum : 15
         * mr : 06:25
         * ms : 17:11
         * pcpn : 0.0
         * pop : 0
         * pres : 1032
         * sr : 07:02
         * ss : 16:57
         * tmp_max : 5
         * tmp_min : -6
         * uv_index : 3
         * vis : 20
         * wind_deg : 264
         * wind_dir : 西风
         * wind_sc : 微风
         * wind_spd : 12
         */

        private String cond_code_d;
        private String cond_code_n;
        private String cond_txt_d;
        private String cond_txt_n;
        private String date;
        private String hum;
        private String mr;
        private String ms;
        private String pcpn;
        private String pop;
        private String pres;
        private String sr;
        private String ss;
        private String tmp_max;
        private String tmp_min;
        private String uv_index;
        private String vis;
        private String wind_deg;
        private String wind_dir;
        private String wind_sc;
        private String wind_spd;

        public String getCond_code_d() {
            return cond_code_d;
        }

        public void setCond_code_d(String cond_code_d) {
            this.cond_code_d = cond_code_d;
        }

        public String getCond_code_n() {
            return cond_code_n;
        }

        public void setCond_code_n(String cond_code_n) {
            this.cond_code_n = cond_code_n;
        }

        public String getCond_txt_d() {
            return cond_txt_d;
        }

        public void setCond_txt_d(String cond_txt_d) {
            this.cond_txt_d = cond_txt_d;
        }

        public String getCond_txt_n() {
            return cond_txt_n;
        }

        public void setCond_txt_n(String cond_txt_n) {
            this.cond_txt_n = cond_txt_n;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getMr() {
            return mr;
        }

        public void setMr(String mr) {
            this.mr = mr;
        }

        public String getMs() {
            return ms;
        }

        public void setMs(String ms) {
            this.ms = ms;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }

        public String getTmp_max() {
            return tmp_max;
        }

        public void setTmp_max(String tmp_max) {
            this.tmp_max = tmp_max;
        }

        public String getTmp_min() {
            return tmp_min;
        }

        public void setTmp_min(String tmp_min) {
            this.tmp_min = tmp_min;
        }

        public String getUv_index() {
            return uv_index;
        }

        public void setUv_index(String uv_index) {
            this.uv_index = uv_index;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getWind_deg() {
            return wind_deg;
        }

        public void setWind_deg(String wind_deg) {
            this.wind_deg = wind_deg;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }

        public String getWind_sc() {
            return wind_sc;
        }

        public void setWind_sc(String wind_sc) {
            this.wind_sc = wind_sc;
        }

        public String getWind_spd() {
            return wind_spd;
        }

        public void setWind_spd(String wind_spd) {
            this.wind_spd = wind_spd;
        }
    }

    public static class LifestyleBean {
        /**
         * brf : 较不舒适
         * txt : 白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。
         * type : comf
         */

        private String brf;
        private String txt;
        private String type;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

