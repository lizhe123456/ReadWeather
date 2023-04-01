package com.readweather.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.navigation.NavigationView;
import com.readweather.R;
import com.readweather.base.BaseActivity;
import com.readweather.ui.home.HomePageFragment;
import com.readweather.ui.map.MapFragment;
import com.readweather.ui.meizi.MeiZiFragment;
import com.readweather.ui.read.ReadFragment;
import com.readweather.ui.setting.SettingActivity;

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

    private static final String FRAGMENT_TAG_MAP = "map";
    private static final String FRAGMENT_TAG_WEATHER = "weather";
    private static final String FRAGMENT_TAG_MEIZI = "meizi";
    private static final String FRAGMENT_TAG_READING = "reading";

    private FragmentManager fragmentManager;
    private String currentFragmentTag;
    private String tag = FRAGMENT_TAG_MEIZI;
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
                tag = FRAGMENT_TAG_MAP;
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
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
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
                    foundFragment = new HomePageFragment();
                    break;
                case FRAGMENT_TAG_MAP:
                    foundFragment = new MapFragment();
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

    @Nullable
    public DrawerLayout getDrawerlayout() {
        return drawerlayout;
    }

    @Nullable
    public NavigationView getNavigationMenu() {
        return navigationMenu;
    }
}
