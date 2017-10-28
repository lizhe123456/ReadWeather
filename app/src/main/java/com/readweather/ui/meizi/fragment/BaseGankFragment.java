package com.readweather.ui.meizi.fragment;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.readweather.R;
import com.readweather.base.BasePresenter;
import com.readweather.base.BaseView;
import com.readweather.base.MvpFragment;
import com.readweather.event.GirlsComingEvent;
import com.readweather.model.bean.Girl;
import com.readweather.ui.meizi.adapter.GankAdapter;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public abstract class BaseGankFragment<T extends BasePresenter> extends MvpFragment<T> implements BaseView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    protected List<Girl> mList;

    protected StaggeredGridLayoutManager layoutManager;

    protected GankAdapter adapter;

    private static final int SPAN_COUNT = 2;
    protected boolean isLoadMore = false;


    @Override
    public void stateError() {
        if (refresh.isRefreshing()) {
            refresh.setRefreshing(false);
        }
    }



    @Override
    protected int setLayout() {
        return R.layout.gank_fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void setData() {
        mList = new ArrayList<>();
        adapter = new GankAdapter(mList,getContext());
        //瀑布流布局管理器
        layoutManager = new StaggeredGridLayoutManager(SPAN_COUNT,StaggeredGridLayoutManager.VERTICAL);
        //解决瀑布流左右乱跑问题
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        layoutManager.setItemPrefetchEnabled(false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //下拉刷新
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        //上拉加载
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //用来标记是否正在向最后一个滑动，既是否向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] lastVisiblePositions = manager.findLastVisibleItemPositions(new int[manager.getSpanCount()]);
                    int lastVisiblePos = getMaxElem(lastVisiblePositions);
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部
                    if (lastVisiblePos == (totalItemCount - 1) && isSlidingToLast) {
                        //加载更多功能的代码
                        getMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dy > 0){
                    //大于0表示，正在向下滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向上滚动
                    isSlidingToLast = false;
                }
            }
        });
        loading();
        refresh();
    }

    protected void getMore(){
        isLoadMore = true;
        initUrl();
    }

    protected void initUrl() {
    }

    protected void refresh(){
        isLoadMore = false;
        initUrl();
    }


    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    @Override
    protected void initInject() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(GirlsComingEvent event) {
        if (!event.getFrom().equals(this.getClass().getName()))
            return;
        mList = event.getGirls();
        if (isLoadMore) {
            if (mList.size() == 0) {
//                adapter.setLoadEndView(R.layout.load_end_layout);
            } else {
                adapter.setLoadMoreData(mList);
            }
        } else {
            adapter.setNewData(mList);
            if (refresh.isRefreshing()) {
                refresh.setRefreshing(false);
            }
        }
    }
}
