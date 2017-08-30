package com.readweather.presenter.meizi;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.contract.MeitiContract;
import com.readweather.utils.RxUtil;
import com.readweather.widgets.CommonSubscriber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lizhe
 * time： 2017-08-30
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MeituPresenter extends BasePresenterImpl<MeitiContract.View> implements MeitiContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MeituPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getMeitu(final String url, final String realUrl, final String fakeRefer) {
        addSubscribe(mDataManager.fetchMeizituInfo(url)
                    .just(url)
                    .subscribeOn(Schedulers.io())
                    .map(new Function<String, List<Girl>>() {
                        @Override
                        public List<Girl> apply(@NonNull String s) throws Exception {
                            List<Girl> girls = new ArrayList<>();
                            try {
                                Document doc = Jsoup.connect(url).timeout(10000).get();
                                Element total = doc.select("div.postlist").first();
                                Elements items = total.select("li");
                                for (Element element : items) {
                                    Girl girl = new Girl(String.format(realUrl, element.select("img").first().attr("data-original"), fakeRefer));
                                    girl.setLink(element.select("a[href]").attr("href"));
                                    girls.add(girl);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return girls;
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new CommonSubscriber<List<Girl>>(mView) {
                        @Override
                        public void onNext(List<Girl> girls) {
                            mView.showMeitu(girls);
                        }
                    })


        );
    }

}
