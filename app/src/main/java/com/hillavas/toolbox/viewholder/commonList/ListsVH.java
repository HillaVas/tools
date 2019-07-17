package com.hillavas.toolbox.viewholder.commonList;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.utils.IntentUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class ListsVH extends BaseViewHolder<ListsVHAction, ItemHomeList,ListsVM> {



//
//    @Inject
//    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_home_img)
    SimpleDraweeView draweeRowHomeImg;


    @BindView(R.id.txt_row_item_name)
    AppCompatTextView txtRowItemName;



    public ListsVH(View itemView, ListsVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());
    }

    @Override
    public void bind() {

        Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage("l"));
        draweeRowHomeImg.setImageURI(uri);

        if (mVM.getShowName())
            txtRowItemName.setText(mVM.getName());

//        if (mVM.getImage()!= null)
//           draweeRowHomeImg.setImageURI(mVM.getImage());
//        else
//            draweeRowHomeImg.setImageResource(R.drawable.drawer_cover);
    }

    @Override
    public void itemOnClick(PublishSubject<ListsVHAction> actionSubject) {
        itemView.setOnClickListener(v -> {
            Context context =v.getContext();
            if (mVM.getHasChild())
            {
                switch (mVM.getCategoryType()){
                    case  0   :
                        IntentUtils.openListL2(context,mVM.getName(),1,mVM.getCategoryId(),3);

                }
            }else {
                switch (mVM.getContentType()){


                    case 0 :
                        IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                        break;


                    case  20   :
                        IntentUtils.openWeb(context,"https://epostcode.post.ir/");
                        break;

                    case  4   :
                        IntentUtils.openAmlakRahnForush(context,mVM.getContentType());
                        break;

                    case  5   :
                        IntentUtils.openAmlakRahnForush(context,mVM.getContentType());
                        break;

                    case  12   :
                        IntentUtils.openEarthquakeActivity(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

                    case  15   :
                        IntentUtils.openBarCodeActivity(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

                    case  13   :
                        IntentUtils.openBarCodeActivity(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

                    case 18:
                        IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

                    case 19:
                        IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

                    case 3:
                        IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                        break;

//                    default:
//                        IntentUtils.openWeb(context,"https://kitset.ir/financial/loan-profits");


                }
            }
        });

    }


}
