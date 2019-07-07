package com.hillavas.toolbox.activity.content;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.ItemContentList;

import java.util.List;

public class ContentTipActivityState extends BaseViewState {

    public final List<ItemContentList> list;

    protected ContentTipActivityState(int status, List<ItemContentList> items) {
        super(status);
        this.list = items;
    }

    public static ContentTipActivityState createSuccessState (List<ItemContentList> iList){
        return new ContentTipActivityState(STATUS_SUCCESS,iList);
    }
    public static ContentTipActivityState createSuccessState (){
        return new ContentTipActivityState(STATUS_SUCCESS,null);
    }


    public static ContentTipActivityState createFailedState()
    {
        return new ContentTipActivityState(STATUS_FAILED , null);
    }
}
