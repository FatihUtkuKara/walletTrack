package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wallet.DataBase.DatabaseProvider;
import com.example.wallet.DataBase.WalletDatabase;
import com.example.wallet.model.Gelir;

public class GelirActivity extends AppCompatActivity {
        public EditText textGelir;
        Gelir gelir = new Gelir();
        public WalletDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);
        database = DatabaseProvider.getDatabase(getApplicationContext());
        textGelir = findViewById(R.id.textGelir);

        }

        public void geliriKaydet(String  gelir2) {
        gelir.amount = Integer.parseInt(gelir2);
        Thread dbThread = new Thread(new Runnable() {
            @Override
            public void run() {
                database.walletDao().insertGelir(gelir);
            }
        });

        dbThread.start();

        }

        public void tamam(View view) {

        geliriKaydet(textGelir.getText().toString());
        //Toast.makeText(this,database2.gelirGiderDao().getGelirList().,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(GelirActivity.this, MainActivity.class);
        startActivity(intent);
    }}