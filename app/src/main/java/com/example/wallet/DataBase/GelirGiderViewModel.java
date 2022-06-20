package com.example.wallet.DataBase;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;

public class GelirGiderViewModel extends ViewModel {

    GelirActivity nesne =new GelirActivity();
    GirdiAlma nesne2 = new GirdiAlma();
    private String bakiye = "0";


    public String getBakiye() {

        return bakiye;
    }
    public void gelirEkle(){
        int gelir = nesne.gelirrr.gelirMiktar;
        int bakiyeInt= Integer.parseInt(bakiye);
        bakiye = String.valueOf(gelir+bakiyeInt);


    }
    public void giderEkle(){

        int gider = nesne2.giderrr.giderMiktar;
        bakiye = bakiye + gider ;

    }










}
