package com.newamlak.intel.objectboxtest.activity.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.newamlak.intel.objectboxtest.R;
import com.newamlak.intel.objectboxtest.activity.itemList.ItemListActivity;
import com.newamlak.intel.objectboxtest.base.BaseDaggerCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseDaggerCompatActivity<MainActivityState, MainActivityViewModel> {


    @Inject
    CompositeDisposable mDisposable;

    @Inject
    CompositeDisposable mCompositeDisposable;
    @BindView(R.id.main_item_a_e_cover)
    SimpleDraweeView mainItemAECover;
    @BindView(R.id.main_item_a_e_name)
    AppCompatTextView mainItemAEName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        createViewModel(MainActivityViewModel.class);
        ButterKnife.bind(this);

    }

    @Override
    public void handleState(MainActivityState state) {

    }

    @OnClick(R.id.main_item_a_e_cover)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
        startActivity(intent);
    }
}
