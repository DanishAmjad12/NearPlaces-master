/*
 * Copyright (c) 2016 Filippo Engidashet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.trial.nearplaces.mvp.presenter;

import android.util.Log;

import com.example.trial.nearplaces.api.APIService;
import com.example.trial.nearplaces.base.BasePresenter;
import com.example.trial.nearplaces.mvp.model.GooglePlacesResponseModel;
import com.example.trial.nearplaces.mvp.model.GooglePlacesResultModel;
import com.example.trial.nearplaces.mvp.view.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class GooglePlacesPresenter extends BasePresenter<MainView> {

    @Inject protected APIService mApiService;
    private Call<GooglePlacesResponseModel> googlePlacesResponseModelCall;


    @Inject
    public GooglePlacesPresenter() {
        Log.d(TAG, "GooglePlacesPresenter: ");
    }

    public void getGooglePlaces() {
        getView().onShowDialog("Loading Places....");
        googlePlacesResponseModelCall=mApiService.getGoogleNearbyPlaces("","",
                500);
        googlePlacesResponseModelCall.enqueue(new Callback<GooglePlacesResponseModel>() {
            @Override
            public void onResponse(Call<GooglePlacesResponseModel> call,
                                   Response<GooglePlacesResponseModel> response) {

                if(response.isSuccessful())
                {
                    getView().onHideDialog();
                    getView().onShowToast("Places Loaded");
                    ArrayList<GooglePlacesResultModel> googlePlaces =response.body().
                            getResultModelArrayList();
                    getView().onPlacesLoaded(googlePlaces);
                }

            }

            @Override
            public void onFailure(Call<GooglePlacesResponseModel> call, Throwable t) {
                getView().onHideDialog();
                getView().onShowToast("Error loading places " + t.getMessage());
            }
        });
    }
}
