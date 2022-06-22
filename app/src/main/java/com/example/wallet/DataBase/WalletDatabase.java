package com.example.wallet.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;

@Database
        (entities = {Gider.class,Gelir.class } ,version = 1)
public abstract class WalletDatabase extends RoomDatabase {
    public abstract WalletDao walletDao();

}

