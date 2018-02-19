package com.example.trial.nearplaces.fragments.google;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trial.nearplaces.R;
import com.example.trial.nearplaces.base.BaseActivity;
import com.example.trial.nearplaces.databinding.FragmentGooglePlacesBinding;
import com.example.trial.nearplaces.di.components.DaggerCakeComponent;
import com.example.trial.nearplaces.di.module.GooglePlacesModule;
import com.example.trial.nearplaces.mvp.model.GooglePlacesResultModel;
import com.example.trial.nearplaces.mvp.presenter.GooglePlacesPresenter;
import com.example.trial.nearplaces.mvp.view.MainView;
import com.example.trial.nearplaces.utils.NetworkUtils;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by trial on 2/16/18.
 */

public class GooglePlacesFragment extends BaseActivity implements MainView
{
    private boolean isViewShown = false, isScreenVisibleToUser = false;
    @Inject
    protected GooglePlacesPresenter mPresenter;

    public GooglePlacesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentGooglePlacesBinding fragmentGooglePlacesBinding=DataBindingUtil.inflate(inflater,
                R.layout.fragment_google_places,container,false);


        if (isScreenVisibleToUser) {
            if (!isViewShown) {
                   loadPlaces();
            }
        }

        return fragmentGooglePlacesBinding.getRoot();
    }

    private void loadPlaces()
    {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .googlePlacesModule(new GooglePlacesModule(this))
                .build().inject(GooglePlacesFragment.this);
        if(NetworkUtils.isNetAvailable(getActivity()))
        {
            mPresenter.getGooglePlaces();
        }
        else
        {
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isScreenVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            if (getView() != null) {
                isViewShown = true;
                loadPlaces();
                Toast.makeText(getActivity(), "Google places called", Toast.LENGTH_SHORT).show();
                //api call

            } else {
                isViewShown = false;
            }
        }
    }

    @Override
    protected void resolveDaggerDependency() {

    }


    @Override
    public void onPlacesLoaded(ArrayList<GooglePlacesResultModel> googlePlaces) {
        //set to adapter
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
            hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        onShowToast(message);
    }
}
