package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.wallet.DataBase.DatabaseProvider;
import com.example.wallet.DataBase.WalletDatabase;
import com.example.wallet.model.Gider;

public class GiderAl extends AppCompatActivity {
       public EditText textGider;
       Gider gider = new Gider();
       public WalletDatabase database2;
       String gelenTip;


     @Override
          protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_gider_al);
              textGider = findViewById(R.id.textGider);
              gelenTip = getIntent().getStringExtra("giderTip");
              database2 = DatabaseProvider.getDatabase(getApplicationContext());
          }

          public void gideriKaydet(String gider2, String giderTipi2){
         gider.giderAmount = Integer.parseInt(gider2);
         gider.giderTipi = giderTipi2;
         Thread dbbThread = new Thread(new Runnable() {
             @Override
             public void run() { database2.walletDao().insertGider(gider);}

             });

         dbbThread.start();
         }





         public void tamam2(View view) {
        gideriKaydet(textGider.getText().toString(),gelenTip);

        Intent intent = new Intent(GiderAl.this, MainActivity.class);
        startActivity(intent);

    }
}