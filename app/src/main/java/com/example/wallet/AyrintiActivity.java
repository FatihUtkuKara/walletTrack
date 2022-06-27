package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AyrintiActivity extends AppCompatActivity {
private RecyclerView rv2;
private ArrayList<Giderler> giderlerArrayList;
private GiderAdapter adapter;
private GelirViewModel tipModel;
int tipBakiye;
int giderBeslenme;
int giderEglence;
int giderEv;
int giderSpor;
int giderEgitim;
String giderTipi;
public TextView textViewGider;
public TextView textViewGelir;
int gelirBakiye;
int giderBakiye;
int toplamBakiye;
int oran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrinti);
        tipBakiye = 1;
        tipModel = new ViewModelProvider(this).get(GelirViewModel.class);
        textViewGelir = findViewById(R.id.textViewGelir);
        textViewGider = findViewById(R.id.textViewGider);

        rv2=findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);

        rv2.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        adapter = new GiderAdapter(this);

        rv2.setAdapter(adapter);


        tipModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                for (int i = 0; i < giders.size(); i++) {
                    giderBakiye = giderBakiye + giders.get(i).giderAmount;

                }
                textViewGider.setText("" + giderBakiye);
                adapter.setGiders(giders);
            }
        });

        tipModel.getGelirs(getApplicationContext()).observe(this, new Observer<List<Gelir>>() {
            @Override
            public void onChanged(List<Gelir> gelirs) {
                for (int i = 0; i < gelirs.size(); i++) {
                    gelirBakiye = gelirBakiye + gelirs.get(i).amount;

                }
                textViewGelir.setText("" + gelirBakiye);
            }
        });
    }
}