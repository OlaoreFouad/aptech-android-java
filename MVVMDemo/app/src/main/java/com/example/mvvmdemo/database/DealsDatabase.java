package com.example.mvvmdemo.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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

    public static DealsDatabase getInstance(final Application application) {

        if (INSTANCE == null) {
            synchronized (DealsDatabase.class) {
                INSTANCE = Room.databaseBuilder(application.getApplicationContext(), DealsDatabase.class, "deals_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);

                                Deal deal = new Deal("Deal 1", "Deal Description 1", "Ifeanyi", 1);
                                Deal deal2 = new Deal("Deal 2", "Deal Description 2", "Cat", 2);

                                new InsertAsyncTask(getInstance(application).getDealsDao()).execute(deal);
                                new InsertAsyncTask(getInstance(application).getDealsDao()).execute(deal2);
                            }

                            @Override
                            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                super.onOpen(db);
                            }
                        })
                        .build();
            }
        }

        return INSTANCE;
    }

    // TODO: teach how to add data upon database creation

}

class InsertAsyncTask extends AsyncTask<Deal, Void, Void> {

    private DealsDao dealsDao;

    public InsertAsyncTask(DealsDao dealsDao) {
        this.dealsDao = dealsDao;
    }

    @Override
    protected Void doInBackground(Deal... deals) {
        this.dealsDao.insertDeal(deals[0]);

        return null;
    }

}