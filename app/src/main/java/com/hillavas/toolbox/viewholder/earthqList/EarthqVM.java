package com.hillavas.toolbox.viewholder.earthqList;

import com.hillavas.toolbox.base.BaseVHViewModel;
import com.hillavas.toolbox.servermodel.EarthquakeItem;

public class EarthqVM extends BaseVHViewModel<EarthquakeItem> {

    String getRegion(){return  mObject.Region()+"بزرگی زلزله : " + mObject.Measure()+ "ریشتر"  ;}

    String getDepth(){return " در عمق "+mObject.Depth()+"  کیلومتری ";}

    String getDateTime(){return mObject.DateTime();}


}
