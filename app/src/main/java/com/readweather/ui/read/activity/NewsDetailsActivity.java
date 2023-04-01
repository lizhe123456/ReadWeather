package com.readweather.ui.read.activity;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.readweather.R;
import com.readweather.base.MvpBackActivity;
import com.readweather.model.bean.read.DetailExtraBean;
import com.readweather.model.bean.read.ZhihuDetailBean;
import com.readweather.presenter.read.NewsDetailsPresenter;
import com.readweather.presenter.read.contract.NewsDetailsContract;
import com.readweather.utils.GlideuUtil;
import com.readweather.utils.HtmlUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

import butterknife.BindView;
import me.imid.swipebacklayout.lib.SwipeBackLayout;


/**
 * Created by lizhe on 2017/11/4 0004.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class NewsDetailsActivity extends MvpBackActivity<NewsDetailsPresenter> implements NewsDetailsContract.View {
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
    @BindView(R.id.view_main)
    WebView viewMain;
    @BindView(R.id.nsv_scroller)
    NestedScrollView nsvScroller;

    String shareUrl;
    String imgUrl;

    @Override
    public void stateError() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void setData() {
        int id =  getIntent().getIntExtra("id",0);
        mPresenter.getDetailData(id);
        SwipeBackLayout ss = getSwipeBackLayout();
        ss.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
        initWebView();
    }

    private void initWebView() {
        WebSettings settings = viewMain.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        viewMain.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void showContent(ZhihuDetailBean zhihuDetailBean) {
        imgUrl = zhihuDetailBean.getImage();
        shareUrl = zhihuDetailBean.getShare_url();
        GlideuUtil.loadImageViewCache(this,zhihuDetailBean.getImage(),detailBarImage);

        clpToolbar.setTitle(zhihuDetailBean.getTitle());
        detailBarCopyright.setText(zhihuDetailBean.getImage_source());
        String htmlData = HtmlUtil.createHtmlData(zhihuDetailBean.getBody(),zhihuDetailBean.getCss(),zhihuDetailBean.getJs());
        viewMain.loadData(htmlData,HtmlUtil.MIME_TYPE,HtmlUtil.ENCODING);
    }

    @Override
    public void showExtraInfo(DetailExtraBean detailExtraBean) {

    }

    @Override
    public void setLikeButtonState(boolean isLiked) {

    }
}
