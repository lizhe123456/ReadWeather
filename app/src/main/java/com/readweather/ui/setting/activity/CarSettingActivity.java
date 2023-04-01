package com.readweather.ui.setting.activity;

import android.view.View;

import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import com.readweather.R;
import com.readweather.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by lizhe on 2017/9/14 0014.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class CarSettingActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.switch_0)
    SwitchCompat switch0;
    @BindView(R.id.switch_1)
    SwitchCompat switch1;
    @BindView(R.id.switch_2)
    SwitchCompat switch2;
    @BindView(R.id.switch_3)
    SwitchCompat switch3;

    @Override
    protected int setLayout() {
        return R.layout.activity_carsrtting;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        toolBar.setTitle("驾车设置");
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
        initToolbar(toolBar);
    }


    @OnClick({R.id.setting_0, R.id.setting_1, R.id.setting_2, R.id.setting_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_0:
                switch0.setChecked(true);
                switch1.setChecked(false);
                switch2.setChecked(false);
                switch3.setChecked(false);
                break;
            case R.id.setting_1:
                switch0.setChecked(false);
                switch1.setChecked(true);
                switch2.setChecked(false);
                switch3.setChecked(false);
                break;
            case R.id.setting_2:
                switch0.setChecked(false);
                switch1.setChecked(false);
                switch2.setChecked(true);
                switch3.setChecked(false);
                break;
            case R.id.setting_3:
                switch0.setChecked(false);
                switch1.setChecked(false);
                switch2.setChecked(false);
                switch3.setChecked(true);
                break;
        }
    }
}
