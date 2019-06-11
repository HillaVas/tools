package com.hillavas.toolbox.rvdivider;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BottomOffsetDecoration extends RecyclerView.ItemDecoration {


    private int mBottomOffset;
    private int left;
    private int top;
    private int right;
    private int bottom;

    public BottomOffsetDecoration(int bottomOffset) {
        this.right = 0;
        this.right = 0;
        this.left = 0;
        this.top = 0;
        this.bottom = 0;
        mBottomOffset = bottomOffset;
    }

    public BottomOffsetDecoration(int left, int top, int right, int bottom, int bottomOffset) {
        this.right = right;
        this.left = left;
        this.top = top;
        this.bottom = bottom;
        mBottomOffset = bottomOffset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int dataSize = state.getItemCount();
        int position = parent.getChildAdapterPosition(view);
        if (dataSize > 0 && position == dataSize - 1) {
            outRect.set(left, top, right, mBottomOffset);
        } else {
            outRect.set(left, top, right, bottom);
        }

        if (dataSize > 0 && position == dataSize - 2 && (dataSize % 2) == 1) {
            outRect.set(left, top, right, mBottomOffset);
        }


    }

}
