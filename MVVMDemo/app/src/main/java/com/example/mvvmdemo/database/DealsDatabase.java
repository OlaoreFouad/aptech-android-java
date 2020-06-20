package com.example.mvvmdemo.database;

import androidx.room.Database;

import com.example.mvvmdemo.dao.DealsDao;
import com.example.mvvmdemo.models.Deal;

@Database(
        entities = { Deal.class },
        version = 1,
        exportSchema = false
)
abstract class DealsDatabase {

    abstract DealsDao getDealsDao();

    // TODO: add the code to instantiate the database class
    // TODO: teach how to add data upon database creation

}
