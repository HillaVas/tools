package com.hillavas.toolbox.viewholder.home;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class HomeVM extends BaseVHViewModel<ItemHomeList> {

    String getImage(){
       List<AttachmentsModel> atModel =mObject.Attachments();
        return atModel.get(0).RelativeAddress();}

    boolean getHasChild(){
        return mObject.HasChild();
    }
    int getCategoryId(){
        return mObject.CategoryId();
    }
    String getName(){
        return mObject.Name();
    }


}
