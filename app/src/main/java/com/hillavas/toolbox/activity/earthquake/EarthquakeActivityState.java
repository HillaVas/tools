package com.hillavas.toolbox.activity.earthquake;

import com.hillavas.toolbox.base.BaseViewState;
import com.hillavas.toolbox.servermodel.EarthquakeItem;

import java.util.List;

public class EarthquakeActivityState extends BaseViewState {

    public final List<EarthquakeItem> list ;

    protected EarthquakeActivityState(int status, List<EarthquakeItem> list) {
        super(status);
        this.list = list;
    }

    public static EarthquakeActivityState createSuccessState (List<EarthquakeItem> hList){
        return new EarthquakeActivityState(STATUS_SUCCESS,hList);
    }


    public static EarthquakeActivityState createFailedState()
    {
        return new EarthquakeActivityState(STATUS_FAILED , null);
    }

}
