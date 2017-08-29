package com.readweather.ui.meizi.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.event.GirlsComingEvent;
import com.readweather.model.bean.GankBean;
import com.readweather.presenter.meizi.GirlsPresenter;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.service.GirlsThread;
import com.readweather.ui.meizi.adapter.GankAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankFragment extends BaseGankFragment<GirlsPresenter> implements GirlsContract.View {

    private static final String GABKFROM = "gank";


    @Override
    protected void refresh() {
        super.refresh();
        mPresenter.getGirlsData();
    }

    @Override
    protected void getMore() {
        super.getMore();
        mPresenter.getMore();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<GankBean> list) {
        GirlsThread.startWork(getContext(),list,GABKFROM);
    }

    @Override
    public void showMore(List<GankBean> list) {
        GirlsThread.startWork(getContext(),list,GABKFROM);
    }

}
