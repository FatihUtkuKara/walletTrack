package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wallet.model.Gelir;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   /* Fragment için
   FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.fragment,new Gelir());
        ft.commit();*/
    private GelirViewModel gelirViewModel;
    int bakiye;
    public TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gelirViewModel = new ViewModelProvider(this).get(GelirViewModel.class);

        text1 = findViewById(R.id.text1);

       // int gelenGelir =getIntent().getIntExtra("gelirmiktar",0);
       // int gelenGider =getIntent().getIntExtra("gidermiktar",0);

        gelirViewModel.getGelirs(getApplicationContext()).observe(this, new Observer<List<Gelir>>() {
            @Override
            public void onChanged(List<Gelir> gelirGiders) {
                for (int i = 0; i < gelirGiders.size(); i++) {
                    bakiye += gelirGiders.get(i).amount;
                }
                text1.setText("Bakiyeniz:"+ bakiye);
            }
        });

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