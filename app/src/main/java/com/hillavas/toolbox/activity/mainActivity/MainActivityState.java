package com.hillavas.toolbox.activity.mainActivity;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;

import java.util.List;

public class MainActivityState extends BaseViewState {

    public final List<ItemHomeList> list;

    public final SettingModel settingModel;

    private  MainActivityState(int status, List<ItemHomeList> hList ,SettingModel settingModel) {
        super(status);
        this.list = hList;
        this.settingModel = settingModel;
    }

    public static MainActivityState createSuccessState (List<ItemHomeList> hList){
        return new MainActivityState(STATUS_SUCCESS,hList,null);
    }
    public static MainActivityState createSuccessState (){
        return new MainActivityState(STATUS_SUCCESS,null,null);
    }
    public static MainActivityState createSuccessSettingState (SettingModel settingModel){
        return new MainActivityState(STATUS_SUCCESS,null,settingModel);
    }


    public static MainActivityState createFailedState()
    {
        return new MainActivityState(STATUS_FAILED , null,null);
    }


}
