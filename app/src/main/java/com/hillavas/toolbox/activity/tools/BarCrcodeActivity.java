package com.hillavas.toolbox.activity.tools;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.servermodel.SettingModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class BarCrcodeActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_PERMISSIONS = 6;
    public static TextView tvresult;

    SettingModel setting;

    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordin_barcode)
    CoordinatorLayout coordinBarcode;
    private Button btn;
    private AppCompatImageButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_reader);
        ButterKnife.bind(this);
        if (!hasRequiredPermissions())
            requestRequiredPermissions();

        tvresult = (TextView) findViewById(R.id.tvresult);

        btn = (Button) findViewById(R.id.btn);
        btnBack = (AppCompatImageButton) findViewById(R.id.img_btn_back);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarCrcodeActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getPref();
        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        coordinBarcode.setBackgroundColor(Color.parseColor(setting.AppMainColor()));

    }

    private void requestRequiredPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA,

        }, REQUEST_CODE_PERMISSIONS);
    }

    private boolean hasRequiredPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSIONS:
                if (hasRequiredPermissions()) {

                } else {
                    Toast.makeText(this, "Permission Error", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }

    public SettingModel getPref() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String bgColor = prefs.getString("AppBgColor", null);
        String mainColor = prefs.getString("AppMainColor", null);
        setting = SettingModel.createSetting(bgColor, mainColor, false, null, null, null);
        return setting;
    }

    @OnClick(R.id.img_btn_back)
    public void onViewClicked() {
        finish();
    }
}
