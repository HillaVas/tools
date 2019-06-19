package com.hillavas.toolbox.viewholder.contentList2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.AppCompatTextView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.manager.db.DBManager;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.viewholder.contentList1.ContentVHAction1;
import com.hillavas.toolbox.viewholder.contentList1.ContentVM1;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class ContentVH2 extends BaseViewHolder<ContentVHAction2, ItemContentList,ContentVM2> {

    @Inject
    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_item_ontent_img_1)
    SimpleDraweeView draweeRowItemOntentImg1;
    @BindView(R.id.txtItemContentName_list_1)
    AppCompatTextView txtItemContentNameList1;
    @BindView(R.id.txt_row_item_ontent_1)
    TextView txtRowItemOntent1;


    DisplayMetrics displayMetrics = new DisplayMetrics();


    public ContentVH2(View itemView, ContentVM2 viewModel , int catId) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());


        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
    }

    public ContentVH2(View itemView, ContentVM2 viewModel ) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());


        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
    }


    @SuppressLint("WrongConstant")
    @Override
    public void bind() {
        Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage("l"));
        draweeRowItemOntentImg1.setImageURI(uri);
        txtItemContentNameList1.setText(mVM.getTitle());
        txtRowItemOntent1.setText(mVM.getTxt());

    }

    @Override
    public void itemOnClick(PublishSubject<ContentVHAction2> actionSubject) {
        itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            int row = 1;
            double  ratio = 1;


        });

    }
}
