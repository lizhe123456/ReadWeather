package com.readweather.widgets;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by lizhe on 2017/10/28 0028.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);

        //用fresco加载图片简单用法，记得要写下面的createImageView方法
        Uri uri = Uri.parse((String) path);
        imageView.setImageURI(uri);
    }

}
