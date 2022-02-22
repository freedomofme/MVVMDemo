package com.learn.mvvmdemo.activity.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learn.mvvmdemo.bean.CatsBean;
import com.learn.mvvmdemo.repository.CatsListRepository;

import java.util.List;

import javax.inject.Inject;

public class CatsListViewModel extends ViewModel {

    @Inject
    CatsListRepository catsListRepository;

    private MutableLiveData<List<CatsBean>> catsBeanLiveData;

    public CatsListViewModel() {

    }

    public LiveData<List<CatsBean>> getCats() {
        if (catsBeanLiveData == null) {
            catsBeanLiveData = new MutableLiveData<>();
        }
        catsListRepository.getCatsList(catsBeanLiveData);
        return catsBeanLiveData;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.

    }
}
