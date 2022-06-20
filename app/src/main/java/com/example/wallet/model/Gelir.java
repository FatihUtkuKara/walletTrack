package com.example.wallet.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gelirTable")
public class Gelir {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "amount")
    public int amount;
}
