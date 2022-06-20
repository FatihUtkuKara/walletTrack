package com.example.wallet.DataBase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wallet.MainActivity;
import com.example.wallet.R;

public class GelirActivity extends AppCompatActivity {
        private GelirGiderViewModel viewModel;
        public EditText textGelir;
        GelirGider gelirrr = new GelirGider();
        public Db database2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);
        viewModel= new ViewModelProvider(this).get(GelirGiderViewModel.class);
        database2 =getDatabase();
        textGelir = findViewById(R.id.textGelir);

        }
        Db getDatabase(){
            return Room.databaseBuilder(getApplicationContext(), Db.class,"gelir-database")
                    .allowMainThreadQueries().build();
        }


        public void geliriKaydet(String  gelir2) {
        gelirrr.gelirMiktar = Integer.parseInt(gelir2);
        database2.gelirGiderDao().InsertGelirGider(gelirrr);

        }
        public int geliriİlet() {
            return gelirrr.gelirMiktar;
        }

        public void tamam(View view) {

        geliriKaydet(textGelir.getText().toString());
        //Toast.makeText(this,database2.gelirGiderDao().getGelirList().,Toast.LENGTH_SHORT).show();
        viewModel.gelirEkle();
        Intent intent = new Intent(GelirActivity.this, MainActivity.class);
        startActivity(intent);
    }}