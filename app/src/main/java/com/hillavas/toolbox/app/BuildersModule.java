package com.hillavas.toolbox.app;

import com.hillavas.toolbox.activity.content.ContentTipActivity;
import com.hillavas.toolbox.activity.content.ContentTipActivityModule;
import com.hillavas.toolbox.activity.listActivity.ListActivity;
import com.hillavas.toolbox.activity.listActivity.ListActivityModule;
import com.hillavas.toolbox.activity.mainActivity.MainActivity;
import com.hillavas.toolbox.activity.mainActivity.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = ListActivityModule.class)
    public abstract ListActivity bindListActivity();

    @ContributesAndroidInjector(modules = ContentTipActivityModule.class)
    public abstract ContentTipActivity bindContentTipActivity();


}
