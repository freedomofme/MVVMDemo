package com.learn.mvvmdemo.bean;

import com.google.gson.annotations.SerializedName;

public class CatsBean {
    @SerializedName("id")
    String id;

    @SerializedName("image")
    CatImage catImage;

    @SerializedName("name")
    String name;

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

    @Override
    public String toString() {
        return "CatsBean{" +
                "id='" + id + '\'' +
                ", catImage=" + catImage +
                ", name='" + name + '\'' +
                '}';
    }
}
