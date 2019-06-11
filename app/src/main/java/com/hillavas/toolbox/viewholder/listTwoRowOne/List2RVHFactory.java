package com.hillavas.toolbox.viewholder.listTwoRowOne;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;


public class List2RVHFactory implements ViewHolderFactory<List2RVH> {



    @Inject
    List2RVHFactory() {
    }

    @Override
    public List2RVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_21, parent, false);
        return new List2RVH(view, new List2RVM());
    }
}
