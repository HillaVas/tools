package com.hillavas.toolbox.activity.tools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.servermodel.SettingModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class AmlakRahnEjareforushActivity extends AppCompatActivity {

    public static final String rahn = "RAHN_VA_EJARE";
    public static final String kharid = "KHARID_VA_FOLUSH";
    public static final String tabdil = "TABDIL_RAHN_VA_EJARE";
    public static final String CONTENT_TYPE = "Content_Type";
    public static String state = "";
    double valueResult;
    double arzeshAfzude;

    private int contentType = 0;
    SettingModel setting;

    @BindView(R.id.layout_amlak_row4)
    LinearLayout layoutAmlakRow4;
    @BindView(R.id.txt_amlak_lbl4)
    TextView txtAmlakLbl4;
    @BindView(R.id.txt_amlak_hasel)
    TextView txtAmlakHasel;
    @BindView(R.id.layout_amlak_row1)
    LinearLayout layoutAmlakRow1;
    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;
    @BindView(R.id.linier_amlak_rahn)
    LinearLayout linierAmlakRahn;
    @BindView(R.id.linier_amlak_kharid)
    LinearLayout linierAmlakKharid;
    @BindView(R.id.txt_amlak_lbl1)
    TextView txtAmlakLbl1;
    @BindView(R.id.edt_amlak_row1)
    AppCompatEditText edtAmlakRow1;
    @BindView(R.id.layout_amlak_row2)
    LinearLayout layoutAmlakRow2;
    @BindView(R.id.txt_amlak_lbl2)
    TextView txtAmlakLbl2;
    @BindView(R.id.edt_amlak_row2)
    AppCompatEditText edtAmlakRow2;
    @BindView(R.id.txt_amlak_lbl3)
    TextView txtAmlakLbl3;
    @BindView(R.id.edt_search)
    AppCompatEditText edtSearch;
    @BindView(R.id.layout_amlak_mohasebe)
    LinearLayout layoutAmlakMohasebe;
    @BindView(R.id.layout_amlak_hasel)
    LinearLayout layoutAmlakHasel;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordin_amlak)
    CoordinatorLayout coordinAmlak;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        contentType = mIntent.getIntExtra(CONTENT_TYPE, 0);

        if (contentType == 5) {
            initUI(tabdil);
        } else {
            initUI(kharid);
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getPref();
        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        coordinAmlak.setBackgroundColor(Color.parseColor(setting.AppMainColor()));

    }

    public void initUI(String serviceName) {

        if (serviceName.equals(kharid)) {
            state = kharid;

            layoutAmlakRow2.setVisibility(View.GONE);
            txtAmlakLbl2.setText("مبلغ");

            final int sdk = Build.VERSION.SDK_INT;
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                linierAmlakRahn.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
                linierAmlakKharid.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
            } else {
                linierAmlakRahn.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
                linierAmlakKharid.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
            }

        } else if (serviceName.equals(rahn)) {

            state = rahn;

            final int sdk = Build.VERSION.SDK_INT;
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                linierAmlakRahn.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
                linierAmlakKharid.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
            } else {
                linierAmlakRahn.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
                linierAmlakKharid.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
            }


            layoutAmlakRow2.setVisibility(View.VISIBLE);
            txtAmlakLbl2.setText("اجاره");
        } else if (serviceName.equals(tabdil)) {

            state = tabdil;
            layoutAmlakRow2.setVisibility(View.VISIBLE);
            txtAmlakLbl2.setText("اجاره");
            layoutAmlakRow1.setVisibility(View.GONE);
            layoutAmlakRow4.setVisibility(View.GONE);
            txtAmlakLbl4.setText("تبدیل");

        }

    }


    private void kharidCount(String darsad, String mablagh) {
        Double _darsad = Double.valueOf(darsad);
        Double _mablagh = Double.valueOf(mablagh);

        valueResult = 0;
        if (_mablagh > 500000000) {

            valueResult = 500000 * 5;
            valueResult = valueResult + (_mablagh - 500000000) * (_darsad / 2000);

        } else {
            valueResult = _mablagh * 5 / 1000;
        }

        arzeshAfzude = valueResult * 9 / 100;

    }

    private void rahnCount(String rahn, String ejare, String darsad) {
        valueResult = 0;
        double _rahn = Double.valueOf(rahn);
        double _ejare = Double.valueOf(ejare);
        double _darsad = Double.valueOf(darsad);

        valueResult = _ejare * _darsad / 100;
        valueResult = valueResult + (_rahn * (_darsad / 33.3333) / 100);
        arzeshAfzude = valueResult * 9 / 100;
    }

    private void tabdilCount(String rahn, String ejare) {
        double _rahn;
        double _ejare;
        valueResult = 0;
        if (!rahn.equals("")) {
            _rahn = Double.valueOf(rahn);
            valueResult = _rahn / 100 * 3;
            edtAmlakRow2.setText("");
        } else {
            _ejare = Double.valueOf(ejare);
            valueResult = _ejare * 100 / 3;
            edtAmlakRow1.setText("");

        }

    }

    public void setDefaultEdits() {
        edtSearch.setText("");
        edtAmlakRow1.setText("");
        edtAmlakRow2.setText("");
        txtAmlakHasel.setText("");
    }

    public SettingModel getPref() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String bgColor = prefs.getString("AppBgColor", null);
        String mainColor = prefs.getString("AppMainColor", null);
        setting = SettingModel.createSetting(bgColor, mainColor, false, null, null, null);
        return setting;
    }

    @OnClick(R.id.img_btn_back)
    public void onImgBtnBackClicked() {
        finish();
    }

    @OnClick(R.id.linier_amlak_rahn)
    public void onLinierAmlakRahnClicked() {

        setDefaultEdits();

        final int sdk = Build.VERSION.SDK_INT;
        if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
            linierAmlakRahn.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
            linierAmlakKharid.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
        } else {
            linierAmlakRahn.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_grey));
            linierAmlakKharid.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_edittext_dark));
        }


        initUI(rahn);
    }

    @OnClick(R.id.linier_amlak_kharid)
    public void onLinierAmlakKharidClicked() {

        setDefaultEdits();
        initUI(kharid);
    }

    @OnClick(R.id.layout_amlak_mohasebe)
    public void onLayoutAmlakMohasebeClicked() {


        if (state == kharid) {
            kharidCount(edtSearch.getText().toString(), edtAmlakRow2.getText().toString());
            txtAmlakHasel.setText(String.valueOf(valueResult) + "  " + String.valueOf(arzeshAfzude) + "  " + "ارزش افزوده");
        } else if (state == rahn) {
            rahnCount(edtAmlakRow1.getText().toString(), edtAmlakRow2.getText().toString(), edtSearch.getText().toString());
            txtAmlakHasel.setText(String.valueOf(valueResult) + "  " + String.valueOf(arzeshAfzude) + "  " + "ارزش افزوده");
        } else if (state == tabdil) {
            tabdilCount(edtAmlakRow1.getText().toString(), edtAmlakRow2.getText().toString());
            txtAmlakHasel.setText(String.valueOf(valueResult));
        }


    }


}
