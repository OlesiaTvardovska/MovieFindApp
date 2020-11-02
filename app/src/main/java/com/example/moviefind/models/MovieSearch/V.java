package com.example.moviefind.models.MovieSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class V {

    @SerializedName("i")
    private Img i;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("s")
    @Expose
    private String s;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}