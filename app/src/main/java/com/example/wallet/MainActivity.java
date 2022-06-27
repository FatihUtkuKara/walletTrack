package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView text1;
    int bakiye;
    private GelirViewModel gelirViewModel;
    private GelirViewModel giderViewModel ;
    private int progr = 0 ;
    public ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gelirViewModel = new ViewModelProvider(this).get(GelirViewModel.class);
        giderViewModel = new ViewModelProvider(this).get(GelirViewModel.class);
        AyrintiActivity z = new AyrintiActivity();
        text1 = findViewById(R.id.text1);
        progressBar = findViewById(R.id.progress_bar);

        updateProgressBar(z.oran);

        giderViewModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                for (int i = 0; i < giders.size() ; i++){
                    bakiye = bakiye- giders.get(i).giderAmount;
                }
                text1.setText("Bakiyeniz:"+ bakiye);
            }
        });
        gelirViewModel.getGelirs(getApplicationContext()).observe(this, new Observer<List<Gelir>>() {
            @Override
            public void onChanged(List<Gelir> gelirGiders) {
                for (int i = 0; i < gelirGiders.size(); i++) {
                    bakiye += gelirGiders.get(i).amount;
                }
                text1.setText("Bakiyeniz:" + bakiye);
            }


        });


    }
    private void updateProgressBar(int oran){
        progressBar.setProgress(oran);


    }

    public void gelir(View view){
        Intent yeniIntent = new Intent(MainActivity.this, GelirActivity.class);
        startActivity(yeniIntent);

}
    public void gider(View view){
        Intent yeniIntent = new Intent(MainActivity.this,GiderActivity.class);
        startActivity(yeniIntent);

    }

    public void ayrinti(View view){
        Intent yeniIntent = new Intent(MainActivity.this,AyrintiActivity.class);
        startActivity(yeniIntent);

    }




}