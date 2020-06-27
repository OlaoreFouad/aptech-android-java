package com.example.mvvmdemo.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmdemo.dao.DealsDao;
import com.example.mvvmdemo.models.Deal;

@Database(
        entities = { Deal.class },
        version = 1,
        exportSchema = false
)
public abstract class DealsDatabase extends RoomDatabase {

    private static DealsDatabase INSTANCE;
    public abstract DealsDao getDealsDao();

    public static DealsDatabase getInstance(Application application) {

        if (INSTANCE == null) {
            synchronized (DealsDatabase.class) {
                INSTANCE = Room.databaseBuilder(application.getApplicationContext(), DealsDatabase.class, "deals_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }

    // TODO: teach how to add data upon database creation

}
