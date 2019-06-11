package com.hillavas.toolbox.viewholder.commonList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;


public class ListsVHFactory implements ViewHolderFactory<ListsVH> {




    @Inject
    ListsVHFactory() {
    }

    @Override
    public ListsVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_2, parent, false);
        return new ListsVH(view, new ListsVM());
    }
}
