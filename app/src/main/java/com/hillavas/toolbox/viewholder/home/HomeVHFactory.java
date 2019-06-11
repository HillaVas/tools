package com.hillavas.toolbox.viewholder.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeVHFactory implements ViewHolderFactory<HomeVH> {



    @BindView(R.id.flexbox_layout)
    FlexboxLayout flexboxLayout;

    @Inject
    HomeVHFactory() {
    }

    @Override
    public HomeVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_1, parent, false);
        return new HomeVH(view, new HomeVM());
    }

    @OnClick(R.id.drawee_row_home_img)
    public void onViewClicked() {
    }
}
