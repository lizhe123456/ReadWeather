package com.readweather.model;

import com.readweather.model.bean.BusBean;
import com.readweather.model.bean.BusNumberBean;
import com.readweather.model.db.RealmHelper;
import com.readweather.model.http.HttpHelper;
import com.readweather.model.http.response.BusResponse;
import com.readweather.model.prefs.PreferencesHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/8/18 0018.
 * 数据管理中心
 */

public class DataManager implements HttpHelper,RealmHelper,PreferencesHelper{

    HttpHelper mHttpHelper;
    RealmHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(HttpHelper mHttpHelper, RealmHelper mDbHelper, PreferencesHelper mPreferencesHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mDbHelper = mDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public void insertNewId(int id) {

    }

    @Override
    public boolean queryNewsId(int id) {
        return false;
    }

    @Override
    public Flowable<BusResponse<BusBean>> fetchBusBeanInfo(String city, String bus) {
        return mHttpHelper.fetchBusBeanInfo(city,bus);
    }

    @Override
    public Flowable<BusResponse<List<BusNumberBean>>> fetchBusNumberBeanInfo(String city, String bus) {
        return mHttpHelper.fetchBusNumberBeanInfo(city,bus);
    }

}
