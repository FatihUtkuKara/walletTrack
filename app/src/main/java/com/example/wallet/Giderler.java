package com.example.wallet;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Giderler {
    private String giderAdı;
    private String giderGörsel;
    private int tipBakiye;



    public Giderler() {
    }

    public String getGiderAdı() {
        return giderAdı;
    }

    public void setGiderAdı(String giderAdı) {
        this.giderAdı = giderAdı;
    }

    public String getGiderGörsel() {
        return giderGörsel;
    }

    public void setGiderGörsel(String giderGörsel) {
        this.giderGörsel = giderGörsel;
    }

    public int getTipBakiye() {
        return tipBakiye;
    }

    public void setTipBakiye(int tipBakiye) {
        this.tipBakiye = tipBakiye;
    }

    public Giderler(String giderAdı, String giderGörsel, int tipBakiye) {
        this.giderAdı = giderAdı;
        this.giderGörsel = giderGörsel;
        this.tipBakiye = tipBakiye;
    }
}
