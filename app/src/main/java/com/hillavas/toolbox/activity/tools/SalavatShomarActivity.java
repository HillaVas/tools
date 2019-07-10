package com.hillavas.toolbox.activity.tools;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hillavas.toolbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SalavatShomarActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME = "MyPrefSalavat";

    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;
    @BindView(R.id.txt_salavat_tedadshomaresh)
    TextView txtSalavatTedadshomaresh;
    @BindView(R.id.edt_salavat_tedadekol)
    AppCompatTextView edtSalavatTedadekol;
    @BindView(R.id.edt_salavat_tedad)
    AppCompatEditText edtSalavatTedad;
    @BindView(R.id.layout_salavat_clear)
    LinearLayout layoutSalavatClear;
    @BindView(R.id.layout_salavat_resetall)
    LinearLayout layoutSalavatResetall;
    @BindView(R.id.layout_salvat_shomaresh)
    LinearLayout layoutSalvatShomaresh;

    int count = 0;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_amlak_row2)
    LinearLayout layoutAmlakRow2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salavat);
        ButterKnife.bind(this);
        hideSoftKeyboard();
        layoutSalvatShomaresh.setFocusable(true);


    }

    @OnClick(R.id.img_btn_back)
    public void onImgBtnBackClicked() {

        count = count + getPref();
        setPref(count);
        finish();
    }

    @OnClick(R.id.layout_salavat_clear)
    public void onLayoutSalavatClearClicked() {
        count = 0;
    }

    @OnClick(R.id.layout_salavat_resetall)
    public void onLayoutSalavatResetallClicked() {

        setPref(0);
    }

    @OnClick(R.id.layout_salvat_shomaresh)
    public void onLayoutSalvatShomareshClicked() {
        count++;
        txtSalavatTedadshomaresh.setText(String.valueOf(count));

    }

    public void setPref(int count) {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        editor.putInt("tedadkol", count);
        editor.apply();
    }

    public int getPref() {
        int salavat = 0;
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {

            salavat = prefs.getInt("tedadkol", 0); //0 is the default value.
        }
        return salavat;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        count = count + getPref();
        setPref(count);
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }




}
