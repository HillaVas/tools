package com.hillavas.toolbox.activity.mainActivity;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.HomeCallback;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.viewholder.home.HomeVH;
import com.hillavas.toolbox.viewholder.home.HomeVHAction;
import com.hillavas.toolbox.viewholder.home.HomeVHFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class MainRVAdapter extends ListAdapter<ItemHomeList, HomeVH> {

    private HomeVHFactory mFactory;
    private final PublishSubject<HomeVHAction> mClickPS = PublishSubject.create();

    @Inject
    MainRVAdapter(@NonNull HomeCallback diffCallback, HomeVHFactory factory) {
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
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<HomeVHAction> getClickPS() {
        return mClickPS;
    }


}
