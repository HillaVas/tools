package com.newamlak.intel.objectboxtest.base;

import android.view.ViewGroup;

public interface ViewHolderFactory<V extends BaseViewHolder> {
    V create(ViewGroup parent);
}
