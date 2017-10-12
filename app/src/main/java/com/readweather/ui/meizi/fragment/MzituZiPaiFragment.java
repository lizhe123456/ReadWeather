package com.readweather.ui.meizi.fragment;

import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.MeituPresenter;
import com.readweather.presenter.meizi.contract.MeitiContract;
import com.readweather.service.GirlsThread;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class MzituZiPaiFragment extends BaseGankFragment<MeituPresenter> implements MeitiContract.View{

    private int currentPage = 1;
    private String url;

    @Override
    public void showMeitu(List<Girl> list) {
        currentPage++;
        GirlsThread.startWork(getContext(),list,getClass().getName());
    }

    @Override
    protected void refresh() {
        super.refresh();
        mPresenter.getMeitu(url);
    }

    @Override
    protected void getMore() {
        super.getMore();
        mPresenter.getMeitu(url);

    }

    @Override
    protected void initUrl() {
        url = getArguments().getString("url") + "/comment-page-" + currentPage + "#comments";
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
