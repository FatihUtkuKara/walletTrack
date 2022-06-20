package com.example.wallet.DataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "giderTable")
public class GelirGider2 {

    @PrimaryKey(autoGenerate = true)
    public int giderId;
    public int giderMiktar;

}
