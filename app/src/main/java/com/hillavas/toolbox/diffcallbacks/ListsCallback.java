package com.hillavas.toolbox.diffcallbacks;

import android.support.v7.util.DiffUtil;

import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

public class ListsCallback extends DiffUtil.ItemCallback<ItemHomeList> {

    @Inject
    ListsCallback(){}

    @Override
    public boolean areItemsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
        return oldItem.Name() == newItem.Name();
    }

    @Override
    public boolean areContentsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
        return false;
    }

//    @Override
//    public boolean areContentsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
//        return oldItem.totalView().equals(newItem.totalView());
//    }


}
