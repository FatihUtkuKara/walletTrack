package com.example.wallet.DataBase;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gelirTable")
public class GelirGider {
    @PrimaryKey(autoGenerate = true)
    public int gelirId;
    public int gelirMiktar;
}

