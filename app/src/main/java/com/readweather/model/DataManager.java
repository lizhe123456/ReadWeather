package com.readweather.model;

import com.readweather.model.bean.BusBean;
import com.readweather.model.db.RealmHelper;
import com.readweather.model.http.HttpHelper;
import com.readweather.model.http.response.BaseResponse;
import com.readweather.model.prefs.PreferencesHelper;

import javax.inject.Inject;

import rx.Observable;

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
    public Observable<BaseResponse<BusBean>> fetchBusBeanInfo(String city, String bus) {
        return mHttpHelper.fetchBusBeanInfo(city,bus);
    }
}
