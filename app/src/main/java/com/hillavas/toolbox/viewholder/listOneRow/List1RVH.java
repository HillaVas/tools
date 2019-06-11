package com.hillavas.toolbox.viewholder.listOneRow;

import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.manager.db.DBManager;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class List1RVH extends BaseViewHolder<List1RVHAction, ItemHomeList,List1RVM> {

    @Inject
    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_home_img)
    SimpleDraweeView draweeRowHomeImg;

    DisplayMetrics displayMetrics = new DisplayMetrics();


    public List1RVH(View itemView, List1RVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());
    }

    @Override
    public void bind() {

        Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage());
        draweeRowHomeImg.setImageURI(uri);

//        if (mVM.getImage()!= null){
//            draweeRowHomeImg.setImageURI(mVM.getImage());
//            if (mVM.getObject().name()=="بانک")
//                draweeRowHomeImg.setAspectRatio(1.7f);
//            else if (mVM.getObject().name()=="موبایل")
//                draweeRowHomeImg.setAspectRatio(1.4f);
//            else if (mVM.getObject().name()=="ترافیک")
//                draweeRowHomeImg.setAspectRatio(2.2f);
//        }

//        else
//            draweeRowHomeImg.setImageResource(R.drawable.drawer_cover);
    }

    @Override
    public void itemOnClick(PublishSubject<List1RVHAction> actionSubject) {

    }
}
