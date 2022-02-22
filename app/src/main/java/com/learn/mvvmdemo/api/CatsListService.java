package com.learn.mvvmdemo.api;

import com.learn.mvvmdemo.bean.CatsBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatsListService {

    @GET("v1/breeds")
    Call<List<CatsBean>> getCatsList(
            @Query("page") int query,
            @Query("limit") int limit
    );
}
