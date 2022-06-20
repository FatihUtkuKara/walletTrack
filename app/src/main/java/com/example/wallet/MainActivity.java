package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wallet.DataBase.GelirActivity;
import com.example.wallet.DataBase.GelirGiderViewModel;

public class MainActivity extends AppCompatActivity {
   /* Fragment için
   FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.fragment,new Gelir());
        ft.commit();*/
    private GelirGiderViewModel viewModel;
    String bakiye;
    public TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(GelirGiderViewModel.class);

       // int gelenGelir =getIntent().getIntExtra("gelirmiktar",0);
       // int gelenGider =getIntent().getIntExtra("gidermiktar",0);

        bakiye = viewModel.getBakiye();
        text1 = findViewById(R.id.text1);
        text1.setText("Bakiyeniz:"+bakiye);

    }
    public void gelir(View view){
        Intent yeniIntent = new Intent(MainActivity.this, GelirActivity.class);
        startActivity(yeniIntent);

}
    public void gider(View view){
        Intent yeniIntent = new Intent(MainActivity.this,GiderActivity.class);
        startActivity(yeniIntent);

    }




}