package com.hillavas.toolbox.activity.splash;

import com.hillavas.toolbox.activity.mainActivity.MainActivityState;
import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.SettingModel;

public class SplashActivityState extends BaseViewState {

    public final SettingModel settingModel;

    protected SplashActivityState(int status,SettingModel settingModel) {
        super(status);
        this.settingModel = settingModel;
    }

    public static SplashActivityState createSuccessState (SettingModel settingModel){
        return new SplashActivityState(STATUS_SUCCESS,settingModel);
    }


    public static SplashActivityState createFailedState()
    {
        return new SplashActivityState(STATUS_FAILED ,null);
    }
}
