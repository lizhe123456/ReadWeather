package com.readweather.ui.map;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.readweather.R;
import com.readweather.app.App;
import com.readweather.base.BaseFrament;

import butterknife.BindView;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MapFragment extends BaseFrament implements App.RWLocationListener{


    @BindView(R.id.map)
    MapView map;

    private AMap aMap;

    private MyLocationStyle myLocationStyle;

    //首次定位
    private boolean isFirstLoc = true;

    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void init() {
        map.onCreate(savedInstanceState);
        if (aMap == null){
            aMap = map.getMap();
            initMap();
            initLocation();
        }
    }

    @Override
    protected void setData() {

    }

    private void initLocation() {
        App.getLoction(this);
    }


    private void initMap() {
        myLocationStyle = new MyLocationStyle();
        aMap.setMyLocationStyle(myLocationStyle);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_qu_direction_mylocation));
        myLocationStyle.strokeColor(Color.BLACK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        if (isFirstLoc) {

            //设置缩放级别（缩放级别为4-20级）
            aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
            //将地图移动到定位点
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
            isFirstLoc = false;
         }else {
            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
            Log.e("地图错误", "定位失败, 错误码:" + location.getErrorCode() + ", 错误信息:"
                    + location.getErrorInfo());
        }
    }

}
