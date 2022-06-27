package com.example.wallet.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "giderTable")
public class Gider {
    @PrimaryKey(autoGenerate = true)
    public int giderId;
    @ColumnInfo(name = "giderAmount")
    public int giderAmount;
    @ColumnInfo(name= "giderTipi")
    public String giderTipi;
}
