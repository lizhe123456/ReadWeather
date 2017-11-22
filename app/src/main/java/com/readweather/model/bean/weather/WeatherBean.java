package com.readweather.model.bean.weather;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2017/11/18 0018.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class WeatherBean implements Serializable {

    /**
     * basic : {"cid":"CN101200101","location":"武汉","parent_city":"武汉","admin_area":"湖北","cnty":"中国","lat":"30.5843544","lon":"114.29856873","tz":"+8.0"}
     * update : {"loc":"2017-11-22 13:52","utc":"2017-11-22 05:52"}
     * status : ok
     * now : {"cloud":"0","cond_code":"100","cond_txt":"晴","fl":"16","hum":"33","pcpn":"0","pres":"1025","tmp":"15","vis":"10","wind_deg":"60","wind_dir":"东北风","wind_sc":"微风","wind_spd":"9"}
     * daily_forecast : [{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-11-22","hum":"36","mr":"09:48","ms":"20:28","pcpn":"0.0","pop":"0","pres":"1026","sr":"06:55","ss":"17:24","tmp_max":"13","tmp_min":"3","uv_index":"3","vis":"10","wind_deg":"355","wind_dir":"北风","wind_sc":"微风","wind_spd":"6"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-11-23","hum":"28","mr":"10:34","ms":"21:18","pcpn":"0.0","pop":"0","pres":"1029","sr":"06:56","ss":"17:24","tmp_max":"13","tmp_min":"3","uv_index":"4","vis":"10","wind_deg":"0","wind_dir":"无持续风向","wind_sc":"微风","wind_spd":"4"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2017-11-24","hum":"32","mr":"11:18","ms":"22:10","pcpn":"0.0","pop":"0","pres":"1025","sr":"06:57","ss":"17:24","tmp_max":"15","tmp_min":"5","uv_index":"4","vis":"10","wind_deg":"0","wind_dir":"无持续风向","wind_sc":"微风","wind_spd":"6"}]
     * lifestyle : [{"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。","type":"comf"},{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","type":"drsg"},{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。","type":"flu"},{"brf":"较适宜","txt":"天气较好，但考虑风力较强且气温较低，推荐您进行室内运动，若在户外运动注意防风并适当增减衣物。","type":"sport"},{"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。","type":"trav"},{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。","type":"uv"},{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","type":"cw"},{"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","type":"air"}]
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

    public static class BasicBean implements Serializable{
        /**
         * cid : CN101200101
         * location : 武汉
         * parent_city : 武汉
         * admin_area : 湖北
         * cnty : 中国
         * lat : 30.5843544
         * lon : 114.29856873
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
         * loc : 2017-11-22 13:52
         * utc : 2017-11-22 05:52
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

    public static class NowBean implements Serializable{
        /**
         * cloud : 0
         * cond_code : 100
         * cond_txt : 晴
         * fl : 16
         * hum : 33
         * pcpn : 0
         * pres : 1025
         * tmp : 15
         * vis : 10
         * wind_deg : 60
         * wind_dir : 东北风
         * wind_sc : 微风
         * wind_spd : 9
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

    public static class DailyForecastBean implements Serializable{
        /**
         * cond_code_d : 100
         * cond_code_n : 100
         * cond_txt_d : 晴
         * cond_txt_n : 晴
         * date : 2017-11-22
         * hum : 36
         * mr : 09:48
         * ms : 20:28
         * pcpn : 0.0
         * pop : 0
         * pres : 1026
         * sr : 06:55
         * ss : 17:24
         * tmp_max : 13
         * tmp_min : 3
         * uv_index : 3
         * vis : 10
         * wind_deg : 355
         * wind_dir : 北风
         * wind_sc : 微风
         * wind_spd : 6
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

    public static class LifestyleBean implements Serializable{
        /**
         * brf : 较舒适
         * txt : 白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。
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

