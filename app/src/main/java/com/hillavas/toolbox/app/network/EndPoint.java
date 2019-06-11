package com.hillavas.toolbox.app.network;


import com.hillavas.toolbox.BuildConfig;

public class EndPoint {

    public static String BASE_URL_TOOLBOX = "http://79.175.138.89:8088/";//http://api.ethplorer.io/
//    public static String BASE_URL_TOOLBOX = "http://79.175.138.95:1010";//http://api.ethplorer.io/
//    public static String BASE_URL_TOOLBOX = "http://192.168.101.69:8181";//http://api.ethplorer.io/

    public static String getDomain(){
        return BASE_URL_TOOLBOX;
    }

}
