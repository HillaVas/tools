package com.hillavas.toolbox.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;

public class DynamicImageView extends AppCompatImageView {

    private  double mWidthRatio;

    public DynamicImageView(Context context) {
        super(context);
    }

    @Override
    protected  void  onMeasure(int widthMeasureSpec, int heightMeasureSpec ){
        if (mWidthRatio>0.0)
        {
            int height= MeasureSpec.getSize(heightMeasureSpec);
            int width = (int) (height * mWidthRatio);
            setMeasuredDimension(width, height);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
