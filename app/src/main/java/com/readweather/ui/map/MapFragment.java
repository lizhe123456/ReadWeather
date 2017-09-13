package com.readweather.ui.map;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.readweather.R;
import com.readweather.app.App;
import com.readweather.base.BaseFrament;
import com.readweather.ui.MainActivity;
import com.readweather.ui.map.adapter.SearchAdapter;
import com.readweather.ui.map.overlay.PoiOverlay;
import com.readweather.utils.ToastUtil;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MapFragment extends BaseFrament implements App.RWLocationListener, View.OnLayoutChangeListener,
        AMap.OnMarkerClickListener, AMap.InfoWindowAdapter, PoiSearch.OnPoiSearchListener, TextWatcher,
        Inputtips.InputtipsListener {

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
    @BindView(R.id.fragment_context)
    FrameLayout fragmentContext;
    @BindView(R.id.recyclerview_content)
    RecyclerView recyclerView;

    private AMap aMap;

    private MyLocationStyle myLocationStyle;

    private UiSettings mUiSettings;

    private MarkerOptions mMarkerOptions;
    //首次定位
    private boolean isFirstLoc = true;

    private AMapLocation mMyLocation;

    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;

    private String keyWord = "";
    private PoiResult poiReslt;
    private PoiSearch.Query mQuery;
    private PoiSearch mPoiSearch;
    private int currentPage = 0;
    private ProgressDialog progDialog = null;
    private PoiResult poiResult;
    private String city;
    private SearchAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_map;
    }

    @Override
    protected void init() {
        map.onCreate(savedInstanceState);
        editSearch.addTextChangedListener(this);
        mAdapter = new SearchAdapter(getContext());
        recyclerView.setAdapter(mAdapter);
        if (aMap == null) {
            aMap = map.getMap();
            initMap();
            initLocation();
            initMarker();
        }
    }


    private void controlMenu() {
        MainActivity activity = (MainActivity) (getActivity());
        DrawerLayout drawerLayout = activity.getDrawerlayout();
        drawerLayout.openDrawer(activity.getNavigationMenu());

    }


    private void showMark() {

    }

    @Override
    protected void setData() {
        //获取屏幕高度
        screenHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        fragmentContext.addOnLayoutChangeListener(this);
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
        aMap.setOnMarkerClickListener(this);
        aMap.setInfoWindowAdapter(this);
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
            isFirstLoc = false;
        } else {
            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
            Log.e("地图错误", "定位失败, 错误码:" + location.getErrorCode() + ", 错误信息:"
                    + location.getErrorInfo());
        }
        mMyLocation = location;
    }

    @OnClick({R.id.menu, R.id.search, R.id.ori_compass, R.id.my_location_btn, R.id.edit_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu:
                controlMenu();
                break;
            case R.id.search:
                startSearch();
                break;
            case R.id.ori_compass:
                break;
            case R.id.my_location_btn:
                isFirstLoc = true;
                onLocationChanged(mMyLocation);
                break;
            case R.id.edit_search:
                break;
        }
    }

    private void startSearch() {
        keyWord = editSearch.getText().toString().trim();
        if ("".equals(keyWord)) {
            ToastUtil.showShort("");
        } else {
            doSearchQuery();
        }
    }

    private void doSearchQuery() {
        showProgressDialog();
        currentPage = 0;
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        mQuery = new PoiSearch.Query(keyWord, "", editSearch.getText().toString());
        mQuery.setPageNum(currentPage);
        mQuery.setPageSize(10);

        mPoiSearch = new PoiSearch(getContext(), mQuery);
        mPoiSearch.setOnPoiSearchListener(this);
        mPoiSearch.searchPOIAsyn();
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        //old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值

        //现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
            //监听到软键盘弹起
            searchMatch.setVisibility(View.VISIBLE);
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
            //监听到软件盘关闭
            searchMatch.setVisibility(View.GONE);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return false;
    }

    @Override
    public void onPoiSearched(PoiResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getQuery() != null) {// 搜索poi的结果
                if (result.getQuery().equals(mQuery)) {// 是否是同一条
                    poiResult = result;
                    // 取得搜索到的poiitems有多少页
                    List<PoiItem> poiItems = poiResult.getPois();// 取得第一页的poiitem数据，页数从数字0开始
                    List<SuggestionCity> suggestionCities = poiResult
                            .getSearchSuggestionCitys();// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息

                    if (poiItems != null && poiItems.size() > 0) {
                        aMap.clear();// 清理之前的图标
                        PoiOverlay poiOverlay = new PoiOverlay(aMap, poiItems);
                        poiOverlay.removeFromMap();
                        poiOverlay.addToMap();
                        poiOverlay.zoomToSpan();
                    } else if (suggestionCities != null
                            && suggestionCities.size() > 0) {
                        showSuggestCity(suggestionCities);
                    } else {
                        ToastUtil.showShort("对不起，没有搜索到相关数据！1");
                    }
                }
            } else {
                ToastUtil.showShort("对不起，没有搜索到相关数据！2");
            }
        } else {
            ToastUtil.showShort("对不起，没有搜索到相关数据！3");
        }
    }

    /**
     * poi没有搜索到数据，返回一些推荐城市的信息
     */
    private void showSuggestCity(List<SuggestionCity> cities) {
        String infomation = "推荐城市\n";
        for (int i = 0; i < cities.size(); i++) {
            infomation += "城市名称:" + cities.get(i).getCityName() + "城市区号:"
                    + cities.get(i).getCityCode() + "城市编码:"
                    + cities.get(i).getAdCode() + "\n";
        }
        ToastUtil.showShort("对不起，没有搜索到相关数据！4");
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    /**
     * 显示进度框
     */
    private void showProgressDialog() {
        if (progDialog == null)
            progDialog = new ProgressDialog(getContext());
        progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDialog.setIndeterminate(false);
        progDialog.setCancelable(false);
        progDialog.setMessage("正在搜索:\n" + keyWord);
        progDialog.show();
    }

    /**
     * 隐藏进度框
     */
    private void dissmissProgressDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String newText = charSequence.toString().trim();
        if (!"".equals(newText)) {
            InputtipsQuery inputquery = new InputtipsQuery(newText, mMyLocation.getCity().toString().trim());
            Inputtips inputTips = new Inputtips(getContext(), inputquery);
            inputTips.setInputtipsListener(this);
            inputTips.requestInputtipsAsyn();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onGetInputtips(List<Tip> list, int rCode) {
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            // 正确返回
            mAdapter.addFirstDataSet(list);
        } else {
            ToastUtil.showShort(rCode);
        }
    }
}
