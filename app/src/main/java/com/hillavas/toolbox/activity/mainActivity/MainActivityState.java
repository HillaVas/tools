package com.hillavas.toolbox.activity.mainActivity;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class MainActivityState extends BaseViewState {

    public final List<ItemHomeList> list;

    private  MainActivityState(int status, List<ItemHomeList> hList) {
        super(status);
        this.list = hList;
    }

    public static MainActivityState createSuccessState (List<ItemHomeList> hList){
        return new MainActivityState(STATUS_SUCCESS,hList);
    }
    public static MainActivityState createSuccessState (){
        return new MainActivityState(STATUS_SUCCESS,null);
    }


    public static MainActivityState createFailedState()
    {
        return new MainActivityState(STATUS_FAILED , null);
    }


}
