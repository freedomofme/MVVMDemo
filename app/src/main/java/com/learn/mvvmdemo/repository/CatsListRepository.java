package com.learn.mvvmdemo.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.learn.base.response.CatResponse;
import com.learn.base.service.DatabaseService;
import com.learn.mvvmdemo.api.CatsListService;
import com.learn.mvvmdemo.bean.CatBean;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsListRepository {
    CatsListService catsListService;
    DatabaseService databaseService;

    @Inject
    public CatsListRepository(CatsListService catsListService, DatabaseService databaseService) {
        this.catsListService = catsListService;
        this.databaseService = databaseService;
    }

    public void getCatsList(MutableLiveData<CatResponse<List<CatBean>>> catsBeanLiveData, int start, int limit) {
        catsListService.getCatsList(start, limit).enqueue(new Callback<List<CatBean>>() {

            @Override
            public void onResponse(@NonNull Call<List<CatBean>> call, @NonNull Response<List<CatBean>> response) {
                if (response.isSuccessful()) {
                    catsBeanLiveData.setValue(CatResponse.success(response.body()));
                } else {
                    catsBeanLiveData.setValue(CatResponse.error(response));
                }

                Log.d("dd", response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<CatBean>> call, @NonNull Throwable t) {
                catsBeanLiveData.setValue(CatResponse.error(t));
            }
        });
    }
}
