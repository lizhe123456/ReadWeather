package com.readweather.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class BusBean implements Serializable{


    /**
     * line_id : N027044301
     * name : ２２２（裕民街九通路－中山路栅栏口）
     * key_name : ２２２
     * front_name : 裕民街九通路
     * terminal_name : 中山路栅栏口
     * start_time : 0600
     * end_time : 2100
     * basic_price : 0.000000
     * total_price : 0.000000
     * company : 公交三公司
     * length : 29.202999
     */

    private String line_id;
    private String name;
    private String key_name;
    private String front_name;
    private String terminal_name;
    private String start_time;
    private String end_time;
    private String basic_price;
    private String total_price;
    private String company;
    private String length;

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    public String getTerminal_name() {
        return terminal_name;
    }

    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getBasic_price() {
        return basic_price;
    }

    public void setBasic_price(String basic_price) {
        this.basic_price = basic_price;
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
