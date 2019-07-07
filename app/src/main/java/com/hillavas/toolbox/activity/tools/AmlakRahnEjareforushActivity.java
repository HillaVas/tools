package com.hillavas.toolbox.activity.tools;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hillavas.toolbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AmlakRahnEjareforushActivity extends AppCompatActivity {

    public static final String rahn = "RAHN_VA_EJARE";
    public static final String kharid = "KHARID_VA_FOLUSH";
    public static final String tabdil = "TABDIL_RAHN_VA_EJARE";
    public static final String CONTENT_TYPE = "Content_Type";
    @BindView(R.id.layout_amlak_row4)
    LinearLayout layoutAmlakRow4;
    @BindView(R.id.txt_amlak_lbl4)
    TextView txtAmlakLbl4;
    private int contentType = 0;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak);
        ButterKnife.bind(this);

        Intent mIntent = getIntent();
        contentType = mIntent.getIntExtra(CONTENT_TYPE, 0);

        if (contentType == 5) {
            initUI(tabdil);
        }else {
            initUI(kharid);
        }

    }

    public void initUI(String serviceName) {

        if (serviceName.equals(kharid)) {

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
            layoutAmlakRow2.setVisibility(View.VISIBLE);
            txtAmlakLbl2.setText("اجاره");
            layoutAmlakRow1.setVisibility(View.GONE);
            layoutAmlakRow4.setVisibility(View.GONE);
            txtAmlakLbl4.setText("تبدیل");

        }

    }

    @OnClick(R.id.img_btn_back)
    public void onImgBtnBackClicked() {
    }

    @OnClick(R.id.linier_amlak_rahn)
    public void onLinierAmlakRahnClicked() {

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


        initUI(kharid);
    }

    @OnClick(R.id.layout_amlak_mohasebe)
    public void onLayoutAmlakMohasebeClicked() {
    }
}
