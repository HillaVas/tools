package com.hillavas.toolbox.activity.mainActivity;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.viewholder.home.HomeVH;
import com.hillavas.toolbox.viewholder.home.HomeVHAction;
import com.hillavas.toolbox.viewholder.home.HomeVHFactory;

import io.reactivex.subjects.PublishSubject;

public class MainRVNewAdapter extends ListAdapter<ItemHomeList, HomeVH> {

    private HomeVHFactory mFactory;
    private final PublishSubject<HomeVHAction> mClickPS = PublishSubject.create();

    protected MainRVNewAdapter(@NonNull DiffUtil.ItemCallback<ItemHomeList> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public HomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVH holder, int position) {

    }
}
