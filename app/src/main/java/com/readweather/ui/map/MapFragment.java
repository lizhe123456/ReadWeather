package com.readweather.ui.map;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.readweather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public class MapFragment extends Fragment {


    @BindView(R.id.map)
    MapView map;
    Unbinder unbinder;

    private AMap aMap;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_map, null);
            unbinder = ButterKnife.bind(this, view);
            map.onCreate(savedInstanceState);
            if (aMap == null) {
                aMap = map.getMap();
            }
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
