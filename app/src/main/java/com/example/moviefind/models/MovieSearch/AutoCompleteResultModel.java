package com.example.moviefind.models.MovieSearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutoCompleteResultModel {

    @SerializedName("d")
    @Expose
    private List<AutoCompItem> autoCompItem = null;
    @SerializedName("q")
    private String q;
    @SerializedName("v")
    private Integer v;

    public List<AutoCompItem> getAutoCompItem() {
        return autoCompItem;
    }

    public void setAutoCompItem(List<AutoCompItem> autoCompItem) {
        this.autoCompItem = autoCompItem;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}