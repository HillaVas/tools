package com.hillavas.toolbox.viewholder.contentList2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;
import com.hillavas.toolbox.viewholder.contentList1.ContentVH1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVM1;

import javax.inject.Inject;

import butterknife.OnClick;


public class ContentVHFactory2 implements ViewHolderFactory<ContentVH2> {

int categuryId ;


    @Inject
    ContentVHFactory2() {
    }

    @Override
    public ContentVH2 create(ViewGroup parent ) {


            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_content_2, parent, false);
            return new ContentVH2(view, new ContentVM2());


    }

    @OnClick(R.id.drawee_row_home_img)
    public void onViewClicked() {
    }
}
