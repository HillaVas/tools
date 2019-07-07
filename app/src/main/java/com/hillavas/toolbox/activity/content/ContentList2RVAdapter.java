package com.hillavas.toolbox.activity.content;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ContentCallback1;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.viewholder.contentList2.ContentVH2;
import com.hillavas.toolbox.viewholder.contentList2.ContentVHAction2;
import com.hillavas.toolbox.viewholder.contentList2.ContentVHFactory2;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ContentList2RVAdapter extends ListAdapter<ItemContentList, ContentVH2> {

    private ContentVHFactory2 mFactory2;
    private final PublishSubject<ContentVHAction2> mClickPS = PublishSubject.create();

    @Inject
    ContentList2RVAdapter(@NonNull ContentCallback1 diffCallback, ContentVHFactory2 factory) {
        super(diffCallback);
        mFactory2 = factory;
    }


    @NonNull
    @Override
    public ContentVH2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory2.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH2 holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<ContentVHAction2> getClickPS() {
        return mClickPS;
    }


}
