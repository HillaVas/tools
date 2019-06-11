package com.hillavas.toolbox.viewholder.listTwoRowOne;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

public class List2RVM extends BaseVHViewModel<ItemHomeList> {

    String getImage(){return mObject.Name();}
    String getName(){return mObject.Name();}


}
