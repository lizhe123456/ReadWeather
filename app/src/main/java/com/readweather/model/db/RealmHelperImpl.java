package com.readweather.model.db;

import com.readweather.model.bean.ReadStateBean;
import com.readweather.model.bean.RealmLikeBean;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

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

    /**
     * 添加阅读记录
     * @param id
     */
    @Override
    public void insertNewId(int id) {
        ReadStateBean bean = new ReadStateBean();
        bean.setId(id);
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(bean);
        mRealm.commitTransaction();
    }

    /**
     * 查询阅读记录
     * @param id
     * @return
     */
    @Override
    public boolean queryNewsId(int id) {
        RealmResults<ReadStateBean> readStateBeen = mRealm.where(ReadStateBean.class).findAll();
        for (ReadStateBean item : readStateBeen){
            if (item.getId() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * 添加收藏
     * @param bean
     */
    @Override
    public void insertLike(RealmLikeBean bean) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(bean);
        mRealm.commitTransaction();
    }

    /**
     * 删除收藏
     * @param id
     * @return
     */
    @Override
    public boolean deleteLikeBean(String id) {
        RealmLikeBean data = mRealm.where(RealmLikeBean.class).equalTo("image",id).findFirst();
        mRealm.beginTransaction();
        if (data != null){
            data.deleteFromRealm();
        }
        mRealm.commitTransaction();
        return true;
    }

    /**
     * 查询收藏
     * @param id
     * @return
     */
    @Override
    public boolean queryLikeBean(String id) {
        RealmLikeBean bean = mRealm.where(RealmLikeBean.class).equalTo("id",id).findFirst();
        if (bean != null){
            return true;
        }else {
            return false;
        }
//        RealmResults<RealmLikeBean> readStateBeen = mRealm.where(RealmLikeBean.class).findAll();
//        for (RealmLikeBean item : readStateBeen){
//            if (item.getId() == id){
//                return true;
//            }
//        }
//        return false;
    }

    /**
     * 获取所有收藏
     * @return
     */
    @Override
    public List<RealmLikeBean> getLikeList() {
        RealmResults<RealmLikeBean> data = mRealm.where(RealmLikeBean.class).findAll().sort("time");
        return mRealm.copyFromRealm(data);
    }

    /**
     * 收藏时间排序
     * @param id
     * @param time
     * @param isPlus
     */
    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        RealmLikeBean bean = mRealm.where(RealmLikeBean.class).equalTo("id",id).findFirst();
        mRealm.beginTransaction();
        if (isPlus){
            bean.setTime(++time);
        }else {
            bean.setTime(--time);
        }
        mRealm.commitTransaction();
    }


}
