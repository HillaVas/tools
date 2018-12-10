package com.newamlak.intel.objectboxtest.base;

public class BaseViewHolderAction {

    private final int mAdapterPosition;

    public BaseViewHolderAction(int adapterPosition) {
        mAdapterPosition = adapterPosition;
    }

    public int getAdapterPosition() {
        return mAdapterPosition;
    }

    @Override
    public String toString() {
        return "BaseViewHolderAction{" +
                "mAdapterPosition=" + mAdapterPosition +
                '}';
    }
}
