package com.hillavas.toolbox.base;

public class BaseVHViewModel<T> {

    protected T mObject;

    public T getObject() {
        return mObject;
    }

    public void setObject(T object) {
        mObject = object;
    }
}
