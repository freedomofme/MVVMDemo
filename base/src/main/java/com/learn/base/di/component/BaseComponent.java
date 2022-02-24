package com.learn.base.di.component;


import android.app.Application;


import com.learn.base.db.CatDao;
import com.learn.base.di.module.AppModule;
import com.learn.base.di.module.DatabaseModule;
import com.learn.base.di.module.NetworkModule;
import com.learn.base.service.NetworkService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, DatabaseModule.class})
public interface BaseComponent {

    void inject(Application app);

    NetworkService getNetworkService();

    CatDao getDatabaseService();

}