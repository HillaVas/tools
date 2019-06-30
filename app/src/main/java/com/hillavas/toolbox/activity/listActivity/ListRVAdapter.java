package com.hillavas.toolbox.activity.listActivity;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ItemListCallback;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.viewholder.commonList.ListsVH;
import com.hillavas.toolbox.viewholder.commonList.ListsVHAction;
import com.hillavas.toolbox.viewholder.commonList.ListsVHFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ListRVAdapter extends ListAdapter<ItemHomeList, ListsVH> {

    private ListsVHFactory mFactory;
    private final PublishSubject<ListsVHAction> mClickPS = PublishSubject.create();

    @Inject
    ListRVAdapter(@NonNull ItemListCallback diffCallback, ListsVHFactory factory) {
        super(diffCallback);
        mFactory = factory;
    }


    @NonNull
    @Override
    public ListsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ListsVH holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<ListsVHAction> getClickPS() {
        return mClickPS;
    }


}
