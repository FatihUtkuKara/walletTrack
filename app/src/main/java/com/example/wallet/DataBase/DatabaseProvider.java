package com.example.wallet.DataBase;

import android.content.Context;
import android.service.wallpaper.WallpaperService;

import androidx.room.Room;

public class DatabaseProvider {
    private static WalletDatabase db;

    public static WalletDatabase getDatabase(Context context) {
        if(db == null) {
            db = Room.databaseBuilder(context,
                    WalletDatabase.class, "database-name").build();
        }
        return db;
    }
}
