package com.example.moviefind.models.News;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("provider")
    @Expose
    private List<Provider> provider = null;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("headline")
    @Expose
    private Boolean headline;
    @SerializedName("ampUrl")
    @Expose
    private String ampUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Provider> getProvider() {
        return provider;
    }

    public void setProvider(List<Provider> provider) {
        this.provider = provider;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getHeadline() {
        return headline;
    }

    public void setHeadline(Boolean headline) {
        this.headline = headline;
    }

    public String getAmpUrl() {
        return ampUrl;
    }

    public void setAmpUrl(String ampUrl) {
        this.ampUrl = ampUrl;
    }

}