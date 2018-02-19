package com.example.trial.nearplaces.mvp.model;

import com.google.gson.annotations.SerializedName;


public class GooglePlacesResultModel {

    @SerializedName("name")
    private String placeName;

    @SerializedName("vicinity")
    private String placeAddress;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }
}
