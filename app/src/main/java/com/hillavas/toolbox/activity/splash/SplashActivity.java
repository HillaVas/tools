package com.hillavas.toolbox.activity.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.activity.mainActivity.MainActivity;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.servermodel.SettingModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class SplashActivity extends BaseDaggerCompatActivity<SplashActivityState, SplashActivityViewModel> {


    SettingModel setting;


    @Inject
    CompositeDisposable mDisposable;

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        createViewModel(SplashActivityViewModel.class);
        startObserving();
        mViewModel.getSetting();

    }

    @Override
    public void handleState(SplashActivityState state) {

        if (state.status == SplashActivityState.STATUS_SUCCESS){
            setting = state.settingModel;
            setPref(setting.AppBgColor(),setting.AppMainColor());
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra("BG_COLOR",setting.AppBgColor());
            intent.putExtra("MAIN_COLOR",setting.AppMainColor());
            startActivity(intent);
        }
    }


    public void setPref(String bgColor,String mainColor) {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("AppBgColor",bgColor);
        editor.putString("AppMainColor",mainColor);
        editor.apply();
    }
}
