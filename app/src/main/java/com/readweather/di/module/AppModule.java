package com.readweather.di.module;

import com.readweather.app.App;
import com.readweather.model.DataManager;
import com.readweather.model.db.RealmHelper;
import com.readweather.model.db.RealmHelperImpl;
import com.readweather.model.http.HttpHelper;
import com.readweather.model.http.HttpHelperImpl;
import com.readweather.model.prefs.PreferencesHelper;
import com.readweather.model.prefs.PreferencesHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Singleton
    @Provides
    App provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelper){
        return httpHelper;
    }

    @Singleton
    @Provides
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper){
        return preferencesHelper;
    }

    @Provides
    @Singleton
    RealmHelper provideDBHelper(RealmHelperImpl realmHelper){
        return realmHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, RealmHelper DBHelper, PreferencesHelper preferencesHelper){
        return new DataManager(httpHelper,DBHelper,preferencesHelper);
    }
}
