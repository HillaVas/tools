package com.hillavas.toolbox.activity.mainActivity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.rvdivider.GridDividerItemDecorationFixed;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    static GridLayoutManager provideGridLayoutManager(MainActivity activity){
        GridLayoutManager layoutManager = new GridLayoutManager(activity, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

//                if (position==0)
//                    return 2;
//                else if (position==1||position==2||position==3)
//                    return 1;
//                else return position%3 == 0 ? 2 : 1;

                  return position%3 == 0 ? 2 : 1;
            }
        });

        return layoutManager;
    }

    @SuppressWarnings("ConstantConditions")
    @Provides
    static GridDividerItemDecorationFixed provideDividerDecoration(MainActivity activity){
        Drawable horizontalDividerDrawable = ContextCompat.getDrawable(activity, R.drawable.rv_divider_trasnparent);
        Drawable verticalDividerDrawable = ContextCompat.getDrawable(activity, R.drawable.rv_grid_vertical_divider_trasnparent);
        return new GridDividerItemDecorationFixed(horizontalDividerDrawable, verticalDividerDrawable, 2);
    }
}
