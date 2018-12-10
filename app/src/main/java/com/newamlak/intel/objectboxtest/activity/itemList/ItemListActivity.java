package com.newamlak.intel.objectboxtest.activity.itemList;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.newamlak.intel.objectboxtest.R;
import com.newamlak.intel.objectboxtest.base.BaseDaggerCompatActivity;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ItemListActivity extends BaseDaggerCompatActivity<ItemListActivityState,ItemListActivityViewModel> {


    @Inject
    CompositeDisposable mDisposable;

    @Inject
    CompositeDisposable mCompositeDisposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_list);
        createViewModel(ItemListActivityViewModel.class);
    }

    @Override
    public void handleState(ItemListActivityState state) {

    }
}
