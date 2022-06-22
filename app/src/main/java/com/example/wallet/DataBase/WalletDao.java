package com.example.wallet.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;

import java.util.List;

@Dao
public interface WalletDao {
    @Query("SELECT * FROM gelirTable")
    LiveData<List<Gelir>> getGelirs();
    @Query("Select * From giderTable")
    LiveData<List<Gider>> getGiders();



    @Insert
    void insertGelir(Gelir gelir);
    @Insert
    void insertGider(Gider gider);
}
