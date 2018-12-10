package com.newamlak.intel.objectboxtest.app.viewmodel;


import android.arch.lifecycle.ViewModel;


import com.newamlak.intel.objectboxtest.activity.itemList.ItemListActivityViewModel;
import com.newamlak.intel.objectboxtest.activity.mainActivity.MainActivityViewModel;
import com.newamlak.intel.objectboxtest.activity.mainActivity.MainViewModelModule;

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
    @ViewModelKey(clazz = ItemListActivityViewModel.class)
    abstract ViewModel bindItemListActivityViewModel(ItemListActivityViewModel viewModel);
}
