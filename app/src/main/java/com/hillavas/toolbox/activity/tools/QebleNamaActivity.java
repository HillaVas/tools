package com.hillavas.toolbox.activity.tools;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.servermodel.SettingModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class QebleNamaActivity extends AppCompatActivity implements SensorEventListener {

    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordin_qiblah)
    CoordinatorLayout coordinQiblah;
    // define the display assembly compass picture
    private ImageView image;
    private ImageView imageKabe;
    SettingModel setting;

    // record the compass picture angle turned
    private float currentDegree = 0f;
    private float currentDegreeKabe = 0f;

    // device sensor manager
    private SensorManager mSensorManager;

    TextView tvHeading;
    TextView txtgoneQible;
    TextView txtQible;
    Point n;
    //    Point target = new Point(21.4225,39.8262) ;
    float angle;
    boolean isQeble = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qeble_nama);
        ButterKnife.bind(this);

        n = new Point(0, 0);

        // our compass image
        image = (ImageView) findViewById(R.id.imageViewCompass);
        imageKabe = (ImageView) findViewById(R.id.imageViewCompassKabe);

        // TextView that will tell the user what degree is he heading
        tvHeading = (TextView) findViewById(R.id.tvHeading);
        txtgoneQible = (TextView) findViewById(R.id.txtgoneQible);
        txtQible = (TextView) findViewById(R.id.txtQebleh);

        // initialize your android device sensor capabilities
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        if (mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER) == null) {
            txtgoneQible.setVisibility(View.VISIBLE);
        }

        getPref();
        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        coordinQiblah.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        // get the angle around the z-axis rotated
        float degree = Math.round(event.values[0]);

        tvHeading.setText("Heading: " + Float.toString(degree) + " degrees");


        // create a rotation animation (reverse turn degree degrees)
        RotateAnimation ra = new RotateAnimation(
                currentDegree,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        RotateAnimation kabe = new RotateAnimation(
                currentDegreeKabe,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);


        // how long the animation will take place
        ra.setDuration(210);
        kabe.setDuration(210);

        // set the animation after the end of the reservation status
        ra.setFillAfter(true);
        kabe.setFillAfter(true);

        angle = (float) Math.toDegrees(Math.atan2(39.8262 - 514200, 21.4225 - 35.8127));

//        if(angle < 0){
//            angle += 360;
//        }

        // Start the animation
        image.startAnimation(ra);
        imageKabe.startAnimation(kabe);

        currentDegreeKabe = angle - degree;

        if (currentDegreeKabe < 0)
            currentDegreeKabe += 360;


        currentDegree = -degree;
//        if (0.0<degree && degree<10.0 ||350.0<degree && degree<360.0 ){
//
//        isQeble = true;
//            txtQible.setVisibility(View.VISIBLE);
//            imageKabe.setVisibility(View.VISIBLE);
//
//        }
//        else {
//            isQeble = false;
//            txtQible.setVisibility(View.GONE);
//            imageKabe.setVisibility(View.GONE);
//        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not in use
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
    }
}
