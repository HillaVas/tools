package com.hillavas.toolbox.app.viewmodel;


import android.arch.lifecycle.ViewModel;


import com.hillavas.toolbox.activity.content.ContentTipActivityViewModel;
import com.hillavas.toolbox.activity.earthquake.EarthquakeActivityViewModel;
import com.hillavas.toolbox.activity.listActivity.ListActivityViewModel;
import com.hillavas.toolbox.activity.mainActivity.MainActivityViewModel;
import com.hillavas.toolbox.activity.mainActivity.MainViewModelModule;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@SuppressWarnings("unused")
@Module(includes = {MainViewModelModule.class})
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(clazz = MainActivityViewModel.class)
    abstract ViewModel bindMainViewModel(MainActivityViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(clazz = ListActivityViewModel.class)
    abstract ViewModel bindListViewModel(ListActivityViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(clazz = ContentTipActivityViewModel.class)
    abstract ViewModel bindContentTipViewModel(ContentTipActivityViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(clazz = EarthquakeActivityViewModel.class)
    abstract ViewModel bindEarthquakeActivityViewModel(EarthquakeActivityViewModel viewModel);




}
