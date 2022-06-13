package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   /* Fragment için
   FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.fragment,new Gelir());
        ft.commit();*/
    int bakiye;
    public TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gelenGelir =getIntent().getIntExtra("gelirmiktar",0);
        int gelenGider =getIntent().getIntExtra("gidermiktar",0);

        bakiye = gelenGelir-gelenGider;
        text1 = findViewById(R.id.text1);
        text1.setText("Bakiyeniz:"+bakiye);

    }
    public void gelir(View view){
        Intent yeniIntent = new Intent(MainActivity.this,GelirActivity.class);
        startActivity(yeniIntent);

}
    public void gider(View view){
        Intent yeniIntent = new Intent(MainActivity.this,GiderActivity.class);
        startActivity(yeniIntent);

    }




}