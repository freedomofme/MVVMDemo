package com.learn.mvvmdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.base.di.BaseComponentProvider;
import com.learn.base.di.component.BaseComponent;
import com.learn.base.di.component.DaggerBaseComponent;
import com.learn.base.di.module.AppModule;
import com.learn.base.di.module.DatabaseModule;
import com.learn.base.di.module.NetworkModule;

public class MyApplication extends Application implements BaseComponentProvider {
    BaseComponent baseComponent;

    @Override
    public BaseComponent provideBaseComponent() {
        return baseComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);


        initBaseComponent();
    }

    void initBaseComponent() {
        baseComponent = DaggerBaseComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .networkModule(new NetworkModule()).build();
        baseComponent.inject(this);
    }

}