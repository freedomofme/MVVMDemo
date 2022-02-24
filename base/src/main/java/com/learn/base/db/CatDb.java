
package com.learn.base.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.learn.base.bean.CatBean;

@Database(
    entities = {CatBean.class},
    version = 1,
    exportSchema = false
)
public abstract class CatDb extends RoomDatabase {

    public abstract CatDao catDao();

}
