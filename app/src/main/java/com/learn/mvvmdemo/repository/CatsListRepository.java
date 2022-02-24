package com.learn.mvvmdemo.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learn.base.db.CatDao;
import com.learn.base.response.CatResponse;
import com.learn.base.worker.ExecutorService;
import com.learn.mvvmdemo.api.CatsListService;
import com.learn.base.bean.CatBean;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsListRepository {
    private final String TAG = "CatsListRepository";

    CatsListService catsListService;
    CatDao databaseService;

    @Inject
    public CatsListRepository(CatsListService catsListService, CatDao databaseService) {
        this.catsListService = catsListService;
        this.databaseService = databaseService;
    }

    public void getCatsList(MediatorLiveData<CatResponse<List<CatBean>>> catsBeanLiveData, int start, int limit) {
        LiveData<List<CatBean>> cats = databaseService.getAll();
        catsBeanLiveData.addSource(cats, new Observer<List<CatBean>>() {
            @Override
            public void onChanged(List<CatBean> catBeans) {
                Log.d(TAG, "cats in db:" + cats.getValue());
                catsBeanLiveData.removeSource(cats);
                catsBeanLiveData.setValue(CatResponse.success(catBeans));
            }
        });

        catsListService.getCatsList(start, limit).enqueue(new Callback<List<CatBean>>() {
            @Override
            public void onResponse(@NonNull Call<List<CatBean>> call, @NonNull Response<List<CatBean>> response) {
                if (response.isSuccessful()) {
                    catsBeanLiveData.setValue(CatResponse.success(response.body()));
                    ExecutorService.run(() -> {
                        databaseService.insert(response.body());
                    });
                } else {
                    catsBeanLiveData.setValue(CatResponse.error(response));
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<CatBean>> call, @NonNull Throwable t) {
                catsBeanLiveData.setValue(CatResponse.error(t));
            }
        });
    }
}
