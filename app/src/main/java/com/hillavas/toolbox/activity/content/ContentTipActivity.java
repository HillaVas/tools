package com.hillavas.toolbox.activity.content;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.rvdivider.SimpleItemDivider;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.SettingModel;
import com.hillavas.toolbox.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class ContentTipActivity extends BaseDaggerCompatActivity<ContentTipActivityState, ContentTipActivityViewModel> {

    public static final String CATEGGORY_ID_CONTENTTIP = "category_id_contenttip";
    public static final String CONTENT_TYPE = "Content_Type";
    boolean isLike = false;

//    @Inject
//    Provider<ContentList1RVAdapter> mContentL1RVAdapterProvider;
//    ContentList1RVAdapter mContentL1RVAdapter;


    @Inject
    Provider<ContentList1RVAdapter> mMainRVAdapterProvider;
    @Inject
    Provider<ContentList2RVAdapter> mMainRVAdapterProvider2;
    @Inject
    Provider<ContentList3RVAdapter> mMainRVAdapterProvider3;
    ContentList1RVAdapter mContentRVAdapter1;
    ContentList2RVAdapter mContentRVAdapter2;
    ContentList3RVAdapter mContentRVAdapter3;


    @Inject
    CompositeDisposable mDisposable;
//    @BindView(R.id.txtContentTipName1)
//    AppCompatTextView txtContentTipName1;
    @BindView(R.id.svg_like)
    ImageButton svgLike;
    @BindView(R.id.txtItemContentlikecount)
    AppCompatTextView txtItemContentlikecount;
    @BindView(R.id.txtItemContentViewCount)
    AppCompatTextView txtItemContentViewCount;


    private int categoryId = 0;
    private int contentType = 0;
    private double attachmentType = 1;

    GridLayoutManager mGridLayoutManager;

    private List<ItemContentList> mList;

    SettingModel setting;

    @BindView(R.id.img_btn_back)
    AppCompatImageButton imgBtnBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_image_big)
    SimpleDraweeView contentImageBig;
    @BindView(R.id.txtContentTipName)
    AppCompatTextView txtContentTipName;
    @BindView(R.id.txtContentTipDetail)
    AppCompatTextView txtContentTipDetail;
    @BindView(R.id.img_content_image_big)
    ImageView imgContentImageBig;
    @BindView(R.id.r_list_content_1)
    RecyclerView rListContent1;
    @BindView(R.id.www1)
    WebView www1;
    @BindView(R.id.coordin_content)
    CoordinatorLayout coordinContent;

    @Override
    public void handleState(ContentTipActivityState state) {
        if (state.status == ContentTipActivityState.STATUS_SUCCESS) {


            mList = state.list;
            if (mList.size() != 0) {


//                if (contentType == 3)
//                    imgContentImageBig.setImageResource(R.drawable.mobile_fix_code2);
                if (contentType == 0) {
                    txtContentTipDetail.setText(mList.get(0).Desc());
                    txtContentTipName.setText(mList.get(0).Title());
                    txtItemContentlikecount.setText(String.valueOf(mList.get(0).LikeCount()));
                    txtItemContentViewCount.setText(String.valueOf(mList.get(0).ViewCount()));
                    if (mList.get(0).IsLiked())
                    {
                        isLike = true;
                        svgLike.setImageResource(R.drawable.ic_svg_favorite);
                    }
                    Uri uri = Uri.parse("http://79.175.138.89:8088/toolbox/api" + mList.get(0).Attachments().get(0).RelativeAddress());
                    contentImageBig.setImageURI(uri);

                } else if (contentType == 3) {
                    initRV3();
                } else if (contentType == 18) {
                    initRV();
                } else if (contentType == 19) {
                    initRV2();
                } else if (contentType == 26) {
                    WebSettings webSettings = www1.getSettings();
                    webSettings.setJavaScriptEnabled(true);

                    www1.loadUrl(mList.get(0).InternetAddress());
                }

            } else {
                finish();
            }

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mIntent = getIntent();
        categoryId = mIntent.getIntExtra(CATEGGORY_ID_CONTENTTIP, 0);
        contentType = mIntent.getIntExtra(CONTENT_TYPE, 0);
        getPref();
//        contentType = 19;

        if (contentType == 0)
            setContentView(R.layout.activity_content_tip);
        else if (contentType == 3) {
            setContentView(R.layout.activity_content_tip_list3);
        } else if (contentType == 19) {
            setContentView(R.layout.activity_content_tip_list1);
        } else if (contentType == 18) {
            setContentView(R.layout.activity_content_tip_list1);
        } else if (contentType == 26) {
            setContentView(R.layout.activity_content_web);
        }


        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        createViewModel(ContentTipActivityViewModel.class);


        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        coordinContent.setBackgroundColor(Color.parseColor(setting.AppMainColor()));

        startObserving();
        mViewModel.getContentTip(categoryId);

    }

    @OnClick(R.id.img_btn_back)
    public void onViewClicked() {
        finish();
    }

    void updateViewSize(@Nullable ImageInfo imageInfo) {
        if (imageInfo != null) {
            contentImageBig.getLayoutParams().width = imageInfo.getWidth();
            contentImageBig.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            contentImageBig.setAspectRatio((float) imageInfo.getWidth() / imageInfo.getHeight());
        }
    }

    public void initRV2() {

        if (mList.get(0).Attachments().get(0).AttachmentType() != 0)
            attachmentType = mList.get(0).Attachments().get(0).AttachmentType();
        int divider = 0;
        mContentRVAdapter1 = mMainRVAdapterProvider.get();
        mContentRVAdapter1 = mMainRVAdapterProvider.get();
        mContentRVAdapter1.submitList(mList);
        mContentRVAdapter1.submitList(mList);


        mGridLayoutManager = new GridLayoutManager(this, 1);
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(numberRow,StaggeredGridLayoutManager.VERTICAL);
//        mLinearLayoutManager = new LinearLayoutManager(this);
        if (attachmentType == 1)
            rListContent1.setAdapter(mContentRVAdapter1);
//        else if(attachmentType==3)
//            rListHome.setAdapter(mMainRVAdapter);
        else {
            mContentRVAdapter1.submitList(mList);
            rListContent1.setAdapter(mContentRVAdapter1);

        }

        rListContent1.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mLinearLayoutManager);
        rListContent1.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
        rListContent1.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
        rListContent1.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
            //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
//        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                mViewModel.incrementPage();
            }
        });

        Disposable disposable = mContentRVAdapter1.getClickPS()
                .subscribe(action -> {
                    Timber.d("action add to play list");
                    int i = action.getAdapterPosition();
                    ItemContentList videoModel = (ItemContentList) getIntent().getParcelableExtra("parcel_data_video_model");
//                    int s = mList.get(i).id();


//                    String videoId = "99";
//
//                    mViewModel.addPlaylist(i, videoId);
//                    finish();


                }, t ->
                {
                    Timber.e(t, "FAVOURITE sending video list action failed");
                });

        mDisposable.add(disposable);

    }

    public void initRV() {

        if (mList.get(0).Attachments().get(0).AttachmentType() != 0)
            attachmentType = mList.get(0).Attachments().get(0).AttachmentType();
        int divider = 0;
        mContentRVAdapter2 = mMainRVAdapterProvider2.get();
        mContentRVAdapter2 = mMainRVAdapterProvider2.get();
        mContentRVAdapter2.submitList(mList);
        mContentRVAdapter2.submitList(mList);


        mGridLayoutManager = new GridLayoutManager(this, 1);
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(numberRow,StaggeredGridLayoutManager.VERTICAL);
//        mLinearLayoutManager = new LinearLayoutManager(this);
        if (attachmentType == 1)
            rListContent1.setAdapter(mContentRVAdapter2);
//        else if(attachmentType==3)
//            rListHome.setAdapter(mMainRVAdapter);
        else {
            mContentRVAdapter1.submitList(mList);
            rListContent1.setAdapter(mContentRVAdapter2);

        }

        rListContent1.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mLinearLayoutManager);
        rListContent1.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
        rListContent1.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
        rListContent1.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
            //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
//        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                mViewModel.incrementPage();
            }
        });

        Disposable disposable = mContentRVAdapter2.getClickPS()
                .subscribe(action -> {
                    Timber.d("action add to play list");
                    int i = action.getAdapterPosition();
                    ItemContentList videoModel = (ItemContentList) getIntent().getParcelableExtra("parcel_data_video_model");
//                    int s = mList.get(i).id();


//                    String videoId = "99";
//
//                    mViewModel.addPlaylist(i, videoId);
//                    finish();


                }, t ->
                {
                    Timber.e(t, "FAVOURITE sending video list action failed");
                });

        mDisposable.add(disposable);

    }

    public void initRV3() {

        if (mList.get(0).Attachments().get(0).AttachmentType() != 0)
            attachmentType = mList.get(0).Attachments().get(0).AttachmentType();
        int divider = 0;
        mContentRVAdapter3 = mMainRVAdapterProvider3.get();
        mContentRVAdapter3 = mMainRVAdapterProvider3.get();
        mContentRVAdapter3.submitList(mList);
        mContentRVAdapter3.submitList(mList);


        mGridLayoutManager = new GridLayoutManager(this, 1);
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(numberRow,StaggeredGridLayoutManager.VERTICAL);
//        mLinearLayoutManager = new LinearLayoutManager(this);
        if (attachmentType == 1)
            rListContent1.setAdapter(mContentRVAdapter3);
//        else if(attachmentType==3)
//            rListHome.setAdapter(mMainRVAdapter);
        else {
            mContentRVAdapter3.submitList(mList);
            rListContent1.setAdapter(mContentRVAdapter3);

        }

        rListContent1.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mLinearLayoutManager);
        rListContent1.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
        rListContent1.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
        rListContent1.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
            //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
//        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                mViewModel.incrementPage();
            }
        });

        Disposable disposable = mContentRVAdapter3.getClickPS()
                .subscribe(action -> {
                    Timber.d("action add to play list");
                    int i = action.getAdapterPosition();
                    ItemContentList videoModel = (ItemContentList) getIntent().getParcelableExtra("parcel_data_video_model");
//                    int s = mList.get(i).id();


//                    String videoId = "99";
//
//                    mViewModel.addPlaylist(i, videoId);
//                    finish();


                }, t ->
                {
                    Timber.e(t, "FAVOURITE sending video list action failed");
                });

        mDisposable.add(disposable);

    }


    public SettingModel getPref() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String bgColor = prefs.getString("AppBgColor", null);
        String mainColor = prefs.getString("AppMainColor", null);
        setting = SettingModel.createSetting(bgColor, mainColor, false, null, null, null);
        return setting;
    }


    @OnClick(R.id.svg_like)
    public void onViewClickedLike() {

        if (isLike)
        {
            isLike = false;
            svgLike.setImageResource(R.drawable.ic_svg_unfavorite);
            int count =Integer.valueOf((String) txtItemContentlikecount.getText());
            txtItemContentlikecount.setText(String.valueOf(count-1));
        }else {
            isLike = true;
            svgLike.setImageResource(R.drawable.ic_svg_favorite);
            int count =Integer.valueOf((String) txtItemContentlikecount.getText());
            txtItemContentlikecount.setText(String.valueOf(count+1));
        }
    }
}
