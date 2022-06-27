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


        tipModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                    for (int i = 0 ; i < giders.size(); i++){
                        giderBakiye = giderBakiye+ giders.get(i).giderAmount;

            }
                    textViewGider.setText(""+giderBakiye);
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

        //Integer.parseInt(textViewGider.getText().toString());
        //toplamBakiye = Integer.parseInt(textViewGider.getText().toString())+Integer.parseInt(textViewGelir.getText().toString());
        //oran = Integer.parseInt(textViewGelir.getText().toString())/toplamBakiye;




        /* tipModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {


            @Override
            public void onChanged(List<Gider> giders) {
                for (int i = 0 ; i < giders.size(); i++){
                    tipBakiye = giders.get(i).giderAmount;

                    }
                g1.setTipBakiye(tipBakiye);
            }

        });


        tipModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                for (int i = 0; i < giders.size(); i++) {
                    giderTipi = giders.get(i).giderTipi;
                }

            }});


       // giderBeslenme =tipBakiye;


        if(giderTipi.equals("Eğlence")){
            giderEglence = giderEglence+tipBakiye;
        }

        else if( giderTipi.equals("Beslenme")){
            giderBeslenme = giderBeslenme+tipBakiye;
            }
        else if( giderTipi.equals("Ev")){
            giderEv = giderEv+tipBakiye;
        }
        else if( giderTipi.equals("Eğitim")){
            giderEgitim = giderEgitim+tipBakiye;
        }
        else if( giderTipi.equals("Spor")){
            giderSpor = giderSpor+tipBakiye;
        }
        */
        rv2=findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);

        rv2.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        Giderler g1 = new Giderler("Beslenme","salad",tipBakiye);
        Giderler g2 = new Giderler("Eğlence","laugh",tipBakiye);
        Giderler g3 = new Giderler("Spor","sports",tipBakiye);
        Giderler g4 = new Giderler("Eğitim","education",tipBakiye);
        Giderler g5 = new Giderler("Ev","house",tipBakiye);


        giderlerArrayList = new ArrayList<>();
        giderlerArrayList.add(g1);
        giderlerArrayList.add(g2);
        giderlerArrayList.add(g3);
        giderlerArrayList.add(g4);
        giderlerArrayList.add(g5);

        adapter = new GiderAdapter(this,giderlerArrayList);

        rv2.setAdapter(adapter);

    }



}