package com.readweather.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.readweather.R;
import com.readweather.base.BaseActivity;
import com.readweather.ui.bus.BusFragment;
import com.readweather.ui.meizi.MeiZiFragment;
import com.readweather.ui.read.ReadFragment;
import com.readweather.ui.weather.WeatherFrament;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fragment_context)
    FrameLayout fragmentContext;
    @BindView(R.id.navigation_menu)
    NavigationView navigationMenu;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.img_head)
    ImageView imgHead;

    private FragmentManager mFragmentManager;

    private String currentlyFragmentTag;

    private ActionBarDrawerToggle mDrawerToggle;

    private static final String FRAGMENT_TAG_BUS = "bus";
    private static final String FRAGMENT_TAG_WEATHER = "weather";
    private static final String FRAGMENT_TAG_MEIZI = "meizi";
    private static final String FRAGMENT_TAG_READ = "read";
    public static final String CURRENT_INDEX = "currentIndex";


    @Nullable
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
//        mFragmentManager = getSupportFragmentManager();
        initNavigationHead();
    }

    public void initDrawer(Toolbar toolbar) {
        if (toolbar != null) {
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                }
            };
            mDrawerToggle.syncState();
            drawerlayout.addDrawerListener(mDrawerToggle);
        }
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            setContext(FRAGMENT_TAG_WEATHER);
        } else {
            currentlyFragmentTag = savedInstanceState.getString(CURRENT_INDEX);
            setContext(currentlyFragmentTag);
        }
    }

    private void setContext(String tag) {
        if (currentlyFragmentTag != null && currentlyFragmentTag.equals(tag)) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            //通过tag找到fragment
            Fragment currentFragment = mFragmentManager.findFragmentByTag(currentlyFragmentTag);

            if (currentFragment != null) {
                //添加fragment
                ft.hide(currentFragment);
            }

            Fragment foundFragment = mFragmentManager.findFragmentByTag(tag);
            if (foundFragment == null) {
                switch (tag) {
                    case FRAGMENT_TAG_BUS:
                        foundFragment = new BusFragment();
                        break;
                    case FRAGMENT_TAG_WEATHER:
                        foundFragment = new WeatherFrament();
                        break;
                    case FRAGMENT_TAG_MEIZI:
                        foundFragment = new MeiZiFragment();
                        break;
                    case FRAGMENT_TAG_READ:
                        foundFragment = new ReadFragment();
                        break;
                }
            }
            if (foundFragment.isAdded()) {
                ft.show(foundFragment);
            } else {
                ft.add(R.id.fragment_context, foundFragment, tag);
            }
            ft.commit();
            currentlyFragmentTag = tag;
            invalidateOptionsMenu();
        }

    }

    private void initNavigationHead() {
        navigationMenu.inflateHeaderView(R.layout.navigation_head);
        navigationMenu.setNavigationItemSelectedListener(this);
        Glide.with(this).load(R.drawable.navigation_head).into(imgHead);
    }

    @Override
    protected void setData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_item_0:
                item.setChecked(true);
                setContext(FRAGMENT_TAG_WEATHER);
                break;
            case R.id.navigation_item_1:
                item.setChecked(true);
                setContext(FRAGMENT_TAG_BUS);
                break;
            case R.id.navigation_item_2:
                item.setChecked(true);
                setContext(FRAGMENT_TAG_READ);
                break;
            case R.id.navigation_item_3:
                item.setChecked(true);
                setContext(FRAGMENT_TAG_MEIZI);
                break;
            case R.id.navigation_item_settings:
                break;
            case R.id.navigation_item_about:
                break;
        }
        return false;
    }

}
