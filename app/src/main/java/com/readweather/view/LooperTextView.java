package com.readweather.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

/**
 * Created by Administrator on 2018/2/8.
 */

public class LooperTextView extends LinearLayout {

    private List<String> topText;
    private View in_view;
    private View out_view;
    //间隔时间
    private final int mGap = 4000;
    //动画间隔时间
    private final int mAnimDuration = 1000;
    //播放的下标
    private int mPosition;
    //线程的标识
    private boolean isStarted;
    //画笔
    private Paint mPaint;


    public LooperTextView(@NonNull Context context) {
        super(context);
    }

    public LooperTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LooperTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        
    }
}
