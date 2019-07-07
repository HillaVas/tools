package com.hillavas.toolbox.viewholder.earthqList;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.EarthquakeItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class EarthqVH  extends BaseViewHolder<EarthqVHAction, EarthquakeItem,EarthqVM> {

    @BindView(R.id.txt_row_earth_Region)
    TextView txtRowEarthRegion;
    @BindView(R.id.txt_row_earth_Depth)
    TextView txtRowEarthDepth;
    @BindView(R.id.txt_row_earth_DateTime)
    TextView txtRowEarthDateTime;
    @BindView(R.id.drawee_row_item_earth_img)
    SimpleDraweeView draweeRowItemEarthImg;

    DisplayMetrics displayMetrics = new DisplayMetrics();

    public EarthqVH(View itemView, EarthqVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());


        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
    }


    @SuppressLint("WrongConstant")
    @Override
    public void bind() {
        txtRowEarthRegion.setText(mVM.getRegion());
        txtRowEarthDepth.setText(mVM.getDepth());
        txtRowEarthDateTime.setText(mVM.getDateTime());
        draweeRowItemEarthImg.setImageResource(R.drawable.bg_row_earthquake);

    }

    @Override
    public void itemOnClick(PublishSubject<EarthqVHAction> actionSubject) {

    }
}
