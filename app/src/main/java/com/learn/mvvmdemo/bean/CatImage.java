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
}
