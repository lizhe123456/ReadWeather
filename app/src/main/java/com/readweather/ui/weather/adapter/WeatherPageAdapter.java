package com.readweather.ui.weather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lizhe on 2017/11/22 0022.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class WeatherPageAdapter extends FragmentPagerAdapter{

    List<Fragment> mFragmentList = new ArrayList<>();

    public WeatherPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    public void addFrag(Fragment fragment){
        mFragmentList.add(fragment);
    }
}
