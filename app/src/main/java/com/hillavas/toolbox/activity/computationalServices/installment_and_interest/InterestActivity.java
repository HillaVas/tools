package com.hillavas.toolbox.activity.computationalServices.installment_and_interest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hillavas.toolbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterestActivity extends AppCompatActivity {

    @BindView(R.id.interest_layoutinstallment)
    LinearLayout interestLayoutinstallment;
    @BindView(R.id.interest_layoutinterest)
    LinearLayout interestLayoutinterest;
    @BindView(R.id.interest_txtView1)
    TextView interestTxtView1;
    @BindView(R.id.interest_editView1)
    AppCompatEditText interestEditView1;
    @BindView(R.id.interest_txtView2)
    TextView interestTxtView2;
    @BindView(R.id.interest_editView2)
    AppCompatEditText interestEditView2;
    @BindView(R.id.interest_txtView3)
    TextView interestTxtView3;
    @BindView(R.id.interest_editView3)
    AppCompatEditText interestEditView3;
    @BindView(R.id.interest_butoon)
    Button interestButoon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_installment_and_interest_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.interest_layoutinstallment)
    public void onInterestLayoutinstallmentClicked() {
    }

    @OnClick(R.id.interest_layoutinterest)
    public void onInterestLayoutinterestClicked() {
    }

    @OnClick(R.id.interest_butoon)
    public void onInterestButoonClicked() {
    }
}
