package com.hillavas.toolbox.viewholder.commonList;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class ListsVM extends BaseVHViewModel<ItemHomeList> {

    String getImage(){
        List<AttachmentsModel> atModel =mObject.Attachments();
        return atModel.get(0).RelativeAddress();}

    boolean getHasChild(){
        return mObject.HasChild();
    }

    String getName(){return mObject.Name();}
    int getCategoryId(){
        return mObject.CategoryId();
    }

    int getAttachmentType(){
        List<AttachmentsModel> atModel =mObject.Attachments();
        return atModel.get(0).AttachmentType();
    }

    boolean getShowName(){return mObject.ShowName();}

    int getContentType (){return mObject.ContentType();}


//    String getImage(){return mObject.Name();}
//    String getName(){return mObject.Name();}


}
