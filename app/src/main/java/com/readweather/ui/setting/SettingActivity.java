package com.readweather.ui.setting;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.readweather.R;
import com.readweather.base.BaseActivity;
import com.readweather.ui.setting.activity.CarSettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2017/9/14 0014.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;

    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        toolBar.setTitle("设置");
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
        initToolbar(toolBar);

    }

    @OnClick({R.id.relativeLayout})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.relativeLayout:
                Intent intent = new Intent(this,CarSettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
