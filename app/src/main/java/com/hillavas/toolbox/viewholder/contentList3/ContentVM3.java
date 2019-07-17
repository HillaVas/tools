package com.hillavas.toolbox.viewholder.contentList3;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemContentList;

import java.util.List;

public class ContentVM3 extends BaseVHViewModel<ItemContentList>{

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
    String getTitle(){return mObject.Title();}
}
