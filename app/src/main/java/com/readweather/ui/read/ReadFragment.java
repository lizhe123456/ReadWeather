package com.readweather.ui.read;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.readweather.R;
import com.readweather.base.BaseFrament;
import com.readweather.ui.MainActivity;
import com.readweather.ui.meizi.adapter.MeiZiAdapter;
import com.readweather.ui.read.fragment.ColumnFragment;
import com.readweather.ui.read.fragment.HotNewsFragment;
import com.readweather.ui.read.fragment.MainNewsFragment;
import com.readweather.ui.read.fragment.ThemeFragment;

import butterknife.BindView;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class ReadFragment extends BaseFrament {


    FragmentManager fragmentManager;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.fristLayout)
    CoordinatorLayout fristLayout;

    @Override
    protected int setLayout() {
        return R.layout.fragment_read;
    }

    @Override
    protected void init() {
        toolBar.setTitle(R.string.news);
        fragmentManager = getFragmentManager();
        ((MainActivity) getActivity()).setToolBar(toolBar);
    }

    @Override
    protected void setData() {
        MeiZiAdapter adapter = new MeiZiAdapter(getChildFragmentManager());
        Fragment fragment = new MainNewsFragment();
        adapter.addFrag(fragment, "日报");

        fragment = new ThemeFragment();
        adapter.addFrag(fragment, "主题");

        fragment = new ColumnFragment();
        adapter.addFrag(fragment, "专栏");

        fragment = new HotNewsFragment();
        adapter.addFrag(fragment, "热门");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(0);
        viewPager.setCurrentItem(0);
        tabs.setupWithViewPager(viewPager);
    }

}
