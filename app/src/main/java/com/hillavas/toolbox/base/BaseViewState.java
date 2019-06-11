package com.hillavas.toolbox.base;

public abstract class BaseViewState {
    public static final int STATUS_SUCCESS = 1001;
    public static final int STATUS_FAILED = 1002;


    public final int status;

    protected BaseViewState(int status) {
        this.status = status;
    }
}
