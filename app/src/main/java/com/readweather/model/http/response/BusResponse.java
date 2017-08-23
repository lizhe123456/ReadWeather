package com.readweather.model.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-08-23.
 */

public class BusResponse<T> implements Serializable{


    /**
     * reason : success
     * result : [{"terminal_name":"慈惠农场","front_spell":"","line_id":"N027019901","key_name":"５６０","time_desc":"","front_name":"常青五路杨汊湖小区","stationdes":[{"code":"420100","stationNum":"1","name":"常青五路杨汊湖小区","xy":"114.255429,30.629004"},{"code":"420100","stationNum":"2","name":"常青五路姑嫂树路口","xy":"114.258511,30.629787"},{"code":"420103","stationNum":"3","name":"姑嫂树路杨汊湖","xy":"114.261968,30.630139"},{"code":"420103","stationNum":"4","name":"姑嫂树路新华家园","xy":"114.264218,30.627706"},{"code":"420103","stationNum":"5","name":"姑嫂树路石桥","xy":"114.266757,30.624771"},{"code":"420103","stationNum":"6","name":"唐家墩路顶绣晶城","xy":"114.270281,30.619985"},{"code":"420103","stationNum":"7","name":"唐家墩路唐蔡路","xy":"114.271420,30.616278"},{"code":"420103","stationNum":"8","name":"香港路浅水湾小区","xy":"114.274579,30.610849"},{"code":"420103","stationNum":"9","name":"香港路紫藤花园","xy":"114.279540,30.608259"},{"code":"420103","stationNum":"10","name":"香港路华氏百货","xy":"114.282860,30.606044"},{"code":"420103","stationNum":"11","name":"建设大道市图书馆","xy":"114.282634,30.603211"},{"code":"420103","stationNum":"12","name":"建设大道杂技厅","xy":"114.276612,30.598601"},{"code":"420103","stationNum":"13","name":"建设大道西北湖","xy":"114.269509,30.595563"},{"code":"420102","stationNum":"14","name":"建设大道青年路","xy":"114.262024,30.593432"},{"code":"420103","stationNum":"15","name":"建设大道王家墩","xy":"114.256733,30.589492"},{"code":"420104","stationNum":"16","name":"建设大道宝丰一路口","xy":"114.250845,30.584003"},{"code":"420104","stationNum":"17","name":"建设大道营房村","xy":"114.244268,30.585895"},{"code":"420104","stationNum":"18","name":"建设大道双墩","xy":"114.235609,30.586336"},{"code":"420104","stationNum":"19","name":"建设大道新合村","xy":"114.227096,30.583101"},{"code":"420104","stationNum":"20","name":"解放大道宗关","xy":"114.223573,30.582830"},{"code":"420100","stationNum":"21","name":"解放大道汉西一路","xy":"114.219952,30.585223"},{"code":"420102","stationNum":"22","name":"解放大道古田四路","xy":"114.210399,30.590222"},{"code":"420104","stationNum":"23","name":"解放大道古田三路口","xy":"114.206062,30.592953"},{"code":"420104","stationNum":"24","name":"解放大道辛家地","xy":"114.201335,30.595208"},{"code":"420104","stationNum":"25","name":"解放大道古田二路口","xy":"114.194492,30.599040"},{"code":"420100","stationNum":"26","name":"解放大道皇经堂","xy":"114.191858,30.600295"},{"code":"420104","stationNum":"27","name":"解放大道易家墩","xy":"114.185875,30.603249"},{"code":"420104","stationNum":"28","name":"工农路联农路","xy":"114.176981,30.607797"},{"code":"420104","stationNum":"29","name":"工农路舵落口","xy":"114.170442,30.609868"},{"code":"420104","stationNum":"30","name":"工农路老年公寓","xy":"114.164684,30.613746"},{"code":"420112","stationNum":"31","name":"东西湖大道舵落口广场","xy":"114.155000,30.618430"},{"code":"420112","stationNum":"32","name":"东西湖大道四明路","xy":"114.145377,30.618028"},{"code":"420112","stationNum":"33","name":"五环大道裕民街","xy":"114.137374,30.616069"},{"code":"420112","stationNum":"34","name":"五环大道裕东街","xy":"114.137719,30.611958"},{"code":"420112","stationNum":"35","name":"五环大道五环华城","xy":"114.137920,30.607987"},{"code":"420112","stationNum":"36","name":"五环大道慈惠水厂","xy":"114.138332,30.601016"},{"code":"420112","stationNum":"37","name":"慈惠农场","xy":"114.128995,30.596535"}],"description":"","start_time":"0530","photo_folder":"","gpsfile_id":"","data_source":"","total_price":"0.000000","company":"公交三公司","speed":"","length":"24.743999","loop":"0","auto":"","ic_card":"","double_deck":"","express_way":"","status":"1","basic_price":"0.000000","end_time":"2100","air":"","terminal_spell":"","type":"list","paper_table_id":"","name":"５６０（杨汊湖小区－慈惠农场）","commutation_ticket":"0"},{"terminal_name":"常青五路杨汊湖小区","front_spell":"","line_id":"N027019801","key_name":"５６０","time_desc":"","front_name":"慈惠农场","stationdes":[{"code":"420112","stationNum":"1","name":"慈惠农场","xy":"114.128995,30.596535"},{"code":"420112","stationNum":"2","name":"五环大道慈惠水厂","xy":"114.138671,30.601084"},{"code":"420112","stationNum":"3","name":"五环大道五环华城","xy":"114.138165,30.607896"},{"code":"420112","stationNum":"4","name":"五环大道裕东街","xy":"114.137931,30.611968"},{"code":"420112","stationNum":"5","name":"五环大道裕民街","xy":"114.139791,30.617421"},{"code":"-1","stationNum":"6","name":"东西湖大道三秀路","xy":"114.147441,30.617792"},{"code":"-1","stationNum":"7","name":"东西湖大道舵落口广场","xy":"114.155705,30.618281"},{"code":"420104","stationNum":"8","name":"工农路老年公寓","xy":"114.165048,30.612946"},{"code":"-1","stationNum":"9","name":"工农路舵落口","xy":"114.169245,30.609949"},{"code":"420104","stationNum":"10","name":"工农路联农路","xy":"114.176855,30.607528"},{"code":"420112","stationNum":"11","name":"解放大道易家墩","xy":"114.185642,30.603072"},{"code":"420104","stationNum":"12","name":"南泥湾大道古田一路","xy":"114.186515,30.602633"},{"code":"420100","stationNum":"13","name":"解放大道皇经堂","xy":"114.191983,30.599737"},{"code":"420104","stationNum":"14","name":"解放大道古田二口","xy":"114.194122,30.598607"},{"code":"-1","stationNum":"15","name":"解放大道辛家地","xy":"114.200113,30.595674"},{"code":"420104","stationNum":"16","name":"解放大道古田三路口","xy":"114.205710,30.592704"},{"code":"420112","stationNum":"17","name":"解放大道古田四路","xy":"114.213096,30.588198"},{"code":"420100","stationNum":"18","name":"解放大道汉西一路","xy":"114.219083,30.585236"},{"code":"420104","stationNum":"19","name":"解放大道宗关","xy":"114.222363,30.583472"},{"code":"420104","stationNum":"20","name":"建设大道新合村","xy":"114.227620,30.583557"},{"code":"420112","stationNum":"21","name":"建设大道双墩","xy":"114.234082,30.586821"},{"code":"-1","stationNum":"22","name":"建设大道营房村","xy":"114.244584,30.585726"},{"code":"420105","stationNum":"23","name":"建设大道宝丰一路","xy":"114.253471,30.585090"},{"code":"420103","stationNum":"24","name":"建设大道王家墩","xy":"114.256976,30.589389"},{"code":"420103","stationNum":"25","name":"建设大道青年路口","xy":"114.265183,30.594144"},{"code":"420103","stationNum":"26","name":"建设大道西北湖","xy":"114.273112,30.596945"},{"code":"420103","stationNum":"27","name":"建设大道杂技厅","xy":"114.279468,30.599729"},{"code":"420103","stationNum":"28","name":"长江日报","xy":"114.278548,30.604350"},{"code":"420103","stationNum":"29","name":"香江路","xy":"114.280495,30.606725"},{"code":"420103","stationNum":"30","name":"香港路紫藤花园","xy":"114.278186,30.609196"},{"code":"420103","stationNum":"31","name":"香港路十一医院","xy":"114.272808,30.613308"},{"code":"420103","stationNum":"32","name":"唐家墩路唐蔡路","xy":"114.271990,30.616267"},{"code":"420103","stationNum":"33","name":"唐家墩路顶绣晶城","xy":"114.270051,30.620792"},{"code":"420103","stationNum":"34","name":"姑嫂树路新华家园","xy":"114.264060,30.628092"},{"code":"420103","stationNum":"35","name":"姑嫂树路杨汊湖","xy":"114.261939,30.630386"},{"code":"-1","stationNum":"36","name":"常青五路姑嫂树路口","xy":"114.257245,30.629616"},{"code":"420100","stationNum":"37","name":"常青五路杨汊湖小区","xy":"114.255429,30.629004"}],"description":"","start_time":"0530","photo_folder":"","gpsfile_id":"","data_source":"","total_price":"0.000000","company":"公交三公司","speed":"","length":"24.434000","loop":"0","auto":"","ic_card":"","double_deck":"","express_way":"","status":"1","basic_price":"0.000000","end_time":"2100","air":"","terminal_spell":"","type":"list","paper_table_id":"","name":"５６０（慈惠农场－常青五路杨汊湖小区）","commutation_ticket":"0"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private T result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
