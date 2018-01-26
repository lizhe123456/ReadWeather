package com.readweather.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.readweather.R;

/**
 * Created by Administrator on 2018/1/26.
 */

@SuppressLint("AppCompatCustomView")
public class ImageTextView extends RelativeLayout{

    TextView textView;
    ImageView imageView;

    private String text;
    private float textSize;
    private int textColor;
    private int textBg;
    private int textPadding;
    private boolean cneter;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.ImageTextView);
        LayoutInflater.from(context).inflate(R.layout.image_text_view,this);
        textView = findViewById(R.id.tv_desc);
        imageView = findViewById(R.id.image);
        textSize = ta.getDimension(R.styleable.ImageTextView_text_size,12);
        textColor = ta.getInteger(R.styleable.ImageTextView_text_color,R.color.white);
        textBg = ta.getInteger(R.styleable.ImageTextView_text_bg,android.R.color.transparent);
        textPadding = ta.getInteger(R.styleable.ImageTextView_text_paddingLife,0);
        cneter = ta.getBoolean(R.styleable.ImageTextView_text_gravity,false);
        cneter = ta.getBoolean(R.styleable.ImageTextView_text1,false);
        if (cneter){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            textView.setLayoutParams(params);
        }else {
            textView.setPadding(textPadding,textView.getPaddingTop(),textView.getPaddingRight(),textView.getPaddingBottom());
        }
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setBackgroundResource(textBg);
        textView.setText(text);
        ta.recycle();
    }

    public ImageView getImageView() {
        return imageView;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextBg() {
        return textBg;
    }

    public void setTextBg(int textBg) {
        this.textBg = textBg;
    }

    public int getTextPadding() {
        return textPadding;
    }

    public void setTextPadding(int textPadding) {
        this.textPadding = textPadding;
    }

    public boolean isCneter() {
        return cneter;
    }

    public void setCneter(boolean cneter) {
        this.cneter = cneter;
    }
}
