package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wallet.DataBase.DatabaseProvider;
import com.example.wallet.DataBase.WalletDatabase;
import com.example.wallet.model.Gelir;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.List;

public class GelirActivity extends AppCompatActivity {
        public EditText textGelir;
        Gelir gelir = new Gelir();
        public WalletDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);
        textGelir = findViewById(R.id.textGelir);
        database = DatabaseProvider.getDatabase(getApplicationContext());


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
            finish();
    }}