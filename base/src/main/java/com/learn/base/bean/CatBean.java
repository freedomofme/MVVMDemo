package com.learn.base.bean;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class CatBean {
    @PrimaryKey
    @SerializedName("id")
    @NonNull
    String id;

    @SerializedName("image")
    @Embedded
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
