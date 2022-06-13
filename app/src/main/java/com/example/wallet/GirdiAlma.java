package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GirdiAlma extends AppCompatActivity {
    public TextView textGider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girdi_alma);



    }
    public int giderAl() {textGider = findViewById(R.id.textGider);
        int gider= Integer.parseInt(textGider.getText().toString());
        return gider;
    }
    public void tamam2(View view) {
        Intent intent = new Intent(GirdiAlma.this,MainActivity.class);
        intent.putExtra("gidermiktar",giderAl());
        startActivity(intent);

}
}