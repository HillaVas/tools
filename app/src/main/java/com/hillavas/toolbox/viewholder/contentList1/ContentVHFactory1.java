package com.hillavas.toolbox.viewholder.contentList1;

import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class ContentVHFactory1 implements ViewHolderFactory<ContentVH1> {

    int categuryId;


    @Inject
    ContentVHFactory1() {
    }

    @Override
    public ContentVH1 create(ViewGroup parent) {

        if (categuryId == 19) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_content_2, parent, false);
            return new ContentVH1(view, new ContentVM1());
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_content_1, parent, false);
            return new ContentVH1(view, new ContentVM1());
        }

    }


}
