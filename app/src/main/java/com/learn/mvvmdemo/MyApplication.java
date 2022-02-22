package com.learn.mvvmdemo;

import android.app.Application;

import com.learn.base.di.BaseComponentProvider;
import com.learn.base.di.component.BaseComponent;
import com.learn.base.di.component.DaggerBaseComponent;
import com.learn.base.di.module.BaseModule;

public class MyApplication extends Application implements BaseComponentProvider {
    BaseComponent baseComponent;

    @Override
    public BaseComponent provideBaseComponent() {
        return baseComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initBaseComponent();
    }

    void initBaseComponent() {
        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
        baseComponent.inject(this);
    }

}