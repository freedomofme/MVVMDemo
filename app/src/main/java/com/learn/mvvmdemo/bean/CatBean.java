package com.learn.mvvmdemo.bean;

import com.google.gson.annotations.SerializedName;

public class CatBean {
    @SerializedName("id")
    String id;

    @SerializedName("image")
    CatImage catImage;

    @SerializedName("name")
    String name;

    @SerializedName("origin")
    String origin;

    @Override
    public String toString() {
        return "CatBean{" +
                "id='" + id + '\'' +
                ", catImage=" + catImage +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CatImage getCatImage() {
        return catImage;
    }

    public void setCatImage(CatImage catImage) {
        this.catImage = catImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
