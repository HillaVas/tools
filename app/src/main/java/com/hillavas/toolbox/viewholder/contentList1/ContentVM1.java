package com.hillavas.toolbox.viewholder.contentList1;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.AttachmentsModel;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

public class ContentVM1 extends BaseVHViewModel<ItemContentList> {

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

//    boolean getHasChild(){
//        return mObject.HasChild();
//    }
//    int getCategoryId(){
//        return mObject.CategoryId();
//    }

    String getTitle(){
        return mObject.Title();
    }
    String getTxt(){
        return mObject.Desc();
    }
    String getTxtItemContentlikecount(){return String.valueOf(mObject.LikeCount());}
    String getTxtItemContentViewCount(){return String.valueOf(mObject.ViewCount());}
//    boolean getShowName(){return mObject.ShowName();}


}
