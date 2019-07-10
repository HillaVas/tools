package com.hillavas.toolbox.activity.mainActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.dgreenhalgh.android.simpleitemdecoration.grid.GridBottomOffsetItemDecoration;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.rvdivider.BottomOffsetDecoration;
import com.hillavas.toolbox.rvdivider.GridDividerItemDecorationFixed;
import com.hillavas.toolbox.rvdivider.SimpleItemDivider;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;
import com.hillavas.toolbox.utils.DPConverter;
import com.hillavas.toolbox.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends BaseDaggerCompatActivity<MainActivityState, MainActivityViewModel> {


    List<ItemHomeList> homeList = new ArrayList<>();
    List<ItemModel> _homeList = new ArrayList<>();
    SettingModel setting ;

    LinearLayoutManager mLinearLayoutManager;
//    GridLayoutManager mGridLayoutManager;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    @Inject
    Provider<MainRVAdapter> mMainRVAdapterProvider;
    MainRVAdapter mMainRVAdapter;

    @Inject
    Provider<GridDividerItemDecorationFixed> mGridDividerItemDecorationFixedProvider;
    GridDividerItemDecorationFixed mGridDividerItemDecorationFixed;


    @Inject
    Provider<GridLayoutManager> mGridLayoutManagerProvider;
    GridLayoutManager mGridLayoutManager;


    @Inject
    CompositeDisposable mDisposable;

    @Inject
    CompositeDisposable mCompositeDisposable;


    @BindView(R.id.img_main_logo)
    AppCompatImageView imgMainLogo;
    @BindView(R.id.txt_main_title)
    AppCompatTextView txtMainTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btm_bar_main)
    AHBottomNavigation btmBarMain;
    @BindView(R.id.r_list_home)
    RecyclerView rListHome;
    @BindView(R.id.nav_view)
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Fresco.initialize(this);


        createViewModel(MainActivityViewModel.class);
        startObserving();

//        mViewModel.getBase();
        mViewModel.getSetting();
        mViewModel.getHomeList();

//        if (savedInstanceState != null) {
//
//          }

    }

    @Override
    public void handleState(MainActivityState state) {
        if (state.status == MainActivityState.STATUS_SUCCESS) {

            if (state.list!=null){
                homeList = state.list;
                if ((homeList.size()%3)==2)

                    homeList.add(ItemHomeList.createItemHomeList(0,0,true,"بزودی ...",false,null));
//
                initRV();
            }else {
                setting = state.settingModel;
                toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
            }


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }


     public void initRV1() {

         int divider = 0;
         mMainRVAdapter = mMainRVAdapterProvider.get();
         mMainRVAdapter.submitList(homeList);
 //        mGridLayoutManager = new GridLayoutManager(this,2);
         mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
 //        mLinearLayoutManager = new LinearLayoutManager(this);
         rListHome.setAdapter(mMainRVAdapter);
         rListHome.setLayoutManager(mStaggeredGridLayoutManager);
 //        rListHome.setLayoutManager(mGridLayoutManager);
 //        rListHome.setLayoutManager(mLinearLayoutManager);
         rListHome.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
         rListHome.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
         rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mStaggeredGridLayoutManager) {
 //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
 //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
             @Override
             public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
 //                mViewModel.incrementPage();
             }
         });

         Disposable disposable = mMainRVAdapter.getClickPS()
                 .subscribe(action -> {
                     Timber.d("action add to play list");
                     int i = action.getAdapterPosition();
                     ItemHomeList videoModel = (ItemHomeList) getIntent().getParcelableExtra("parcel_data_video_model");
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
    private void initRV() {
        int divider;
        if (this != null) {
            divider = (int) this.getResources().getDimension(R.dimen.yellow);
        } else {
            divider = (int) DPConverter.convertDpToPx(6f);
        }

        mGridDividerItemDecorationFixed = mGridDividerItemDecorationFixedProvider.get();
        mMainRVAdapter = mMainRVAdapterProvider.get();
        mGridLayoutManager = mGridLayoutManagerProvider.get();
//        homeList.set(16,homeList.get(15));
//        homeList.add(homeList.get(15));
//        homeList.add(homeList.get(0));
//        homeList.add(homeList.get(1));
//        homeList.add(homeList.get(2));
        mMainRVAdapter.submitList(homeList);
        rListHome.setAdapter(mMainRVAdapter);
        rListHome.setLayoutManager(mGridLayoutManager);
//        SimpleItemDivider simpleItemDivider = new SimpleItemDivider(divider, 0, divider, 0);
        BottomOffsetDecoration simpleItemDivider = new BottomOffsetDecoration(0, divider, divider, 0, 100);
        rListHome.addItemDecoration(simpleItemDivider, 0);
//        mRvCategoryList.addItemDecoration(mGridDividerItemDecorationFixed);
//        mRvCategoryList.addItemDecoration(new GridBottomOffsetItemDecoration(divider, 2));
//        mRvCategoryList.setBackgroundColor(Color.TRANSPARENT);
        rListHome.addItemDecoration(new BottomOffsetDecoration(divider));
    }
    private void initRV2() {
        int divider;
        if (this != null) {
            divider = (int) this.getResources().getDimension(R.dimen.yellow);
        } else {
            divider = (int) DPConverter.convertDpToPx(1f);
        }
        mGridDividerItemDecorationFixed = mGridDividerItemDecorationFixedProvider.get();
        mMainRVAdapter = mMainRVAdapterProvider.get();
        mGridLayoutManager = mGridLayoutManagerProvider.get();
        mMainRVAdapter.submitList(homeList);
        rListHome.setAdapter(mMainRVAdapter);
        rListHome.setLayoutManager(mGridLayoutManager);
        BottomOffsetDecoration simpleItemDivider = new BottomOffsetDecoration(0, divider, divider, 0, 20);
        rListHome.addItemDecoration(simpleItemDivider, 0);
        rListHome.addItemDecoration(new BottomOffsetDecoration(divider));




//        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
//        layoutManager.setFlexDirection(FlexDirection.ROW);
//        layoutManager.setJustifyContent(JustifyContent.CENTER);
//        layoutManager.setAlignItems(AlignItems.STRETCH);
//        layoutManager.setFlexWrap(FlexWrap.WRAP);
//
//        rListHome.setLayoutManager(mGridLayoutManager);
//        SimpleItemDivider simpleItemDivider = new SimpleItemDivider(divider, 0, divider, 0);
//        mRvCategoryList.addItemDecoration(mGridDividerItemDecorationFixed);
//        mRvCategoryList.addItemDecoration(new GridBottomOffsetItemDecoration(divider, 2));
//        mRvCategoryList.setBackgroundColor(Color.TRANSPARENT);
    }


}
