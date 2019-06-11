package com.hillavas.toolbox.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.base.BaseDaggerFragment;
import com.hillavas.toolbox.fragment.rvadapter.HomeRVAdapter;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseDaggerFragment<HomeFragmentState, HomeFragmentViewModel> {

    @Inject
    Provider<HomeRVAdapter> mHomeRVAdapterProvider;
    HomeRVAdapter mHomeRVAdapter;

    Unbinder unbinder;
    @BindView(R.id.rv_home_list)
    RecyclerView rvHomeList;
    @BindView(R.id.swipeToRefreshHomerFragment)
    SwipeRefreshLayout swipeToRefreshHomerFragment;

    @Override
    public void handleState(HomeFragmentState state) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        createViewModel(HomeFragmentViewModel.class);
        swipeToRefreshHomerFragment.setColorSchemeResources(R.color.colorAccent);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
