package com.hillavas.toolbox.activity.earthquake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.activity.content.ContentTipActivityState;
import com.hillavas.toolbox.base.BaseDaggerCompatActivity;
import com.hillavas.toolbox.rvdivider.SimpleItemDivider;
import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class EarthquakeActivity extends BaseDaggerCompatActivity<EarthquakeActivityState, EarthquakeActivityViewModel> {


    public static final String CATEGGORY_ID_CONTENTTIP = "category_id_contenttip";
    public static final String CONTENT_TYPE = "Content_Type";
    @BindView(R.id.r_list_home)
    RecyclerView rListEarthquake;

    private int categoryId = 0;
    private int contentType = 0;

    @Inject
    CompositeDisposable mDisposable;

    @Inject
    Provider<EarthquakeList1RVAdapter> mMainRVAdapterProvider;
    EarthquakeList1RVAdapter mContentRVAdapter;
    GridLayoutManager mGridLayoutManager;
    private List<EarthquakeItem> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent mIntent = getIntent();
        categoryId = mIntent.getIntExtra(CATEGGORY_ID_CONTENTTIP, 0);
        contentType = mIntent.getIntExtra(CONTENT_TYPE, 0);

        setContentView(R.layout.activity_earthquake);
        createViewModel(EarthquakeActivityViewModel.class);


        ButterKnife.bind(this);
        startObserving();
        mViewModel.getEarthquakeList(categoryId);
    }

    @Override
    public void handleState(EarthquakeActivityState state) {

        if (state.status == ContentTipActivityState.STATUS_SUCCESS){
            mList = state.list;
            if (mList.size() != 0) {
                initRV();
            }else {
                finish();
            }
        }

    }

    public void initRV() {


        int divider = 0;
        mContentRVAdapter = mMainRVAdapterProvider.get();
        mContentRVAdapter.submitList(mList);





        mGridLayoutManager = new GridLayoutManager(this, 1);



            mContentRVAdapter.submitList(mList);
            rListEarthquake.setAdapter(mContentRVAdapter);



        rListEarthquake.setLayoutManager(mGridLayoutManager);

        rListEarthquake.addItemDecoration(new SimpleItemDivider(divider, divider, 0, divider));
        rListEarthquake.addItemDecoration(new SimpleItemDivider(0, 0, divider, 0), 0);
        rListEarthquake.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
            //        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
//        rListHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                mViewModel.incrementPage();
            }
        });





    }
}
