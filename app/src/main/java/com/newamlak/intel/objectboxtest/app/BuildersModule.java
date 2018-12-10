package com.newamlak.intel.objectboxtest.app;

import com.newamlak.intel.objectboxtest.activity.itemList.ItemListActivity;
import com.newamlak.intel.objectboxtest.activity.itemList.ItemListActivityModule;
import com.newamlak.intel.objectboxtest.activity.mainActivity.MainActivity;
import com.newamlak.intel.objectboxtest.activity.mainActivity.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = ItemListActivityModule.class)
    public abstract ItemListActivity bindItemListActivity();
}
