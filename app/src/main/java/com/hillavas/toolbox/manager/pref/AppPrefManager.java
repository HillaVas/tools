package com.hillavas.toolbox.manager.pref;

import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Inject;

public final class AppPrefManager implements PrefManager {

    @Inject
    RxSharedPreferences mRxPref;

    @Inject
    AppPrefManager() {
    }

    @Override
    public String getUserPass() {
        return mRxPref.getString("user_pass").get();
    }

    @Override
    public void setUserPass(String adminPass) {
        mRxPref.getString("user_pass").set(adminPass);
        setIsLogin(true);
    }

    @Override
    public void setIsLogin(boolean bol) {
        mRxPref.getBoolean("is_login").set(true);
    }

    @Override
    public boolean getIsLogin() {
        return mRxPref.getBoolean("is_login").get();
    }

    @Override
    public void setPhoneNumber(String number) {
        mRxPref.getString("phone_number").set(number);
    }

    @Override
    public String getphoneNumber() {
        return mRxPref.getString("phone_number").get();
    }
}
