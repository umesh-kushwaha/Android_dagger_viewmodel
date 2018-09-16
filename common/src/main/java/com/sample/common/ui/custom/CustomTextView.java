package com.sample.common.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

public class CustomTextView extends AppCompatTextView {

    private int mWidth;
    private int mHeight;
    private int color;

    public CustomTextView(Context context, AttributeSet attrs)  {
        super(context, attrs);
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, outValue, true);
    }

    @Override
    public void setBackgroundColor(int color) {
        this.color = color;
       // super.setBackgroundColor(color);
    }



    @Override
    protected void onDraw(Canvas canvas) {

        Paint mPaint = new Paint();
        mPaint.setColor(color);
        Path mPath = new Path();
        mPath.moveTo(.0f, this.getHeight());
        mPath.lineTo(0.8f * this.getWidth(), this.getHeight());
        mPath.lineTo(this.getWidth(), 0.5f * this.getHeight());
        mPath.lineTo(0.8f * this.getWidth(), .0f);
        mPath.lineTo(.0f, .0f);
        mPath.lineTo(.0f, this.getHeight());
        canvas.clipPath(mPath);
        canvas.drawPath(mPath,mPaint);
        super.onDraw(canvas);

    }
}
