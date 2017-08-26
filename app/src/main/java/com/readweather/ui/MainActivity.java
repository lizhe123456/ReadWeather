package com.readweather.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SlidingDrawer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.readweather.R;
import com.readweather.base.BaseActivity;
import com.readweather.ui.bus.BusFragment;
import com.readweather.ui.meizi.MeiZiFragment;
import com.readweather.ui.read.ReadFragment;
import com.readweather.ui.weather.WeatherFragment;
import com.readweather.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author：lizhe
 * time： 2017-08-24
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.fragment_context)
    FrameLayout fragmentContext;
    @BindView(R.id.navigation_menu)
    NavigationView navigationMenu;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;

    private ImageView imageView;
    private LayoutInflater inflater;

    private static final String FRAGMENT_TAG_BUS = "bus";
    private static final String FRAGMENT_TAG_WEATHER = "weather";
    private static final String FRAGMENT_TAG_MEIZI = "meizi";
    private static final String FRAGMENT_TAG_READING = "reading";

    private FragmentManager fragmentManager;
    private String currentFragmentTag;
    private String tag = FRAGMENT_TAG_WEATHER;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
//        navigationMenu.inflateHeaderView(R.layout.navigation_head);
        inflater = LayoutInflater.from(mActivity);
        View view = inflater.inflate(R.layout.navigation_head,null);
        imageView = (ImageView) view.findViewById(R.id.img_head);
        Glide.with(MainActivity.this).load(R.drawable.navigation_head).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
        navigationMenu.addHeaderView(view);
        navigationMenu.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        setContentFragment(tag);
        drawerlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                setContentFragment(tag);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    @Override
    protected void setData() {

    }

    public void setToolBar(Toolbar toolBar){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerlayout,toolBar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        actionBarDrawerToggle.syncState();
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_item_0:
                item.setChecked(true);
                tag = FRAGMENT_TAG_WEATHER;
                break;
            case R.id.navigation_item_1:
                item.setChecked(true);
                tag = FRAGMENT_TAG_BUS;
                break;
            case R.id.navigation_item_2:
                item.setChecked(true);
                tag = FRAGMENT_TAG_READING;
                break;
            case R.id.navigation_item_3:
                item.setChecked(true);
                tag = FRAGMENT_TAG_MEIZI;
                break;
            case R.id.navigation_item_settings:
                break;
            case R.id.navigation_item_about:
                break;
        }
        drawerlayout.closeDrawers();
        return true;
    }

    public void setContentFragment(String tag){

        if (currentFragmentTag != null && currentFragmentTag.equals(tag)){
            return;
        }

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);

        if (currentFragment != null) {
            ft.hide(currentFragment);
        }
        Fragment foundFragment = fragmentManager.findFragmentByTag(tag);

        if (foundFragment == null){
            switch (tag){
                case FRAGMENT_TAG_WEATHER:
                    foundFragment = new WeatherFragment();
                    break;
                case FRAGMENT_TAG_BUS:
                    foundFragment = new BusFragment();
                    break;
                case FRAGMENT_TAG_READING:
                    foundFragment = new ReadFragment();
                    break;
                case FRAGMENT_TAG_MEIZI:
                    foundFragment = new MeiZiFragment();
                    break;
            }
        }

        if (foundFragment == null){

        }else if (foundFragment.isAdded()){
            ft.show(foundFragment);
        }else {
            ft.add(R.id.fragment_context,foundFragment,tag);
        }
        ft.commit();
        currentFragmentTag = tag;
        invalidateOptionsMenu();

    }
}
