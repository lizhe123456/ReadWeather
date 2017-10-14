package com.readweather.ui.meizi.fragment;

import com.readweather.model.bean.Girl;
import com.readweather.presenter.meizi.MeituPresenter;
import com.readweather.presenter.meizi.contract.MeitiContract;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class MeituFragment extends BaseGankFragment<MeituPresenter> implements MeitiContract.View{

    private int currentPage = 1;
    private String url;
    private String fakeRefer;
    private String realUrl;

    @Override
    public void showMeitu(List<Girl> list) {
        currentPage++;
        if (adapter.getmList() == null || adapter.getmList().size() == 0) {
            adapter.setNewData(list);
        } else {
            adapter.addData(adapter.getmList().size(), list);
        }
    }



    @Override
    protected void refresh() {
        super.refresh();

        mPresenter.getMeitu(url,realUrl,fakeRefer);
    }

    @Override
    protected void initUrl() {
        fakeRefer = getArguments().getString("url") + "/";
        realUrl = "http://api.caoliyu.cn/meizitu.php?url=%s&refer=%s";
        url = getArguments().getString("url") + "/page/" + currentPage;
    }

    @Override
    protected void getMore() {
        super.getMore();
        mPresenter.getMeitu(url,realUrl,fakeRefer);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
