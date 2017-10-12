package com.readweather.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by lizhe on 2017/10/7 0007.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */

public class ShareUtil {

    private static final String EMAIL_ADDRESS = "603399531@qq.com";

    public static void shareText(Context context, String text, String title){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        context.startActivity(Intent.createChooser(intent,title));
    }

    public static void shareImage(Context context, Uri uri, String title){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/png");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        context.startActivity(Intent.createChooser(intent,title));
    }

    public static void sendEmail(Context context, String title) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(
                "mailto:" + EMAIL_ADDRESS));
        context.startActivity(Intent.createChooser(intent, title));
    }
}
