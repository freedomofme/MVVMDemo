package com.learn.mvvmdemo.activity.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.base.response.CatResponse;
import com.learn.mvvmdemo.bean.CatBean;
import com.learn.mvvmdemo.repository.CatsListRepository;

import java.util.List;

import javax.inject.Inject;

public class CatsListViewModel extends ViewModel {

    @Inject
    CatsListRepository catsListRepository;

    int startIndex = 0;
    int pageLimit = 20;

    private MutableLiveData<CatResponse<List<CatBean>>> _catsBeanLiveData;
    public LiveData<CatResponse<List<CatBean>>> catsBeanLiveData;

    public CatsListViewModel() {
        _catsBeanLiveData = new MutableLiveData<>();
        catsBeanLiveData = _catsBeanLiveData;
    }

    public void getCats() {
        catsListRepository.getCatsList(_catsBeanLiveData, startIndex, pageLimit);
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.

    }
}
