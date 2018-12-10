package com.newamlak.intel.objectboxtest.base;

import android.support.v7.util.DiffUtil;

import java.util.List;

public abstract class BaseDiffUtilCallBack<T> extends DiffUtil.Callback{
    protected final List<T> oldList;
    protected final List<T> newList;

    protected BaseDiffUtilCallBack(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }
}
