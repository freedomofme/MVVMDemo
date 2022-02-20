package com.learn.base.utils;

import android.content.Context;

import com.learn.base.di.BaseComponentProvider;
import com.learn.base.di.component.BaseComponent;

public class InjectUtils {
    public static BaseComponent provideBaseComponent(Context applicationContext){
        if (applicationContext instanceof BaseComponentProvider) {
            return ((BaseComponentProvider) applicationContext).provideBaseComponent();
        } else {
            throw new IllegalStateException("application context should implement BaseComponentProvider");
        }
    }
}
