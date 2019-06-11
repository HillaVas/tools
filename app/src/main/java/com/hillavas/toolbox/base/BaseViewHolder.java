package com.hillavas.toolbox.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.reactivex.subjects.PublishSubject;

public abstract class BaseViewHolder<A extends BaseViewHolderAction, K, T extends BaseVHViewModel<K>> extends RecyclerView.ViewHolder {

    protected final T mVM;

    public BaseViewHolder(View itemView, T viewModel) {
        super(itemView);
        mVM = viewModel;
    }

    public abstract void bind();

    public abstract void itemOnClick(PublishSubject<A> actionSubject);

    public T getVM() {
        return mVM;
    }
}
