package com.example.moviefind.models.News;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

}
