package com.readweather.ui.read;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.readweather.R;
import com.readweather.base.BaseFrament;
import butterknife.BindView;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class ReadFragment extends BaseFrament {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    FragmentManager fragmentManager;

    @Override
    protected int setLayout() {
        return R.layout.fragment_read;
    }

    @Override
    protected void init() {
        fragmentManager = getFragmentManager();
    }

    @Override
    protected void setData() {

    }

}
