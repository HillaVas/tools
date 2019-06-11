package com.hillavas.toolbox.activity.listActivity;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ItemListCallback;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.viewholder.listOneRow.List1RVH;
import com.hillavas.toolbox.viewholder.listOneRow.List1RVHAction;
import com.hillavas.toolbox.viewholder.listOneRow.List1RVHFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class List1RRVAdapter extends ListAdapter<ItemHomeList, List1RVH> {

    private List1RVHFactory mFactory;
    private final PublishSubject<List1RVHAction> mClickPS = PublishSubject.create();

    @Inject
    List1RRVAdapter(@NonNull ItemListCallback diffCallback, List1RVHFactory factory) {
        super(diffCallback);
        mFactory = factory;
    }


    @NonNull
    @Override
    public List1RVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull List1RVH holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<List1RVHAction> getClickPS() {
        return mClickPS;
    }


}
