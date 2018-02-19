package com.example.trial.nearplaces.api;

import com.example.trial.nearplaces.mvp.model.GooglePlacesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by trial on 2/16/18.
 */

public interface APIService {

    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyDN7RJFmImYAca96elyZlE5s_fhX-MMuhk")
    Call<GooglePlacesResponseModel> getGoogleNearbyPlaces(@Query("type") String type,
                                                          @Query("location") String location,
                                                          @Query("radius") int radius);
}
