package com.hillavas.toolbox.activity.listActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.rvdivider.SimpleItemDivider;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.adad.client.Adad;
import timber.log.Timber;

public class ListActivity extends BaseDaggerCompatActivity<ListActivityState, ListActivityViewModel> {

    public static final String NUMBER_OF_ROW_LIST = "number_of_row_list";

    public static final String NAME_LEVEL_ONE = "name_level_one";
    public static final String ROW_LEVEL_ONE = "row_level_one";
    public static final String ASPECT_LEVEL_ONE = "aspect_level_one";
    public static final String CATEGGORY_ID = "category_id";


    List<ItemHomeList> homeList = new ArrayList<>();
    List<ItemModel> _homeList = new ArrayList<>();

//    LinearLayoutManager mLinearLayoutManager;
    GridLayoutManager mGridLayoutManager;
//    StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    @Inject
    CompositeDisposable mDisposable;

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    Provider<ListRVAdapter> mMainRVAdapterProvider;

    @Inject
    Provider<List1RRVAdapter> mMain1RRVAdapterProvider;

    ListRVAdapter mMainRVAdapter;
    List1RRVAdapter mMain1RRVAdapter;
    @BindView(R.id.img_btn_login_main)
    AppCompatImageButton imgBtnLoginMain;
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

    private int numberRow = 0;
    private int categoryId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Adad.prepareInterstitialAd();

        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        createViewModel(ListActivityViewModel.class);

        Intent mIntent = getIntent();
        numberRow = mIntent.getIntExtra(NUMBER_OF_ROW_LIST,0);
        categoryId = mIntent.getIntExtra(CATEGGORY_ID ,0);


        mViewModel.getChildList(categoryId);
//        if (mIntent.getIntExtra(NUMBER_OF_ROW_LIST, 0)>0)
//         numberRow = mIntent.getIntExtra(NUMBER_OF_ROW_LIST, 0);
//        if (savedInstanceState!=null){
//            mViewModel.loadDataModel(true);
//        }else {
//            mViewModel.loadDataModel(false);
//        }

        startObserving();
//        initRV();



//        mViewModel.createList();

        ButterKnife.bind(this);

        Adad.enableBannerAds();
    }


    @Override
    public void handleState(ListActivityState state) {
        if (state.status == ListActivityState.STATUS_SUCCESS){
            homeList = state.list;
            initRV();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }


    public void initRV() {

        int divider = 0;
        mMainRVAdapter = mMainRVAdapterProvider.get();
        mMainRVAdapter.submitList(homeList);
        mMain1RRVAdapter = mMain1RRVAdapterProvider.get();
        mMain1RRVAdapter.submitList(homeList);
        mGridLayoutManager = new GridLayoutManager(this,numberRow);
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(numberRow,StaggeredGridLayoutManager.VERTICAL);
//        mLinearLayoutManager = new LinearLayoutManager(this);
        if (numberRow!=0)
            rListHome.setAdapter(mMain1RRVAdapter);
        else
        rListHome.setAdapter(mMainRVAdapter);
        rListHome.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mGridLayoutManager);
//        rListHome.setLayoutManager(mLinearLayoutManager);
        rListHome.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
        rListHome.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
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


}
