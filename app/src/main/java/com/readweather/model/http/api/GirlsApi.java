package com.readweather.model.http.api;

import com.readweather.model.bean.GankBean;
import com.readweather.model.bean.JiandanResponse;
import com.readweather.model.http.response.GirlsResponse;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public interface GirlsApi {

    @GET("http://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments")
    Flowable<JiandanResponse> getXXOO(@Query("page") int page);

    /**
     * 妹纸列表
     */
    @GET("data/福利/{num}/{page}")
    Flowable<GirlsResponse<List<GankBean>>> getGirlList(@Path("num") int num, @Path("page") int page);

    /**
     * 随机妹纸图
     */
    @GET("random/data/福利/{num}")
    Flowable<GirlsResponse<List<GankBean>>> getRandomGirl(@Path("num") int num);


}
