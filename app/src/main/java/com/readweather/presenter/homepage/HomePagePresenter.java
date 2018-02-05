package com.readweather.presenter.homepage;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.HomeBean;
import com.readweather.model.bean.read.NewListBean;
import com.readweather.model.bean.read.SectionListBean;
import com.readweather.model.bean.read.ThemeListBean;
import com.readweather.model.bean.weather.WeatherBean;
import com.readweather.model.http.response.WeatherResponse;
import com.readweather.presenter.homepage.contract.HomePageContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.functions.Function5;

/**
 * Created by Administrator on 2018/2/5.
 */

public class HomePagePresenter extends BasePresenterImpl<HomePageContract.View> implements HomePageContract.Presenter {

    DataManager dataManager;

    @Inject
    public HomePagePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     * 请求数据
     * @param location
     */
    @Override
    public void getHomePage(String location) {
        addSubscribe(Flowable.zip(dataManager.fetchWeatherInfo(location),
                dataManager.fetchThemeListInfo(),
                dataManager.fetchSectionListInfo(),
                dataManager.fetchNewsListInfo(),
                dataManager.fetchTodayOnhistoryInfo(),
                new Function5<WeatherResponse<WeatherBean>, ThemeListBean, SectionListBean,NewListBean,HomeBean.TodayOnhistory,HomeBean>() {
                    @Override
                    public HomeBean apply(WeatherResponse<WeatherBean> weatherBeanWeatherResponse, ThemeListBean themeListBean,
                                          SectionListBean sectionListBean, NewListBean newListBean,
                                          HomeBean.TodayOnhistory todayOnhistory) throws Exception {
                        return createHomeBean(weatherBeanWeatherResponse,themeListBean,sectionListBean,newListBean,todayOnhistory);
                    }

                })
                .compose(RxUtil.<HomeBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        mView.showContent(homeBean);
                    }
                })
        );
    }

    /**
     * 创建实体
     * @param weatherBeanWeatherResponse
     * @param themeListBean
     * @param sectionListBean
     * @param todayOnhistory
     * @return
     */
    private HomeBean createHomeBean(WeatherResponse<WeatherBean> weatherBeanWeatherResponse,
                                    ThemeListBean themeListBean,
                                    SectionListBean sectionListBean,
                                    NewListBean newListBean,
                                    HomeBean.TodayOnhistory todayOnhistory){
        HomeBean homeBean = new HomeBean();
        homeBean.setSectionList(sectionListBean.getData());
        homeBean.setOthersBeans(themeListBean.getOthers());
        WeatherBean weatherBean = weatherBeanWeatherResponse.getData().get(0);
        HomeBean.Weather weather = new HomeBean.Weather(weatherBean.getBasic().getParent_city(),weatherBean.getUpdate().getLoc(),weatherBean.getNow().getCond_txt(),weatherBean.getNow().getTmp(),weatherBean.getDaily_forecast(),weatherBean.getLifestyle());
        homeBean.setWeather(weather);
        homeBean.setaNew(newListBean.getTop_stories());
        homeBean.setTodayOnhistory(todayOnhistory);
        return homeBean;
    }
}
