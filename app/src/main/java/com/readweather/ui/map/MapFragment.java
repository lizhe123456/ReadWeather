package com.readweather.ui.map;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.readweather.R;
import com.readweather.app.App;
import com.readweather.base.BaseFrament;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MapFragment extends BaseFrament implements App.RWLocationListener {


    @BindView(R.id.map)
    MapView map;
    @BindView(R.id.search_match)
    View searchMatch;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.search_maps_bar)
    RelativeLayout searchMapsBar;
    @BindView(R.id.ori_compass)
    ImageButton oriCompass;
    @BindView(R.id.my_location_btn)
    ImageButton myLocationBtn;

    private AMap aMap;

    private MyLocationStyle myLocationStyle;

    private UiSettings mUiSettings;

    private MarkerOptions mMarkerOptions;
    //首次定位
    private boolean isFirstLoc = true;
    //显示信息
    private String desc = "";

    private Handler handler = new Handler();

    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void init() {
        map.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = map.getMap();
            initMap();
            initLocation();
            initMarker();
        }
    }


    private void showMark() {

    }

    @Override
    protected void setData() {

    }

    private void initLocation() {
        App.getLoction(this);
    }


    private void initMap() {
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
        myLocationStyle = new MyLocationStyle();
        initUISetting();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.
                fromResource(R.drawable.gps_point));
        myLocationStyle.strokeColor(Color.WHITE);
        myLocationStyle.radiusFillColor(Color.argb(10, 0, 0, 180));
        myLocationStyle.strokeWidth(5);
        // 只定位，不进行其他操作
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);
        aMap.setMyLocationStyle(myLocationStyle);
    }

    private void initUISetting() {
        mUiSettings = aMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(false);
        // 是否显示默认的定位按钮
        mUiSettings.setMyLocationButtonEnabled(false);
    }

    private void initMarker() {
        mMarkerOptions = new MarkerOptions();
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
    public void onLocationChanged(AMapLocation location) {
        if (isFirstLoc) {

            //设置缩放级别（缩放级别为4-20级）
            aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
            //将地图移动到定位点
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
            mMarkerOptions.position(new LatLng(location.getLatitude(), location.getLongitude()));
            mMarkerOptions.title("西安市");
            mMarkerOptions.snippet("气泡的文字");
            mMarkerOptions.perspective(true);
            mMarkerOptions.draggable(true);
            mMarkerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_camera_location));//设置图标
            aMap.addMarker(mMarkerOptions);
            isFirstLoc = false;
        } else {
            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
            Log.e("地图错误", "定位失败, 错误码:" + location.getErrorCode() + ", 错误信息:"
                    + location.getErrorInfo());
        }
    }

}
