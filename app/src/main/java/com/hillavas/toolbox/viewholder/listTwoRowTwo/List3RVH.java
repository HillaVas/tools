package com.hillavas.toolbox.viewholder.listTwoRowTwo;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class List3RVH extends BaseViewHolder<List3RVHAction, ItemHomeList, List3RVM> {

//    @Inject
//    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_home_img2)
    SimpleDraweeView draweeRowHomeImg2;

    @BindView(R.id.drawee_row_home_img1)
    SimpleDraweeView draweeRowHomeImg1;



    public List3RVH(View itemView, List3RVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());
    }

    @Override
    public void bind() {
        if (mVM.getImage()!= null){
                draweeRowHomeImg1.setImageURI(mVM.getImage());
//            if (mVM.getObject().name()=="بانک")
//                draweeRowHomeImg.setAspectRatio(1.7f);
//            else if (mVM.getObject().name()=="موبایل")
//                draweeRowHomeImg.setAspectRatio(1.4f);
//            else if (mVM.getObject().name()=="ترافیک")
//                draweeRowHomeImg.setAspectRatio(2.2f);
        }

        else
            draweeRowHomeImg1.setImageResource(R.drawable.drawer_cover);
    }

    @Override
    public void itemOnClick(PublishSubject<List3RVHAction> actionSubject) {

    }
}
