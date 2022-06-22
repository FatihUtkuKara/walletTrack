package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GiderActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<String> giderlerList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gider);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        giderlerList = new ArrayList<>();
        giderlerList.add("Beslenme");
        giderlerList.add("Eğlence");
        giderlerList.add("Spor");
        giderlerList.add("Eğitim");
        giderlerList.add("Ev");

        adapter = new Adapter(this,giderlerList);

        rv.setAdapter(adapter);

    }
}