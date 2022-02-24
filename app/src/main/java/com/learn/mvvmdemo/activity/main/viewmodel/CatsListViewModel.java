package com.learn.mvvmdemo.activity.main.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.base.response.CatResponse;
import com.learn.base.bean.CatBean;
import com.learn.mvvmdemo.repository.CatsListRepository;

import java.util.List;

import javax.inject.Inject;

public class CatsListViewModel extends ViewModel {

    @Inject
    CatsListRepository catsListRepository;

    int startIndex = 0;
    int pageLimit = 20;

    private MediatorLiveData<CatResponse<List<CatBean>>> _catsBeanLiveData;
    public LiveData<CatResponse<List<CatBean>>> catsBeanLiveData;

    public CatsListViewModel() {
        _catsBeanLiveData = new MediatorLiveData<>();
        catsBeanLiveData = _catsBeanLiveData;
    }

    public void getCats() {
        catsListRepository.getCatsList(_catsBeanLiveData, startIndex, pageLimit);
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.

    }
}
