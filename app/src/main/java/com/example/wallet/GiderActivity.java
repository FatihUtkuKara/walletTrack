package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GiderActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<GiderTipleri> giderlerList;
    private Adapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        String fun = getString(R.string.fun);
        String health = getString(R.string.health);
        String clothes = getString(R.string.clothes);
        String house = getString(R.string.house);
        String education = getString(R.string.education);
        String sport = getString(R.string.sport);
        String transport = getString(R.string.transport);
        String eating= getString(R.string.eating);

        GiderTipleri g5 = new GiderTipleri(clothes,"clothes");
        GiderTipleri g2 = new GiderTipleri(fun,"laugh");
        GiderTipleri g3 = new GiderTipleri(sport,"sports");
        GiderTipleri g4 = new GiderTipleri(education,"education");
        GiderTipleri g1 = new GiderTipleri(house,"house");
        GiderTipleri g6 = new GiderTipleri(health,"health");
        GiderTipleri g7 = new GiderTipleri(transport,"transport");
        GiderTipleri g8 = new GiderTipleri(eating,"salad");


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