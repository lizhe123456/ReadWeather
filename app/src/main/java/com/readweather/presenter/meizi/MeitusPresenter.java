package com.readweather.presenter.meizi;

import com.readweather.base.BasePresenterImpl;
import com.readweather.model.DataManager;
import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.contract.MeitusContract;
import com.readweather.widgets.CommonSubscriber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lizhe on 2017/10/13 0013.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class MeitusPresenter extends BasePresenterImpl<MeitusContract.View> implements MeitusContract.Presenter{

    private DataManager mDataManager;
    private int Page;

    @Inject
    public MeitusPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getMeitus(final String url, final String realUrl, final String fakeRefer) {
        addSubscribe(mDataManager.fetchMeizituInfo(url)
                .just(url)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, List<Girl>>() {
                    @Override
                    public List<Girl> apply(@NonNull String s) throws Exception {
                        List<Girl> girls = new ArrayList<>();
                        try {
                            Document doc = Jsoup.connect(url).timeout(10000).get();
                            Element total = doc.select("div.main-image").first();
                            String img = total.select("img").first().attr("src");
                            girls.add(new Girl("99",String.format(realUrl, img, fakeRefer)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return girls;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CommonSubscriber<List<Girl>>(mView) {
                    @Override
                    public void onNext(List<Girl> list) {
                        mView.showMeitu(list);
                    }
                })
        );
    }

    @Override
    public void getMeitus(final String url, int totalPages) {
        Page = totalPages;
        addSubscribe(mDataManager.fetchMeizituInfo(url)
                .just(url)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, List<Girl>>() {
                    @Override
                    public List<Girl> apply(@NonNull String s) throws Exception {
                        List<Girl> girls = new ArrayList<>();
                        try {
                            Document doc = Jsoup.connect(url).timeout(10000).get();
                            Element total = doc.select("div.pagenavi").first();
                            Elements spans = total.select("span");
                            for (Element element : spans) {
                                int page;
                                try {
                                    page = Integer.parseInt(element.text());
                                    if (page >= page) {
                                        Page = page;
                                    }
                                } catch (Exception e) {

                                }
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
                    public void onNext(List<Girl> list) {
                        for (int i = 1; i <= Page; i++) {
                            mView.getMeiziFromServer(i);
                        }
                    }
                })
        );
    }
}
