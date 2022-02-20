package com.learn.base.di.component;


import android.app.Application;


import com.learn.base.di.module.BaseModule;
import com.learn.base.service.DatabaseService;
import com.learn.base.service.NetworkService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BaseModule.class})
public interface BaseComponent {

    void inject(Application app);

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

}