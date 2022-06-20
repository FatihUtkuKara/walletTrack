package com.example.wallet.DataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wallet.DataBase.Db;
import com.example.wallet.DataBase.GelirGider2;
import com.example.wallet.R;


public class GirdiAlma extends AppCompatActivity {
    public TextView textGider;
    public Db database;
    long rowid;
    GelirGider2 giderrr = new GelirGider2();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girdi_alma);
        textGider = findViewById(R.id.textGider);
        database = getDatabase();

    }
    Db getDatabase(){
        return Room.databaseBuilder(getApplicationContext(),Db.class,"gider-database")
                .allowMainThreadQueries().build();
    }



    public void gideriKaydet(String  gider2) {
        giderrr.giderMiktar = Integer.parseInt(gider2);
        database.gelirGiderDao().InsertGelirGider2(giderrr);


    }

    public void tamam2(View view) {
        gideriKaydet(textGider.getText().toString());

      //  Intent intent = new Intent(GirdiAlma.this,MainActivity.class);
      //  startActivity(intent);

}}
