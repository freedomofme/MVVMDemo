package com.learn.base.di.module;

import android.app.Application;

import androidx.room.Room;

import com.learn.base.Config;
import com.learn.base.db.CatDao;
import com.learn.base.db.CatDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Singleton
    @Provides
    CatDb provideDb(Application application) {
        return Room
                .databaseBuilder(application, CatDb.class, Config.CAT_DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    CatDao provideCatDao(CatDb db) {
        return db.catDao();
    }

//    @Provides
//    @Singleton
//    DatabaseService provideDatabaseService(CatDb db) {
//        return new DatabaseService();
//    }

}
