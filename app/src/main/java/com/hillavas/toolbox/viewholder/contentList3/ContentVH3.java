package com.hillavas.toolbox.viewholder.contentList3;

import android.net.Uri;
import android.support.v7.widget.AppCompatTextView;
import android.util.DisplayMetrics;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.ItemContentList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class ContentVH3 extends BaseViewHolder<ContentVHAction3, ItemContentList,ContentVM3> {

    @BindView(R.id.drawee_row_item_ontent_img_1)
    SimpleDraweeView draweeRowItemOntentImg1;
    @BindView(R.id.txtItemContentName_list_1)
    AppCompatTextView txtItemContentNameList1;

    DisplayMetrics displayMetrics = new DisplayMetrics();

    public ContentVH3(View itemView, ContentVM3 viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());

    }

    @Override
    public void bind() {

        Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage("l"));
        draweeRowItemOntentImg1.setImageURI(uri);
        txtItemContentNameList1.setText(mVM.getTitle());

    }

    @Override
    public void itemOnClick(PublishSubject<ContentVHAction3> actionSubject) {

    }
}
