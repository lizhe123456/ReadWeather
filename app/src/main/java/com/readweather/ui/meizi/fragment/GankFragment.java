package com.readweather.ui.meizi.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.readweather.R;
import com.readweather.base.MvpFragment;
import com.readweather.model.bean.GankBean;
import com.readweather.presenter.meizi.GirlsPresenter;
import com.readweather.presenter.meizi.contract.GirlsContract;
import com.readweather.ui.meizi.adapter.GankAdapter;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class GankFragment extends MvpFragment<GirlsPresenter> implements GirlsContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private List<GankBean> mList;

    private StaggeredGridLayoutManager layoutManager;

    private GankAdapter adapter;

    private static final int SPAN_COUNT = 2;




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
                mPresenter.getGirlsData();
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
                        mPresenter.getMore();
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
        mPresenter.getGirlsData();
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
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<GankBean> list) {
        if (refresh.isRefreshing()){
            refresh.setRefreshing(false);
        }
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showMore(List<GankBean> list) {
        mList.addAll(list);
        for (int i = mList.size() - GirlsPresenter.NUM ; i < mList.size(); i++){
            adapter.notifyItemInserted(i);
        }
    }

}
