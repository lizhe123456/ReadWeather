package com.readweather.di.component;

import com.readweather.app.App;
import com.readweather.di.module.AppModule;
import com.readweather.di.module.HttpModule;
import com.readweather.model.DataManager;
import com.readweather.model.db.RealmHelperImpl;
import com.readweather.model.http.HttpHelperImpl;
import com.readweather.model.prefs.PreferencesHelperImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext(); //提供App的Context

    DataManager getDataManager(); //数据中心

    HttpHelperImpl getHttpHelper(); //提供http的帮助类

    RealmHelperImpl getDbHelper(); //提供数据库帮助类

    PreferencesHelperImpl getPreferencesHelper(); //提供sp帮助类

}
