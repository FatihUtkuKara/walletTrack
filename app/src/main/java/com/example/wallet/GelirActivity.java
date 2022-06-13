package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GelirActivity extends AppCompatActivity {
        public TextView textGelir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);

    }
    public  int gelirAl(){
         textGelir = findViewById(R.id.textGelir);
         int gelir= Integer.parseInt(textGelir.getText().toString());
         return gelir;
    }

    public void tamam(View view) {
        Intent intent = new Intent(GelirActivity.this,MainActivity.class);
        intent.putExtra("gelirmiktar",gelirAl());
        startActivity(intent);
}
}