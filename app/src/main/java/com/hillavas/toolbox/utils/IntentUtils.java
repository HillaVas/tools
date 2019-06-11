package com.hillavas.toolbox.utils;


import android.content.Context;
import android.content.Intent;

import com.hillavas.toolbox.activity.listActivity.ListActivity;
import com.hillavas.toolbox.activity.webView.WebViewActivity;

public class IntentUtils {

public static void openWeb(Context context , String url ){

    Intent intent = new Intent(context, WebViewActivity.class);
    intent.putExtra(WebViewActivity.WEB_UTL,url);
    context.startActivity(intent);
}

public static void  openListL2 (Context context ,String name ,int row ,int CategoryId){

    Intent intent = new Intent(context , ListActivity.class);
    intent.putExtra(ListActivity.NAME_LEVEL_ONE,name);
    intent.putExtra(ListActivity.NUMBER_OF_ROW_LIST,row);
    intent.putExtra(ListActivity.CATEGGORY_ID,CategoryId);

    context.startActivity(intent);


}






}
