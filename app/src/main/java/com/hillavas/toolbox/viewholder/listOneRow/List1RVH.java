package com.hillavas.toolbox.viewholder.listOneRow;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.AppCompatTextView;
import android.util.DisplayMetrics;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.activity.mainActivity.MainActivity;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.utils.IntentUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static android.support.v4.content.ContextCompat.startActivity;

public class List1RVH extends BaseViewHolder<List1RVHAction, ItemHomeList,List1RVM> {

//    @Inject
//    protected DBManager mDBManager;


    @BindView(R.id.drawee_row_home_img)
    SimpleDraweeView draweeRowHomeImg;

    @BindView(R.id.txt_row_item_name)
    AppCompatTextView txtRowItemName;

    DisplayMetrics displayMetrics = new DisplayMetrics();


    public List1RVH(View itemView, List1RVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());
    }

    @Override
    public void bind() {

        Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage("x"));
        draweeRowHomeImg.setImageURI(uri);

        if (mVM.getShowName())
            txtRowItemName.setText(mVM.getName());

    }

    @Override
    public void itemOnClick(PublishSubject<List1RVHAction> actionSubject) {

        itemView.setOnClickListener(v -> {
            Context context =v.getContext();
            if (mVM.getHasChild())
            {
                switch (mVM.getCategoryType()){
                    case  0   :
                        IntentUtils.openListL2(context,mVM.getName(),1,mVM.getCategoryId(),3 );
                        break;

                    case  3   :
                        IntentUtils.openListL2(context,mVM.getName(),3,mVM.getCategoryId(),1 );
                        break;

                }
            }else {

                if (mVM.getContentType()!= null)
                {
                    switch (mVM.getContentType()){


                        case 3 :
                            IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                            break;

                        case 12 :
                            IntentUtils.openEarthquakeActivity(context,mVM.getCategoryId(),mVM.getContentType());
                            break;

                        case 10 :
                            IntentUtils.openQebleNAma(context);
                            break;

                        case 26 :
                            IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());
                            break;

                        case  15   :
                            IntentUtils.openBarCodeActivity(context,mVM.getCategoryId(),mVM.getContentType());
                            break;

                        case  21   :
                            IntentUtils.openMirror(context);
                            break;


                        case  13   :
                            IntentUtils.openFlashLight(context,mVM.getCategoryId(),mVM.getContentType());

                            break;


                        case  11   :
                            IntentUtils.openSalavatShomar(context,mVM.getCategoryId(),mVM.getContentType());

                            break;

//                        default:
//                            IntentUtils.openWeb(context,"https://kitset.ir/financial/loan-profits");


                    }
                }
//                else {
//                    switch (mVM.getName()){
//                        case "مبدل شماره شبا" :
//                            IntentUtils.openWeb(context,"https://samanbourse.com/pishkhan/shaba");
//                            break;
//
//                        case "سود بانکی و قسط وام" :
//                            IntentUtils.openWeb(context,"https://kitset.ir/financial/loan-profits");
//                            break;
//                    }
//                }

            }
        });

    }
}
