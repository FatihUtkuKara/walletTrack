package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GiderActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<GiderTipleri> giderlerList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));


        GiderTipleri g1 = new GiderTipleri("Beslenme","salad");
        GiderTipleri g2 = new GiderTipleri("Eğlence","laugh");
        GiderTipleri g3 = new GiderTipleri("Spor","sports");
        GiderTipleri g4 = new GiderTipleri("Eğitim","education");
        GiderTipleri g5 = new GiderTipleri("Ev","house");
        GiderTipleri g6 = new GiderTipleri("Sağlık","health");
        GiderTipleri g7 = new GiderTipleri("Ulaşım","transport");
        GiderTipleri g8 = new GiderTipleri("Giyim","clothes");

        giderlerList = new ArrayList<>();
        giderlerList.add(g1);
        giderlerList.add(g2);
        giderlerList.add(g3);
        giderlerList.add(g4);
        giderlerList.add(g5);
        giderlerList.add(g6);
        giderlerList.add(g7);
        giderlerList.add(g8);


        adapter = new Adapter(this,giderlerList);

        rv.setAdapter(adapter);

    }
}