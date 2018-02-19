package com.example.trial.nearplaces.mvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class GooglePlacesResponseModel
{
    @SerializedName("results")
    private ArrayList<GooglePlacesResultModel> resultModelArrayList=new ArrayList<>();

    public ArrayList<GooglePlacesResultModel> getResultModelArrayList() {
        return resultModelArrayList;
    }

    public void setResultModelArrayList(ArrayList<GooglePlacesResultModel> resultModelArrayList) {
        this.resultModelArrayList = resultModelArrayList;
    }
}
