package com.example.wallet.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.wallet.model.Gelir;

import java.util.List;

@Dao
public interface WalletDao {
    @Query("SELECT * FROM gelirTable")
    LiveData<List<Gelir>> getGelirs();

    @Insert
    void insertGelir(Gelir gelir);
}
