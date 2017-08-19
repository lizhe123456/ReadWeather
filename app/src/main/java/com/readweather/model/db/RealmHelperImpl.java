package com.readweather.model.db;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public class RealmHelperImpl implements RealmHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelperImpl() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    @Override
    public void insertNewId(int id) {

    }

    @Override
    public boolean queryNewsId(int id) {
        return false;
    }
}
