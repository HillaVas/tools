package com.hillavas.toolbox.manager.pref;



@SuppressWarnings("unused")
public interface PrefManager {

    String getUserPass();

    void setUserPass (String adminPass);

    void setIsLogin (boolean bol);

    boolean getIsLogin ();

    void setPhoneNumber(String number);

    String getphoneNumber();
}
