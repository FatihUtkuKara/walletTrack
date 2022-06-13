package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GiderActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Giderler> giderTipiList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        Giderler g1 = new Giderler(1,"Beslenme","cutlery");
        Giderler g2 = new Giderler(2,"Eğlence","party");
        Giderler g3 = new Giderler(3,"Eğitim","mortarboard");
        Giderler g4 = new Giderler(4,"Ev","home");
        Giderler g5 = new Giderler(5,"Spor","running");

        giderTipiList = new ArrayList<>();

        giderTipiList.add(g1);
        giderTipiList.add(g2);
        giderTipiList.add(g3);
        giderTipiList.add(g4);
        giderTipiList.add(g5);

        adapter = new Adapter(this,giderTipiList);

        rv.setAdapter(adapter);
    }
}