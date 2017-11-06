package com.readweather.model.http.api;

import com.readweather.model.bean.read.CommentBean;
import com.readweather.model.bean.read.DailyBeforeListBean;
import com.readweather.model.bean.read.DetailExtraBean;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.SectionListDetailBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.read.ThemeNewsDetailBean;
import com.readweather.model.bean.read.ZhihuDetailBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lizhe on 2017/10/14 0014.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public interface ReadApi {

    @GET("news/latest")
    Flowable<NewListBean> getNewsList();

    /**
     * 往期日报
     */
    @GET("news/before/{date}")
    Flowable<DailyBeforeListBean> getDailyBeforeList(@Path(value = "date") String date);

    /**
     * 主题日报
     * @return
     */
    @GET("themes")
    Flowable<ThemeListBean> getThemeList();

    @GET("theme/{id}")
    Flowable<ThemeNewsDetailBean> getThemeNewsDetailList(@Path(value = "id") int id);

    /**
     * 专栏
     * @return
     */
    @GET("sections")
    Flowable<SectionListBean> getSectionList();

    @GET("section/(id)")
    Flowable<SectionListDetailBean> getSectionNewsDetailList(@Path(value = "id") int id);

    /**
     * 热门
     */
    @GET("news/hot")
    Flowable<HotListBean> getHotList();

    /**
     * 日报详情
     */
    @GET("news/{id}")
    Flowable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);

    /**
     * 日报的额外信息
     */
    @GET("story-extra/{id}")
    Flowable<DetailExtraBean> getDetailExtraInfo(@Path("id") int id);

    /**
     * 日报的长评论
     */
    @GET("story/{id}/long-comments")
    Flowable<CommentBean> getLongCommentInfo(@Path("id") int id);

    /**
     * 日报的短评论
     */
    @GET("story/{id}/short-comments")
    Flowable<CommentBean> getShortCommentInfo(@Path("id") int id);
}
