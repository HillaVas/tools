package com.hillavas.toolbox.viewholder.commonList;

import android.content.Context;
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

public class ListsVH extends BaseViewHolder<ListsVHAction, ItemHomeList,ListsVM> {




    @Inject
    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_home_img)
    SimpleDraweeView draweeRowHomeImg;


    public ListsVH(View itemView, ListsVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());
    }

    @Override
    public void bind() {
//        if (mVM.getImage()!= null)
//           draweeRowHomeImg.setImageURI(mVM.getImage());
//        else
//            draweeRowHomeImg.setImageResource(R.drawable.drawer_cover);
    }

    @Override
    public void itemOnClick(PublishSubject<ListsVHAction> actionSubject) {
        itemView.setOnClickListener(v -> {

            Context context = v.getContext();

//            switch (mVM.getName())
//            {
//                case "بانک" :
//                    break;
//                default:
//                {
//
//                    IntentUtils.openWeb(context,"http://www.google.com");
//                }
//            }


//            intent.putExtra(ListActivity.NUMBER_OF_ROW_LIST, mVM.getObject().id()%3);

        });

    }


}
