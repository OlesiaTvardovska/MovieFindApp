package com.example.moviefind.models.MovieDetails;


import android.widget.ImageView;

import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("runningTimeInMinutes")
    @Expose
    private Integer runningTimeInMinutes;
    @SerializedName("nextEpisode")
    @Expose
    private String nextEpisode;
    @SerializedName("numberOfEpisodes")
    @Expose
    private Integer numberOfEpisodes;
    @SerializedName("seriesEndYear")
    @Expose
    private Integer seriesEndYear;
    @SerializedName("seriesStartYear")
    @Expose
    private Integer seriesStartYear;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleType")
    @Expose
    private String titleType;
    @SerializedName("year")
    @Expose
    private Integer year;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }

    public void setRunningTimeInMinutes(Integer runningTimeInMinutes) {
        this.runningTimeInMinutes = runningTimeInMinutes;
    }

    public String getNextEpisode() {
        return nextEpisode;
    }

    public void setNextEpisode(String nextEpisode) {
        this.nextEpisode = nextEpisode;
    }

    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Integer getSeriesEndYear() {
        return seriesEndYear;
    }

    public void setSeriesEndYear(Integer seriesEndYear) {
        this.seriesEndYear = seriesEndYear;
    }

    public Integer getSeriesStartYear() {
        return seriesStartYear;
    }

    public void setSeriesStartYear(Integer seriesStartYear) {
        this.seriesStartYear = seriesStartYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}