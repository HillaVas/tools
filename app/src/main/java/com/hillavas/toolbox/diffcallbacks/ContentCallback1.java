package com.hillavas.toolbox.diffcallbacks;

import android.support.v7.util.DiffUtil;

import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

public class ContentCallback1 extends DiffUtil.ItemCallback<ItemContentList> {

    @Inject
    ContentCallback1(){}

    @Override
    public boolean areItemsTheSame(ItemContentList oldItem, ItemContentList newItem) {
//        return oldItem.id() == newItem.id();
        return false;
    }

    @Override
    public boolean areContentsTheSame(ItemContentList oldItem, ItemContentList newItem) {
        return false;
    }

//    @Override
//    public boolean areContentsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
//        return oldItem.totalView().equals(newItem.totalView());
//    }


}
