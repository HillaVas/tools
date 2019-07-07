package com.hillavas.toolbox.diffcallbacks;

import android.support.v7.util.DiffUtil;

import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.servermodel.ItemContentList;

import javax.inject.Inject;

public class EarthquakeCallback extends DiffUtil.ItemCallback<EarthquakeItem> {

    @Inject
    EarthquakeCallback(){}

    @Override
    public boolean areItemsTheSame(EarthquakeItem oldItem, EarthquakeItem newItem) {
//        return oldItem.id() == newItem.id();
        return false;
    }

    @Override
    public boolean areContentsTheSame(EarthquakeItem oldItem, EarthquakeItem newItem) {
        return false;
    }

//    @Override
//    public boolean areContentsTheSame(ItemHomeList oldItem, ItemHomeList newItem) {
//        return oldItem.totalView().equals(newItem.totalView());
//    }


}
