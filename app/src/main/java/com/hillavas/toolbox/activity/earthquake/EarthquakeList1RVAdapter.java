package com.hillavas.toolbox.activity.earthquake;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ContentCallback1;
import com.hillavas.toolbox.diffcallbacks.EarthquakeCallback;
import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.viewholder.contentList1.ContentVH1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVHAction1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVHFactory1;
import com.hillavas.toolbox.viewholder.earthqList.EarthqVH;
import com.hillavas.toolbox.viewholder.earthqList.EarthqVHAction;
import com.hillavas.toolbox.viewholder.earthqList.EarthqVHFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class EarthquakeList1RVAdapter extends ListAdapter<EarthquakeItem, EarthqVH> {

    private EarthqVHFactory mFactory;
    private final PublishSubject<EarthqVHAction> mClickPS = PublishSubject.create();

    @Inject
    EarthquakeList1RVAdapter(@NonNull EarthquakeCallback diffCallback, EarthqVHFactory factory) {
        super(diffCallback);
        mFactory = factory;
    }


    @NonNull
    @Override
    public EarthqVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthqVH holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<EarthqVHAction> getClickPS() {
        return mClickPS;
    }


}
