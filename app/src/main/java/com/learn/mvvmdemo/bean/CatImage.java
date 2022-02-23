package com.learn.mvvmdemo.bean;

import com.google.gson.annotations.SerializedName;

public class CatImage {
    @SerializedName("height")
    double height;

    @SerializedName("width")
    double width;

    @SerializedName("id")
    String id;

    @SerializedName("url")
    String url;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
