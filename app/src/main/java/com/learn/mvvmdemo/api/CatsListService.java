package com.learn.mvvmdemo.api;

import com.learn.base.bean.CatBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatsListService {

    @GET("v1/breeds")
    Call<List<CatBean>> getCatsList(
            @Query("page") int query,
            @Query("limit") int limit
    );
}
