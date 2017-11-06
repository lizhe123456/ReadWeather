package com.readweather.ui.read.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.base.MvpBackActivity;
import com.readweather.base.adapter.BaseAdapter;
import com.readweather.base.adapter.BaseViewHolder;
import com.readweather.model.bean.read.HotListBean;
import com.readweather.model.bean.read.ThemeNewsDetailBean;
import com.readweather.presenter.read.ThemeDetailPresenter;
import com.readweather.presenter.read.contract.ThemeDetailContract;
import com.readweather.utils.GlideuUtil;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lizhe on 2017/11/6 0006.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ThemeActivity extends MvpBackActivity<ThemeDetailPresenter> implements ThemeDetailContract.View {

    @BindView(R.id.detail_bar_image)
    ImageView detailBarImage;
    @BindView(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @BindView(R.id.view_toolbar)
    Toolbar viewToolbar;
    @BindView(R.id.clp_toolbar)
    CollapsingToolbarLayout clpToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    @BindView(R.id.author_list)
    RecyclerView authorList;

    private AuthorAdapter mAdapter;
    private NewsAdapter mNewsAdapter;

    @Override
    public void stateError() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_theme_list;
    }

    @Override
    protected void setData() {
        int id = getIntent().getIntExtra("id", 0);
        mPresenter.getThemeDetail(id);
        mAdapter = new AuthorAdapter(this);
        mNewsAdapter = new NewsAdapter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL,1));
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        authorList.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mNewsAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        authorList.setAdapter(mAdapter);
    }

    @Override
    public void showContent(ThemeNewsDetailBean bean) {
        detailBarCopyright.setText(bean.getName());
        GlideuUtil.loadImageView(this,bean.getImage(),detailBarImage);
        mNewsAdapter.addFirstDataSet(bean.getStories());
        mAdapter.addFirstDataSet(bean.getEditors());
        mNewsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                ThemeNewsDetailBean.StoriesBean bean = (ThemeNewsDetailBean.StoriesBean) item;
                Intent intent = new Intent();
                intent.putExtra("id",bean.getId());
                intent.setClass(getApplicationContext(), NewsDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 作者列表适配器
     */
    class AuthorAdapter extends BaseAdapter<ThemeNewsDetailBean.EditorsBean>{

        public AuthorAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ThemeNewsDetailBean.EditorsBean item, int position) {
            holder.setGlieuImage(R.id.image,item.getAvatar());
        }

        @Override
        protected int getItemViewLayoutId(int position, ThemeNewsDetailBean.EditorsBean item) {
            return R.layout.author_list;
        }
    }

    /**
     * 文章列表适配器
     */
    class NewsAdapter extends BaseAdapter<ThemeNewsDetailBean.StoriesBean>{

        public NewsAdapter(Context context) {
            super(context);
        }

        @Override
        protected void bindDataToItemView(BaseViewHolder holder, ThemeNewsDetailBean.StoriesBean item, int position) {
            if (item.getImages() != null) {
                holder.setGlieuImage(R.id.iv_news_img, item.getImages().get(0));
            }
            holder.setText(R.id.tv_title,item.getTitle());
        }

        @Override
        protected int getItemViewLayoutId(int position, ThemeNewsDetailBean.StoriesBean item) {
            return R.layout.news_list_item;
        }
    }

}
