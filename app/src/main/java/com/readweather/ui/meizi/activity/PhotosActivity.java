package com.readweather.ui.meizi.activity;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
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
import com.readweather.app.App;
import com.readweather.app.Constants;
import com.readweather.base.MvpActivity;
import com.readweather.model.bean.RealmLikeBean;
import com.readweather.model.db.RealmHelper;
import com.readweather.presenter.db.LikePresenter;
import com.readweather.presenter.db.contract.LikeContract;
import com.readweather.utils.ShareUtil;
import com.readweather.utils.SnackbarUtil;
import com.readweather.utils.SystemUtil;
import com.readweather.utils.ToastUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by lizhe on 2017/9/15 0015.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class PhotosActivity extends MvpActivity<LikePresenter> implements LikeContract.View {

    public static final String URL = "url";
    private static final int ACTION_SAVE = 0;
    private static final int ACTION_SHARE = 1;

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
    private RxPermissions rxPermissions;
    private boolean isLiked;
    private RealmHelper mRealmHelper;
    private String id;

    @Override
    protected int setLayout() {
        return R.layout.activity_photos;
    }

    @Override
    protected void init() {
//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) title.getLayoutParams();
//        params.setMargins(0,getStatusBarHeight(),0,0);
        mRealmHelper = App.getAppComponent().getDbHelper();
        setWindowStatusBarColor(R.color.black_all);
        img = getIntent().getStringExtra(URL);
        setLikeState(mRealmHelper.queryLikeBean(img));
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


    @OnClick({R.id.menu, R.id.share, R.id.collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu:
                showPopupMenu(menu);
                break;
            case R.id.share:
                //分享
                checkPermissionAndAction(ACTION_SHARE);
                break;
            case R.id.collection:
                //收藏
                collectionBitmap();
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
                        checkPermissionAndAction(ACTION_SAVE);
                        break;
                    case R.id.photo_item_1:
                        //设置为壁纸
                        setWallPager(bitmap);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }


    //设置图片为壁纸
    private void setWallPager(Bitmap bitmap){
        WallpaperManager mWallManager= WallpaperManager.getInstance(getApplicationContext());
        try {
            mWallManager.setBitmap(bitmap);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //收藏图片
    private void collectionBitmap(){
        if (isLiked){
            setLikeState(false);
            mRealmHelper.deleteLikeBean(img);
        }else {
            setLikeState(true);
            RealmLikeBean bean = new RealmLikeBean();
            bean.setId(this.id);
            bean.setImage(img);
            bean.setType(Constants.TYPE_GIRL);
            bean.setTime(System.currentTimeMillis());
            mRealmHelper.insertLike(bean);
        }
    }

    private void setLikeState(boolean state) {
        if(state) {
            collection.setImageResource(R.drawable.collection_selected);
            isLiked = true;
        } else {
            collection.setImageResource(R.drawable.collection_no);
            isLiked = false;

        }
    }

    private void checkPermissionAndAction(final int action) {
        if (rxPermissions == null) {
            rxPermissions = new RxPermissions(this);
        }
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) {
                        if (granted) {
                            if (action == ACTION_SAVE) {
                                SystemUtil.saveBitmapToFile(PhotosActivity.this, img, bitmap, imageView, false);
                            } else if (action == ACTION_SHARE) {
                                ShareUtil.shareImage(PhotosActivity.this, SystemUtil.saveBitmapToFile(PhotosActivity.this, img, bitmap, imageView, true), "分享一只妹纸");
                            }
                        } else {
                            ToastUtil.showShort("获取写入权限失败");
                        }
                    }
                });
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
