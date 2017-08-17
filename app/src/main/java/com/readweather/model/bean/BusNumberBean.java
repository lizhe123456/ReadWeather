package com.readweather.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17 0017.
 * 按照公交车牌查询线路
 */

public class BusNumberBean implements Serializable {


    /**
     * terminal_name : 慈惠农场
     * front_spell :
     * line_id : N027019901
     * key_name : ５６０
     * time_desc :
     * front_name : 常青五路杨汊湖小区
     * stationdes : [{"code":"420100","stationNum":"1","name":"常青五路杨汊湖小区","xy":"114.255429,30.629004"},{"code":"420100","stationNum":"2","name":"常青五路姑嫂树路口","xy":"114.258511,30.629787"},{"code":"420103","stationNum":"3","name":"姑嫂树路杨汊湖","xy":"114.261968,30.630139"},{"code":"420103","stationNum":"4","name":"姑嫂树路新华家园","xy":"114.264218,30.627706"},{"code":"420103","stationNum":"5","name":"姑嫂树路石桥","xy":"114.266757,30.624771"},{"code":"420103","stationNum":"6","name":"唐家墩路顶绣晶城","xy":"114.270281,30.619985"},{"code":"420103","stationNum":"7","name":"唐家墩路唐蔡路","xy":"114.271420,30.616278"},{"code":"420103","stationNum":"8","name":"香港路浅水湾小区","xy":"114.274579,30.610849"},{"code":"420103","stationNum":"9","name":"香港路紫藤花园","xy":"114.279540,30.608259"},{"code":"420103","stationNum":"10","name":"香港路华氏百货","xy":"114.282860,30.606044"},{"code":"420103","stationNum":"11","name":"建设大道市图书馆","xy":"114.282634,30.603211"},{"code":"420103","stationNum":"12","name":"建设大道杂技厅","xy":"114.276612,30.598601"},{"code":"420103","stationNum":"13","name":"建设大道西北湖","xy":"114.269509,30.595563"},{"code":"420102","stationNum":"14","name":"建设大道青年路","xy":"114.262024,30.593432"},{"code":"420103","stationNum":"15","name":"建设大道王家墩","xy":"114.256733,30.589492"},{"code":"420104","stationNum":"16","name":"建设大道宝丰一路口","xy":"114.250845,30.584003"},{"code":"420104","stationNum":"17","name":"建设大道营房村","xy":"114.244268,30.585895"},{"code":"420104","stationNum":"18","name":"建设大道双墩","xy":"114.235609,30.586336"},{"code":"420104","stationNum":"19","name":"建设大道新合村","xy":"114.227096,30.583101"},{"code":"420104","stationNum":"20","name":"解放大道宗关","xy":"114.223573,30.582830"},{"code":"420100","stationNum":"21","name":"解放大道汉西一路","xy":"114.219952,30.585223"},{"code":"420102","stationNum":"22","name":"解放大道古田四路","xy":"114.210399,30.590222"},{"code":"420104","stationNum":"23","name":"解放大道古田三路口","xy":"114.206062,30.592953"},{"code":"420104","stationNum":"24","name":"解放大道辛家地","xy":"114.201335,30.595208"},{"code":"420104","stationNum":"25","name":"解放大道古田二路口","xy":"114.194492,30.599040"},{"code":"420100","stationNum":"26","name":"解放大道皇经堂","xy":"114.191858,30.600295"},{"code":"420104","stationNum":"27","name":"解放大道易家墩","xy":"114.185875,30.603249"},{"code":"420104","stationNum":"28","name":"工农路联农路","xy":"114.176981,30.607797"},{"code":"420104","stationNum":"29","name":"工农路舵落口","xy":"114.170442,30.609868"},{"code":"420104","stationNum":"30","name":"工农路老年公寓","xy":"114.164684,30.613746"},{"code":"420112","stationNum":"31","name":"东西湖大道舵落口广场","xy":"114.155000,30.618430"},{"code":"420112","stationNum":"32","name":"东西湖大道四明路","xy":"114.145377,30.618028"},{"code":"420112","stationNum":"33","name":"五环大道裕民街","xy":"114.137374,30.616069"},{"code":"420112","stationNum":"34","name":"五环大道裕东街","xy":"114.137719,30.611958"},{"code":"420112","stationNum":"35","name":"五环大道五环华城","xy":"114.137920,30.607987"},{"code":"420112","stationNum":"36","name":"五环大道慈惠水厂","xy":"114.138332,30.601016"},{"code":"420112","stationNum":"37","name":"慈惠农场","xy":"114.128995,30.596535"}]
     * description :
     * start_time : 0530
     * photo_folder :
     * gpsfile_id :
     * data_source :
     * total_price : 0.000000
     * company : 公交三公司
     * speed :
     * length : 24.743999
     * loop : 0
     * auto :
     * ic_card :
     * double_deck :
     * express_way :
     * status : 1
     * basic_price : 0.000000
     * end_time : 2100
     * air :
     * terminal_spell :
     * type : list
     * paper_table_id :
     * name : ５６０（杨汊湖小区－慈惠农场）
     * commutation_ticket : 0
     */

    private String terminal_name;
    private String front_spell;
    private String line_id;
    private String key_name;
    private String time_desc;
    private String front_name;
    private String description;
    private String start_time;
    private String photo_folder;
    private String gpsfile_id;
    private String data_source;
    private String total_price;
    private String company;
    private String speed;
    private String length;
    private String loop;
    private String auto;
    private String ic_card;
    private String double_deck;
    private String express_way;
    private String status;
    private String basic_price;
    private String end_time;
    private String air;
    private String terminal_spell;
    private String type;
    private String paper_table_id;
    private String name;
    private String commutation_ticket;
    private List<StationdesBean> stationdes;

    public String getTerminal_name() {
        return terminal_name;
    }

    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }

    public String getFront_spell() {
        return front_spell;
    }

    public void setFront_spell(String front_spell) {
        this.front_spell = front_spell;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getTime_desc() {
        return time_desc;
    }

    public void setTime_desc(String time_desc) {
        this.time_desc = time_desc;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getPhoto_folder() {
        return photo_folder;
    }

    public void setPhoto_folder(String photo_folder) {
        this.photo_folder = photo_folder;
    }

    public String getGpsfile_id() {
        return gpsfile_id;
    }

    public void setGpsfile_id(String gpsfile_id) {
        this.gpsfile_id = gpsfile_id;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getIc_card() {
        return ic_card;
    }

    public void setIc_card(String ic_card) {
        this.ic_card = ic_card;
    }

    public String getDouble_deck() {
        return double_deck;
    }

    public void setDouble_deck(String double_deck) {
        this.double_deck = double_deck;
    }

    public String getExpress_way() {
        return express_way;
    }

    public void setExpress_way(String express_way) {
        this.express_way = express_way;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBasic_price() {
        return basic_price;
    }

    public void setBasic_price(String basic_price) {
        this.basic_price = basic_price;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getTerminal_spell() {
        return terminal_spell;
    }

    public void setTerminal_spell(String terminal_spell) {
        this.terminal_spell = terminal_spell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaper_table_id() {
        return paper_table_id;
    }

    public void setPaper_table_id(String paper_table_id) {
        this.paper_table_id = paper_table_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommutation_ticket() {
        return commutation_ticket;
    }

    public void setCommutation_ticket(String commutation_ticket) {
        this.commutation_ticket = commutation_ticket;
    }

    public List<StationdesBean> getStationdes() {
        return stationdes;
    }

    public void setStationdes(List<StationdesBean> stationdes) {
        this.stationdes = stationdes;
    }

    public static class StationdesBean {
        /**
         * code : 420100
         * stationNum : 1
         * name : 常青五路杨汊湖小区
         * xy : 114.255429,30.629004
         */

        private String code;
        private String stationNum;
        private String name;
        private String xy;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getStationNum() {
            return stationNum;
        }

        public void setStationNum(String stationNum) {
            this.stationNum = stationNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getXy() {
            return xy;
        }

        public void setXy(String xy) {
            this.xy = xy;
        }
    }
}
