package com.example.wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView text1;
    int totalGelir;
    int totalGider;
    private GelirViewModel gelirViewModel;
    private GelirViewModel giderViewModel ;
    private int progr = 0 ;
    public ProgressBar progressBar;
    private Button gider;
    private Button gelir;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        gelirViewModel = new ViewModelProvider(this).get(GelirViewModel.class);
        giderViewModel = new ViewModelProvider(this).get(GelirViewModel.class);
        text1 = findViewById(R.id.text1);
        gelir = findViewById(R.id.gelir1);
        gelir.setText(getString(R.string.income));
        gider =findViewById(R.id.gider);
        gider.setText(getString(R.string.expense));
        progressBar = findViewById(R.id.progress_bar);

        giderViewModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                totalGider = 0;
                for (int i = 0; i < giders.size() ; i++){
                    totalGider += giders.get(i).giderAmount;
                    updateProgressBar();
                }
                String explanation = getString(R.string.net_balance) + " " + (totalGelir-totalGider);
                text1.setText(explanation);
            }
        });
        gelirViewModel.getGelirs(getApplicationContext()).observe(this, new Observer<List<Gelir>>() {
            @Override
            public void onChanged(List<Gelir> gelirs) {
                totalGelir = 0 ;
                for (int i = 0; i < gelirs.size(); i++) {
                    totalGelir += gelirs.get(i).amount;
                    updateProgressBar();
                }
                String explanation = getString(R.string.net_balance) + " " + (totalGelir-totalGider);
                text1.setText(explanation);
            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_details:
                Intent yeniIntent = new Intent(MainActivity.this,AyrintiActivity.class);
                startActivity(yeniIntent);

                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    private void updateProgressBar(){
        int rate = (int) ((float) totalGider / (float) totalGelir * 100f);
        progressBar.setProgress(rate);
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