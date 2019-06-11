package com.hillavas.toolbox.fragment.rvadapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.viewholder.home.HomeVH;
import com.hillavas.toolbox.viewholder.home.HomeVHFactory;

import javax.inject.Inject;

public class HomeRVAdapter extends ListAdapter<ItemHomeList, HomeVH> {

    private  final HomeVHFactory mFactory;

    @Inject
    protected HomeRVAdapter(@NonNull DiffUtil.ItemCallback<ItemHomeList> diffCallback , HomeVHFactory factory) {
        super(diffCallback);
        mFactory = factory;

    }

    @NonNull
    @Override
    public HomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVH holder, int position) {
//        holder.getVM().setObject(getItem(position));
        holder.bind();
    }
}
