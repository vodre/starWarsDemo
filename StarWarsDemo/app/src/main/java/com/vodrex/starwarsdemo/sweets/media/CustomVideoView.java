package com.vodrex.starwarsdemo.sweets.media;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class CustomVideoView extends VideoView {

    private int width = 0;
    private int height =0;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // must set this at the end
        setMeasuredDimension(width, height);
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }
}