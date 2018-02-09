package com.readweather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.readweather.R;
import com.readweather.view.adpter.LooperTextAdapter;

/**
 * Created by Administrator on 2018/2/8.
 */

public class LooperTextView extends ViewFlipper implements View.OnClickListener{

    private static final int DEFAULT_INTERVAL = 3000; // 默认轮播间隔 3 秒
    private static final int DEFAULT_ENTER_ANIM = R.anim.loop_view_in; // 默认进入动画 平移加渐变
    private static final int DEFAULT_LEAVE_ANIM = R.anim.loop_view_out; // 默认离开动画 平移加渐变

    private int mBulletinInterval = DEFAULT_INTERVAL;
    private int mBulletinInAnim = DEFAULT_ENTER_ANIM;
    private int mBulletinOutAnim = DEFAULT_LEAVE_ANIM;

    public LooperTextView(Context context) {
        super(context);
        init();
    }

    public LooperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        // 设置公告轮播间隔时间
        setFlipInterval(mBulletinInterval);
        // 设置进入和离开动画
        setInAnimation(AnimationUtils.loadAnimation(getContext(), mBulletinInAnim));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), mBulletinOutAnim));

    }

    public void setAdapter(LooperTextAdapter adapter) {
        if (adapter == null) {
            return;
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(i);
            view.setTag(i);
            addView(view);
            view.setOnClickListener(this);
        }
        startFlipping();
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        if (mOnLooperItemClickListener != null) {
            mOnLooperItemClickListener.onLooperItemClick(position);
        }
    }


    /**
     * 公告条目点击监听接口
     */
    public interface OnLooperItemClickListener {
        void onLooperItemClick(int position);
    }

    private OnLooperItemClickListener mOnLooperItemClickListener;

    /**
     * 设置公告条目点击监听器
     *
     * @param onLooperItemItemClickListener 公告条目点击监听器
     */
    public void setOnLooperItemClickListener(OnLooperItemClickListener onLooperItemItemClickListener) {
        mOnLooperItemClickListener = onLooperItemItemClickListener;
    }
}
