package com.hillavas.toolbox.viewholder.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.widget.AppCompatTextView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.AlignSelf;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseViewHolder;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.utils.IntentUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class HomeVH extends BaseViewHolder<HomeVHAction, ItemHomeList,HomeVM> {

//    @Inject
//    protected DBManager mDBManager;



//
//    @BindView(R.id.drawee_row_home_img)
//    SimpleDraweeView draweeRowHomeImg;


    @BindView(R.id.drawee_row_home_img)
    SimpleDraweeView draweeRowHomeImg;

    @BindView(R.id.txt_row_item_name)
    AppCompatTextView txtRowItemName;

//    @BindView(R.id.drawee_row_home_img)
//    ImageView draweeRowHomeImg;


    DisplayMetrics displayMetrics = new DisplayMetrics();


    public HomeVH(View itemView, HomeVM viewModel) {
        super(itemView, viewModel);
        ButterKnife.bind(this,itemView);
        itemOnClick(PublishSubject.create());


        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
    }


    @SuppressLint("WrongConstant")
    @Override
    public void bind() {



        if (getAdapterPosition()%3 == 0) {
            draweeRowHomeImg.setAspectRatio(3f);
        }
        else {
            draweeRowHomeImg.setAspectRatio(1.7f);
        }


       if (mVM.getAttachmentSize ()!=0){
           if (!mVM.getImage("").equals("")){

               Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api"+mVM.getImage("x"));
               draweeRowHomeImg.setImageURI(uri);
               if (mVM.getShowName())
                   txtRowItemName.setText(mVM.getName());
//            draweeRowHomeImg.setImageResource(uri);

               ViewGroup.LayoutParams lp = draweeRowHomeImg.getLayoutParams();
               if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                   FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
                   flexboxLp.setFlexGrow(1.0f);
                   flexboxLp.setAlignSelf(AlignSelf.AUTO);
               }
           }
           else{
               Uri myUri = Uri.parse(mVM.getImage("x"));
               draweeRowHomeImg.setImageURI(myUri);
//            draweeRowHomeImg.setImageURI(mVM.getImage());
               ViewGroup.LayoutParams lp = draweeRowHomeImg.getLayoutParams();
               if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                   FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) lp;
                   flexboxLp.setFlexGrow(1.0f);
                   flexboxLp.setAlignSelf(AlignSelf.FLEX_END);
               }
           }
         }


    }

    @Override
    public void itemOnClick(PublishSubject<HomeVHAction> actionSubject) {
        itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            int row = 1;
            double  ratio = 1;



            if (mVM.getHasChild())
            {

                switch ((mVM.getName())){
                    case "املاک" :
                        row = 1;
                        ratio = 2;
                        break;
                    case "خودرو" :
                        row = 1;
                        ratio = 2;
                        break;
                    case "ترافیک" :
                        row = 1;
                        ratio = 1;
                        break;
                    case "بانک" :
                        row = 1;
                        ratio = 1;
                        break;
                    case "موبایل" :
                        row = 1;
                        ratio = 1;
                        break;
                    case "مدیا" :
                        row = 1;
                        ratio = 1;
                        break;
                    case "ابزار" :
                        row = 2;
                        ratio = 1;
                        break;
                }
                IntentUtils.openListL2(context,mVM.getName(),row,mVM.getCategoryId(),ratio);
            }
            else
            {
                switch (mVM.getName()){



                    case "املاک" :
                        IntentUtils.openAmlakRahnForush(context,39);
                        break;
                    case "خودرو" :
                        row = 2;
                        ratio = 2;
                        break;
                    case "ترافیک" :
                        row = 1;
                        ratio = 1;
                        break;
                    case "فال" :
                        row = 3;
                        ratio = 1;
                        break;
                    case "ابزار" :

                        break;
                    case "ریمایندر" :
                        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                       context.startActivity(i);

                        break;

                    case "تعبیر خواب" :

                        break;


                }
            }

            if (mVM.getContentType()== 26)
            {
                IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());

            }

            if (mVM.getContentType()== 3)
            {
                IntentUtils.openContentTip(context,mVM.getCategoryId(),mVM.getContentType());

            }


//            IntentUtils.openListL2(context,mVM.getName(),row,mVM.getCategoryId(),ratio);




//            ItemHomeList ItemHomeList = ItemHomeList.create(mVM.getId(), "category", mVM.getImage(), mVM.getTitle());

//            Intent intent = new Intent(context, ListActivity.class);
//            intent.putExtra(ListActivity.NUMBER_OF_ROW_LIST, mVM.getObject().id()%3);
//            context.startActivity(intent);
        });

    }
}
