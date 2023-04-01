package com.readweather.ui.map.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.readweather.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhe on 2017/9/14 0014.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class RouteNaviActivity extends AppCompatActivity implements AMapNaviViewListener,AMapNaviListener {


    @BindView(R.id.amap_navi)
    AMapNaviView amapNavi;

    private AMapNavi mAMapNavi;
//    private TTSController mTTSController;
    private boolean mIsGps;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);
        ButterKnife.bind(this);
        //初始化语音
//        mTTSController = TTSController.getInstance(this);
//        mTTSController.init();

        amapNavi.onCreate(savedInstanceState);
        amapNavi.setAMapNaviViewListener(this);

        mAMapNavi = AMapNavi.getInstance(this);
        mAMapNavi.addAMapNaviListener(this);
//        mAMapNavi.addAMapNaviListener(mTTSController);
        mAMapNavi.setEmulatorNaviSpeed(60);
        getNaviParm();
    }

    /**
     * 获取Intent传递的参数，并调用计算线路方法
     */
    private void getNaviParm(){
        Intent intent = getIntent();
        mIsGps = intent.getBooleanExtra("gps",false);
        NaviLatLng start = intent.getParcelableExtra("start");
        NaviLatLng end = intent.getParcelableExtra("end");
        calculateDriveRoute(start, end);
    }

    /**
     * 计算驾驶路线
     * @param start
     * @param end
     */
    private void calculateDriveRoute(NaviLatLng start, NaviLatLng end) {
        int startegyFlag = 0;
        //开始
        List<NaviLatLng> startList = new ArrayList<>();
        //途经
        List<NaviLatLng> wayList = new ArrayList<>();
        //终点
        List<NaviLatLng> endList = new ArrayList<>();
        try{
            startegyFlag = mAMapNavi.strategyConvert(true, false,false,true,false);
        } catch (Exception e){
            e.printStackTrace();
        }
        startList.add(start);
        endList.add(end);
        mAMapNavi.calculateDriveRoute(startList,endList,wayList,startegyFlag);
    }

    @Override
    protected void onResume() {
        super.onResume();
        amapNavi.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        amapNavi.onPause();
//        mTTSController.stopSpeaking();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        amapNavi.onDestroy();
        mAMapNavi.stopNavi();
//        mTTSController.destroy();
//        mAMapNavi.removeAMapNaviListener(mTTSController);
    }

    @Override
    public void onNaviSetting() {

    }

    @Override
    public void onNaviCancel() {
        finish();
    }

    @Override
    public boolean onNaviBackClick() {
        return false;
    }

    @Override
    public void onNaviMapMode(int i) {

    }

    @Override
    public void onNaviTurnClick() {

    }

    @Override
    public void onNextRoadClick() {

    }

    @Override
    public void onScanViewButtonClick() {

    }

    @Override
    public void onLockMap(boolean b) {

    }

    @Override
    public void onNaviViewLoaded() {

    }

    //AMapNaviListener

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onInitNaviSuccess() {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onTrafficStatusUpdate() {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onGetNavigationText(int i, String s) {

    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onEndEmulatorNavi() {

    }

    @Override
    public void onArriveDestination() {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onReCalculateRouteForYaw() {

    }

    @Override
    public void onReCalculateRouteForTrafficJam() {

    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onGpsOpenStatus(boolean b) {

    }

    @Override
    public void onNaviInfoUpdate(NaviInfo naviInfo) {

    }

    @Override
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {

    }

    @Override
    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {

    }

    @Override
    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {

    }

    @Override
    public void showCross(AMapNaviCross aMapNaviCross) {

    }

    @Override
    public void hideCross() {

    }

    @Override
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void hideLaneInfo() {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {
        if (mIsGps) {
            mAMapNavi.startNavi(AMapNavi.GPSNaviMode);
        } else {
            mAMapNavi.startNavi(AMapNavi.EmulatorNaviMode);
        }
    }

    @Override
    public void notifyParallelRoad(int i) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {

    }

    @Override
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {

    }

    @Override
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

    }

    @Override
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

    }

    @Override
    public void onPlayRing(int i) {

    }
}
