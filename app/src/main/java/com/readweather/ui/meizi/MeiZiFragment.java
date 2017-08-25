package com.readweather.ui.meizi;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;
import android.widget.TextView;

import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.ui.MainActivity;
import com.readweather.ui.meizi.adapter.MeiZiAdapter;
import com.readweather.ui.meizi.fragment.GankFragment;
import com.readweather.ui.meizi.fragment.JiandanFragment;
import com.readweather.ui.meizi.fragment.MeituFragment;
import com.readweather.ui.meizi.fragment.MzituZiPaiFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MeiZiFragment extends BaseFrament {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.fristLayout)
    CoordinatorLayout fristLayout;
    @BindView(R.id.error)
    ViewStub error;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;


    @Override
    protected int setLayout() {
        return R.layout.fragment_meizi;
    }

    @Override
    protected void init() {
        toolBar.setTitle(R.string.navigation_item3);
        ((MainActivity) getActivity()).setToolBar(toolBar);
    }


    @Override
    protected void setData() {
        Bundle data;
        MeiZiAdapter adapter = new MeiZiAdapter(getChildFragmentManager());
        Fragment fragment = new GankFragment();
        adapter.addFrag(fragment, "Gank");

        fragment = new JiandanFragment();
        adapter.addFrag(fragment, "煎蛋");

        fragment = new MeituFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/hot");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "最热");

        fragment = new MeituFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/xinggan");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "性感妹子");

        fragment = new MeituFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/japan");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "日本妹子");

        fragment = new MeituFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/taiwan");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "台湾妹子");

        fragment = new MeituFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/mm");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "清纯妹子");

        fragment = new MzituZiPaiFragment();
        data = new Bundle();
        data.putString("url", "http://www.mzitu.com/share");
        fragment.setArguments(data);
        adapter.addFrag(fragment, "妹子自拍");

        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());
        viewPager.setCurrentItem(0);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
