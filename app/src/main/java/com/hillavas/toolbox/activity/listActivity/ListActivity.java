package com.hillavas.toolbox.activity.listActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.rvdivider.SimpleItemDivider;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;
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

import static com.hillavas.toolbox.consts.Const.MY_PREFS_NAME;

public class ListActivity extends BaseDaggerCompatActivity<ListActivityState, ListActivityViewModel> {

    public static final String NUMBER_OF_ROW_LIST = "number_of_row_list";

    public static final String NAME_LEVEL_ONE = "name_level_one";
    public static final String ROW_LEVEL_ONE = "row_level_one";
    public static final String ASPECT_LEVEL_ONE = "aspect_level_one";
    public static final String CATEGGORY_ID = "category_id";
    public static final String ATTACHMENT_TYPE = "AttachmentType";


    List<ItemHomeList> homeList = new ArrayList<>();
    List<ItemModel> _homeList = new ArrayList<>();
    SettingModel setting;

    //    LinearLayoutManager mLinearLayoutManager;
    GridLayoutManager mGridLayoutManager;



    private boolean refreshFlag = false;
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
    @BindView(R.id.swipeToRefreshListActivity)
    SwipeRefreshLayout swipeToRefreshListActivity;
    @BindView(R.id.img_btn_list_back)
    AppCompatImageButton imgBtnListBack;

    private int numberRow = 0;
    private int categoryId = 0;
    private double attachmentType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Fresco.initialize(this);
        setContentView(R.layout.activity_list);
        createViewModel(ListActivityViewModel.class);

        Intent mIntent = getIntent();
        numberRow = mIntent.getIntExtra(NUMBER_OF_ROW_LIST, 0);
        categoryId = mIntent.getIntExtra(CATEGGORY_ID, 0);
        attachmentType = mIntent.getDoubleExtra(ATTACHMENT_TYPE, 0);
        getPref();

        mViewModel.getChildList(categoryId);
        ButterKnife.bind(this);
//        if (mIntent.getIntExtra(NUMBER_OF_ROW_LIST, 0)>0)
//         numberRow = mIntent.getIntExtra(NUMBER_OF_ROW_LIST, 0);
//        if (savedInstanceState!=null){
//            mViewModel.loadDataModel(true);
//        }else {
//            mViewModel.loadDataModel(false);
//        }


        toolbar.setBackgroundColor(Color.parseColor(setting.AppMainColor()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(setting.AppBgColor()));
        }
        swipeToRefreshListActivity.setColorSchemeResources(R.color.colorAccent);
        startObserving();
//        initRV();

        swipeToRefreshListActivity.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if (!refreshFlag) {
                    refreshFlag = true;
                    mViewModel.getChildList(categoryId);
                }

            }
        });

//        mViewModel.createList();


    }


    @Override
    public void handleState(ListActivityState state) {
        if (state.status == ListActivityState.STATUS_SUCCESS) {

            if (refreshFlag) {
                refreshFlag = false;
                swipeToRefreshListActivity.setRefreshing(false);
            }
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

        if (homeList.get(0).Attachments().get(0).AttachmentType() != 0)
            attachmentType = homeList.get(0).Attachments().get(0).AttachmentType();
        int divider = 0;
        mMainRVAdapter = mMainRVAdapterProvider.get();
        mMainRVAdapter.submitList(homeList);
        mMain1RRVAdapter = mMain1RRVAdapterProvider.get();
        mMain1RRVAdapter.submitList(homeList);
        mGridLayoutManager = new GridLayoutManager(this, numberRow);
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(numberRow,StaggeredGridLayoutManager.VERTICAL);
//        mLinearLayoutManager = new LinearLayoutManager(this);
        if (attachmentType == 1)
            rListHome.setAdapter(mMain1RRVAdapter);
//        else if(attachmentType==3)
//            rListHome.setAdapter(mMainRVAdapter);
        else {
            mMainRVAdapter.submitList(homeList);
            rListHome.setAdapter(mMainRVAdapter);

        }

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


    public SettingModel getPref() {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String bgColor = prefs.getString("AppBgColor", null);
        String mainColor = prefs.getString("AppMainColor", null);
        setting =  SettingModel.createSetting(bgColor,mainColor,false,null,null,null);
        return setting;
    }



    @OnClick(R.id.img_btn_list_back)
    public void onViewClicked() {
        finish();
    }
}
