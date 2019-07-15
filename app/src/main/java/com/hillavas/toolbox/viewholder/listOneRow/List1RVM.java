package com.hillavas.toolbox.viewholder.listOneRow;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class List1RVM extends BaseVHViewModel<ItemHomeList> {

//    String getImage(){
//        List<AttachmentsModel> atModel =mObject.Attachments();
//        return atModel.get(0).RelativeAddress();}

    String getImage(String size){
        String size_img ="h/";
        String serverValue = "";
        String output = "";
        List<AttachmentsModel> atModel =mObject.Attachments();
        if (atModel!=null ){
            if (size.equals("")){
                output = atModel.get(0).RelativeAddress();
            }else {
                serverValue = atModel.get(0).RelativeAddress();
                String[] parts = serverValue.split("/");

                size_img =size+"-";

                parts[parts.length-1] = size_img+parts[parts.length-1];


                for (int i=1 ; i<parts.length ; i++ ){
                    output = output+"/"+parts[i];
                }
            }


        }

        return output;

    }

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

    Integer getContentType(){
        return mObject.ContentType();
    }

//    String getImage(){return mObject.Name();}
//    String getName(){return mObject.Name();}


}
