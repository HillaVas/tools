package com.hillavas.toolbox.diffcallbacks;

import android.support.v7.util.DiffUtil;

import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

public class HomeCallback extends DiffUtil.ItemCallback<ItemHomeList> {

    @Inject
    HomeCallback(){}

    @Override
    public boolean areItemsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
//        return oldItem.id() == newItem.id();
        return false;
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
