package com.learn.mvvmdemo.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.learn.base.service.DatabaseService;
import com.learn.mvvmdemo.api.CatsListService;
import com.learn.mvvmdemo.bean.CatsBean;

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

    public void getCatsList(MutableLiveData<List<CatsBean>> catsBeanLiveData) {
        catsListService.getCatsList(0, 10).enqueue(new Callback<List<CatsBean>>() {

            @Override
            public void onResponse(@NonNull Call<List<CatsBean>> call, @NonNull Response<List<CatsBean>> response) {
                catsBeanLiveData.setValue(response.body());
                Log.d("dd", response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<CatsBean>> call, @NonNull Throwable t) {

            }
        });
    }
}
