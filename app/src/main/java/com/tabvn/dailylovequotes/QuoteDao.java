package com.tabvn.dailylovequotes;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Quote... quotes);

    @Update
    void update(Quote quote);

    @Query("DELETE FROM quote")
    void deleteAll();

    @Query("SELECT * FROM quote where category = :category")
    LiveData<List<Quote>> getAllByCategory(String category);

    @Query("SELECT * FROM quote where category = :color")
    LiveData<List<Quote>> getAllByColor(String color);

}
