package com.hillavas.toolbox.viewholder.earthqList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class EarthqVHFactory implements ViewHolderFactory<EarthqVH> {




    @Inject
    EarthqVHFactory() {
    }

    @Override
    public EarthqVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_earthquake, parent, false);
        return new EarthqVH(view, new EarthqVM());
    }
}
