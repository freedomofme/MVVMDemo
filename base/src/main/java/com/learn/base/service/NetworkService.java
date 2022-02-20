package com.learn.base.service;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class NetworkService implements INetWorkService {
    public Retrofit retrofit;

    @Inject
    public NetworkService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
