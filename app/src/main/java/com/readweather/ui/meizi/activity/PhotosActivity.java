package com.readweather.ui.meizi.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.readweather.R;
import com.readweather.base.MvpActivity;
import com.readweather.model.bean.RealmLikeBean;
import com.readweather.presenter.db.LikePresenter;
import com.readweather.presenter.db.contract.LikeContract;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by lizhe on 2017/9/15 0015.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class PhotosActivity extends MvpActivity<LikePresenter> implements LikeContract.View {

    public static final String URL = "url";

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.collection)
    ImageView collection;
    @BindView(R.id.picture)
    ImageView imageView;
    @BindView(R.id.title)
    RelativeLayout title;

    private boolean isCollection;
    private PhotoViewAttacher mAttacher;
    private String img;
    private Bitmap bitmap;

    @Override
    protected int setLayout() {
        return R.layout.activity_photos;
    }

    @Override
    protected void init() {
//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) title.getLayoutParams();
//        params.setMargins(0,getStatusBarHeight(),0,0);
        setWindowStatusBarColor(R.color.black_all);
        img = getIntent().getStringExtra(URL);
    }

    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    protected void setData() {
//        Glide.with(this).load(img).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.IMMEDIATE).crossFade(0)
//                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(imageView);
        Glide.with(this).load(img).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                bitmap = resource;
                imageView.setImageBitmap(resource);
                mAttacher = new PhotoViewAttacher(imageView);
            }
        });
    }


    @OnClick({R.id.back, R.id.menu, R.id.share, R.id.collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.menu:
                showPopupMenu(menu);
                break;
            case R.id.share:
                //分享
                break;
            case R.id.collection:
                //收藏

                break;
        }
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        //加载menu布局
        popupMenu.getMenuInflater().inflate(R.menu.photo_menu, popupMenu.getMenu());
        //menu点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.photo_item_0:
                        //保存图片到相册
                        break;
                    case R.id.photo_item_1:
                        //设置为壁纸
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void showContent(List<RealmLikeBean> mList) {

    }

    @Override
    public void stateError() {

    }

    private void setWindowStatusBarColor(int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(colorResId));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
