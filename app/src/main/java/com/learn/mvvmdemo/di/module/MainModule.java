package com.learn.mvvmdemo.di.module;

import com.learn.base.service.NetworkService;
import com.learn.mvvmdemo.api.CatsListService;
import com.learn.mvvmdemo.di.scopes.MainScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @MainScope
    @Provides
    CatsListService provideCatsListApi(NetworkService networkService) {
        return networkService.create(CatsListService.class);
    }
}
