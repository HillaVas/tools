package com.hillavas.toolbox.viewholder.contentList3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.ViewHolderFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class ContentVHFactory3 implements ViewHolderFactory<ContentVH3> {


    @BindView(R.id.drawee_row_item_ontent_img_1)
    ImageView draweeRowItemOntentImg1;

    @Inject
    ContentVHFactory3() {
    }

    @Override
    public ContentVH3 create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_content_3, parent, false);
        return new ContentVH3(view, new ContentVM3());
    }
}
