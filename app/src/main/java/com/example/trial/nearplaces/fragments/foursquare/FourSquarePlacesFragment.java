package com.example.trial.nearplaces.fragments.foursquare;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trial.nearplaces.R;
import com.example.trial.nearplaces.databinding.FragmentFourSquarePlacesBinding;

/**
 * Created by trial on 2/16/18.
 */

public class FourSquarePlacesFragment extends Fragment
{

    private boolean isViewShown = false, isScreenVisibleToUser = false;

    public FourSquarePlacesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentFourSquarePlacesBinding fragmentFourSquarePlacesBinding = DataBindingUtil.
                inflate(inflater, R.layout.fragment_four_square_places, container,
                        false);

        if (isScreenVisibleToUser) {
            if (!isViewShown) {
                Toast.makeText(getActivity(), "Four-Square called", Toast.LENGTH_SHORT).show();
                // api call

            }
        }

        return fragmentFourSquarePlacesBinding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isScreenVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            if (getView() != null) {
                isViewShown = true;
                Toast.makeText(getActivity(), "Four-Square called", Toast.LENGTH_SHORT).show();
                //api call

            } else {
                isViewShown = false;
            }
        }
    }
}