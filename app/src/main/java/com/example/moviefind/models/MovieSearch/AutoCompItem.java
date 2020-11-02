package com.example.moviefind.models.MovieSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AutoCompItem {

    @SerializedName("i")
    private Img img;
    @SerializedName("id")
    private String id;
    @SerializedName("l")
    @Expose
    private String l;
    @SerializedName("q")
    private String q;
    @SerializedName("rank")
    private Integer rank;
    @SerializedName("s")
    private String s;
    @SerializedName("v")
    private List<V> v = null;
    @SerializedName("vt")
    private Integer vt;
    @SerializedName("y")
    private Integer y;
    @SerializedName("yr")
    private String yr;

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

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public List<V> getV() {
        return v;
    }

    public void setV(List<V> v) {
        this.v = v;
    }

    public Integer getVt() {
        return vt;
    }

    public void setVt(Integer vt) {
        this.vt = vt;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

}