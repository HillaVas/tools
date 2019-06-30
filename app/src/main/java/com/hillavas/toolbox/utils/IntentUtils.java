package com.hillavas.toolbox.utils;


import android.content.Context;
import android.content.Intent;

import com.hillavas.toolbox.activity.content.ContentTipActivity;
import com.hillavas.toolbox.activity.listActivity.ListActivity;
import com.hillavas.toolbox.activity.tools.AmlakRahnEjareforushActivity;
import com.hillavas.toolbox.activity.tools.QebleNamaActivity;
import com.hillavas.toolbox.activity.webView.WebViewActivity;

public class IntentUtils {

public static void openWeb(Context context , String url ){

    Intent intent = new Intent(context, WebViewActivity.class);
    intent.putExtra(WebViewActivity.WEB_UTL,url);
    context.startActivity(intent);
}

public static void  openListL2 (Context context ,String name ,int row ,int CategoryId,double AttachmentType){

    Intent intent = new Intent(context , ListActivity.class);
    intent.putExtra(ListActivity.NAME_LEVEL_ONE,name);
    intent.putExtra(ListActivity.NUMBER_OF_ROW_LIST,row);
    intent.putExtra(ListActivity.CATEGGORY_ID,CategoryId);
    intent.putExtra(ListActivity.ATTACHMENT_TYPE,AttachmentType);


    context.startActivity(intent);


}


public static void openContentTip(Context context,int CategoryId,int content){

    Intent intent = new Intent(context , ContentTipActivity.class );

    intent.putExtra(ContentTipActivity.CATEGGORY_ID_CONTENTTIP,CategoryId);
    intent.putExtra(ContentTipActivity.CONTENT_TYPE,content);
    context.startActivity(intent);



}


public static void  openQebleNAma(Context context){
    Intent intent = new Intent(context, QebleNamaActivity.class);
    context.startActivity(intent);
}


public static void  openAmlakRahnForush(Context context){
    Intent intent = new Intent(context, AmlakRahnEjareforushActivity.class);
    context.startActivity(intent);
}




}
