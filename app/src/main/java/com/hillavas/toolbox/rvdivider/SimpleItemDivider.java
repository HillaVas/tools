package com.hillavas.toolbox.rvdivider;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

@SuppressWarnings({"WeakerAccess", "unused"})
public class SimpleItemDivider extends RecyclerView.ItemDecoration {

    private final int rightOffset;
    private final int leftOffset;
    private final int topOffset;
    private final int bottomOffset;

    public SimpleItemDivider(int rightOffset, int leftOffset, int topOffset, int bottomOffset) {
        this.rightOffset = rightOffset;
        this.leftOffset = leftOffset;
        this.topOffset = topOffset;
        this.bottomOffset = bottomOffset;
    }

    public SimpleItemDivider(int horizontalOffset, int verticalOffset) {
        this(horizontalOffset, horizontalOffset, verticalOffset, verticalOffset);
    }

    public SimpleItemDivider(int offset) {
        this(offset, offset);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = bottomOffset;
        outRect.left = leftOffset;
        outRect.right = rightOffset;
        outRect.top = topOffset;
    }
}
