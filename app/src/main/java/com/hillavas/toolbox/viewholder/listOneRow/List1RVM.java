package com.hillavas.toolbox.viewholder.listOneRow;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class List1RVM extends BaseVHViewModel<ItemHomeList> {

    String getImage(){
        List<AttachmentsModel> atModel =mObject.Attachments();
        return atModel.get(0).RelativeAddress();}


//    String getImage(){return mObject.Name();}
//    String getName(){return mObject.Name();}


}
