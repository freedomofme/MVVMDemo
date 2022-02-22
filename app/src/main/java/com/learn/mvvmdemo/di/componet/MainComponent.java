package com.learn.mvvmdemo.di.componet;

import com.learn.base.di.component.BaseComponent;
import com.learn.mvvmdemo.activity.main.viewmodel.CatsListViewModel;
import com.learn.mvvmdemo.di.module.MainModule;
import com.learn.mvvmdemo.di.scopes.MainScope;

import javax.inject.Singleton;

import dagger.Component;

@MainScope
@Component(dependencies = {BaseComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(CatsListViewModel catsListViewModel);
}