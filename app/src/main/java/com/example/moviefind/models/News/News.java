package com.example.moviefind.models.News;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("webSearchUrl")
    @Expose
    private String webSearchUrl;
    @SerializedName("value")
    @Expose
    private List<Value> value = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebSearchUrl() {
        return webSearchUrl;
    }

    public void setWebSearchUrl(String webSearchUrl) {
        this.webSearchUrl = webSearchUrl;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

}