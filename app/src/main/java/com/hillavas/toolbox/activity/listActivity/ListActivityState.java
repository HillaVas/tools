package com.hillavas.toolbox.activity.listActivity;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class ListActivityState extends BaseViewState {

    public final List<ItemHomeList> list;

    private  ListActivityState(int status, List<ItemHomeList> hList) {
        super(status);
        this.list = hList;
    }

    public static ListActivityState createSuccessState (List<ItemHomeList> hList){
        return new ListActivityState(STATUS_SUCCESS,hList);
    }


    public static ListActivityState createSuccessState(){
        return  new ListActivityState(STATUS_SUCCESS,null);
    }

    public static ListActivityState createFailedState()
    {
        return new ListActivityState(STATUS_FAILED , null);
    }


}
