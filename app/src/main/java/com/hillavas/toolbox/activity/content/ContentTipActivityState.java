package com.hillavas.toolbox.activity.content;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.LikeModel;

import java.util.List;

public class ContentTipActivityState extends BaseViewState {

    public final List<ItemContentList> list;
    public final LikeModel likeModel;

    protected ContentTipActivityState(int status, List<ItemContentList> items, LikeModel likeModel) {
        super(status);
        this.list = items;
        this.likeModel = likeModel;
    }

    public static ContentTipActivityState createSuccessState (List<ItemContentList> iList){
        return new ContentTipActivityState(STATUS_SUCCESS,iList,null);
    }
    public static ContentTipActivityState createSuccessState (){
        return new ContentTipActivityState(STATUS_SUCCESS,null,null);
    }


    public static ContentTipActivityState createFailedState()
    {
        return new ContentTipActivityState(STATUS_FAILED , null,null);
    }

    public static ContentTipActivityState createSuccessState (LikeModel likeModel){
        return new ContentTipActivityState(STATUS_SUCCESS,null,likeModel);
    }
}
