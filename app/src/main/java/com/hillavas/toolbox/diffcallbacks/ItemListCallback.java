package com.hillavas.toolbox.diffcallbacks;

import android.support.v7.util.DiffUtil;


import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

public class ItemListCallback extends DiffUtil.ItemCallback<ItemHomeList> {

    @Inject
    ItemListCallback() {
    }

    @Override
    public boolean areItemsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
        return true;
//        return oldItem.getId() == newItem.getId();

    }

    @Override
    public boolean areContentsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
//        return oldItem.totalView() == newItem.totalView();
        return  true;
    }
}
