package com.hillavas.toolbox.viewholder.listOneRow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;
import com.hillavas.toolbox.viewholder.commonList.ListsVH;
import com.hillavas.toolbox.viewholder.commonList.ListsVM;

import javax.inject.Inject;

import butterknife.OnClick;


public class List1RVHFactory implements ViewHolderFactory<List1RVH> {




    @Inject
    List1RVHFactory() {
    }

    @Override
    public List1RVH create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_title2, parent, false);
        return new List1RVH(view, new List1RVM());
    }

    @OnClick(R.id.drawee_row_home_img)
    public void onViewClicked() {
    }
}
