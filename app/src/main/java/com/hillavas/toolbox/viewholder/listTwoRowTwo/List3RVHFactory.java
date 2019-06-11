package com.hillavas.toolbox.viewholder.listTwoRowTwo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;


public class List3RVHFactory implements ViewHolderFactory<List3RVH> {


    @Inject
    List3RVHFactory() {
    }

    @Override
    public List3RVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_22, parent, false);
        return new List3RVH(view, new List3RVM());
    }
}
