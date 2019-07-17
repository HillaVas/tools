package com.hillavas.toolbox.activity.content;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.ViewGroup;

import com.hillavas.toolbox.diffcallbacks.ContentCallback1;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.viewholder.contentList2.ContentVH2;
import com.hillavas.toolbox.viewholder.contentList2.ContentVHAction2;
import com.hillavas.toolbox.viewholder.contentList2.ContentVHFactory2;
import com.hillavas.toolbox.viewholder.contentList3.ContentVH3;
import com.hillavas.toolbox.viewholder.contentList3.ContentVHAction3;
import com.hillavas.toolbox.viewholder.contentList3.ContentVHFactory3;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class ContentList3RVAdapter extends ListAdapter<ItemContentList, ContentVH3> {

    private ContentVHFactory3 mFactory3;
    private final PublishSubject<ContentVHAction3> mClickPS = PublishSubject.create();

    @Inject
    ContentList3RVAdapter(@NonNull ContentCallback1 diffCallback, ContentVHFactory3 factory) {
        super(diffCallback);
        mFactory3 = factory;
    }


    @NonNull
    @Override
    public ContentVH3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory3.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH3 holder, int position) {
        holder.getVM().setObject(getItem(position));
        holder.bind();
        holder.itemOnClick(mClickPS);
    }

    public Observable<ContentVHAction3> getClickPS() {
        return mClickPS;
    }


}
