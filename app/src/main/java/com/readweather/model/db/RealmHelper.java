package com.readweather.model.db;

import com.readweather.model.bean.RealmLikeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18 0018.
 */

public interface RealmHelper {


    void insertNewId(int id);

    boolean queryNewsId(int id);

    void insertLike(RealmLikeBean bean);

    boolean deleteLikeBean(String id);

    boolean queryLikeBean(String id);

    List<RealmLikeBean> getLikeList();

    void changeLikeTime(String id, long time, boolean isPlus);
}
