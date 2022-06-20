package com.example.wallet.DataBase;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GelirGiderDao {

    @Query("Select * from gelirTable")
    List<GelirGider> getGelirList();
    @Query("select * from giderTable")
    List<GelirGider2>getGiderList();
    @Query("select * from gelirTable")
    LiveData<List<GelirGider>>finAllGelirGider();

    @Insert
    void InsertGelirGiders(GelirGider... gelirGiders);
    @Insert
    long InsertGelirGider(GelirGider GelirGider);
    @Insert
    void InsertGelirGider2(GelirGider... gelirGiders2);
    @Insert
    long InsertGelirGider2(GelirGider2 gelirGider2);


}
