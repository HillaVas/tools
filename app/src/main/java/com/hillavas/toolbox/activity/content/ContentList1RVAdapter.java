package com.hillavas.toolbox.activity.content;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ContentCallback1;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.viewholder.contentList1.ContentVH1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVHAction1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVHFactory1;
import com.hillavas.toolbox.viewholder.contentList2.ContentVHFactory2;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ContentList1RVAdapter extends ListAdapter<ItemContentList, ContentVH1> {

    private ContentVHFactory1 mFactory;
    private final PublishSubject<ContentVHAction1> mClickPS = PublishSubject.create();

    @Inject
    ContentList1RVAdapter(@NonNull ContentCallback1 diffCallback, ContentVHFactory1 factory) {
        super(diffCallback);
        mFactory = factory;
    }


    @NonNull
    @Override
    public ContentVH1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH1 holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<ContentVHAction1> getClickPS() {
        return mClickPS;
    }


}
