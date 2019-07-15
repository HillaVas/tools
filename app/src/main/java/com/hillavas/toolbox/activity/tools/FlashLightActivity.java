package com.hillavas.toolbox.activity.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.servermodel.SettingModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class FlashLightActivity extends AppCompatActivity {

    SettingModel setting;

    @BindView(R.id.buttonEnable)
    ImageButton buttonEnable;
    @BindView(R.id.flashlight_layout)
    RelativeLayout flashlightLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordin_flashlight)
    CoordinatorLayout coordinFlashlight;
    private boolean flashLightStatus = false;

    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        ButterKnife.bind(this);
        buttonEnable.setBackgroundResource(R.drawable.btn_flashlight_on);


        getPref();
        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        coordinFlashlight.setBackgroundColor(Color.parseColor(setting.AppMainColor()));

    }

    public SettingModel getPref() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String bgColor = prefs.getString("AppBgColor", null);
        String mainColor = prefs.getString("AppMainColor", null);
        setting = SettingModel.createSetting(bgColor, mainColor, false, null, null, null);
        return setting;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flashLightStatus = true;
//            imageFlashlight.setImageResource(R.drawable.btn_switch_on);
        } catch (CameraAccessException e) {
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flashLightStatus = false;
//            imageFlashlight.setImageResource(R.drawable.btn_switch_off);
        } catch (CameraAccessException e) {
        }
    }


    @OnClick(R.id.img_btn_back)
    public void onImgBtnBackClicked() {
        finish();
    }


    @OnClick(R.id.buttonEnable)
    public void onViewClicked() {

        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            if (!flashLightStatus) {
                flashLightOn();
                flashlightLayout.setBackgroundResource(R.drawable.bg_flashlight_on);
                buttonEnable.setBackgroundResource(R.drawable.btn_flashlight_on);

            } else {
                flashLightOff();
                flashlightLayout.setBackgroundResource(R.drawable.bg_flashlight_off);
                buttonEnable.setBackgroundResource(R.drawable.btn_flashlight_off);
            }
        }


    }
}
