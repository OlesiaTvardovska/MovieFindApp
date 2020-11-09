package com.example.moviefind.models.TopImdb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImdbItemModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("chartRating")
    @Expose
    private Double chartRating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getChartRating() {
        return chartRating;
    }

    public void setChartRating(Double chartRating) {
        this.chartRating = chartRating;
    }

}