package com.example.wallet.DataBase;



import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database
        (entities = {GelirGider.class, GelirGider2.class},exportSchema = false, version = 1  )
public abstract class Db extends RoomDatabase {
        private static final String DB_NAME = "DataBase";
        private static Db instance;

        public static synchronized Db getInstance(Context context){
             if(instance == null) {
        instance = Room.databaseBuilder(context.getApplicationContext(),Db.class,DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
                }
             return instance;
        }

public abstract GelirGiderDao gelirGiderDao();
}
