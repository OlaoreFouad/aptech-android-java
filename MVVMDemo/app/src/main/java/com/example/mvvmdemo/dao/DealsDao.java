package com.example.mvvmdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmdemo.models.Deal;

import java.util.List;

@Dao
public interface DealsDao {

    @Insert
    void insertDeal(Deal deal);

    @Update
    void updateDeal(Deal deal);

    @Query("SELECT * FROM deals_table ORDER BY createdOn DESC")
    LiveData<List<Deal>> getDeals();

    @Delete
    void deleteDeal(Deal deal);

}
