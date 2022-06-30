package com.example.wallet;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Giderler implements Comparable<Giderler> {
    private String giderAdı;
    private String giderGörsel;
    private int tipBakiye;
    int yüzde;



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

    public int getYüzde() {
        return yüzde;
    }

    public void setYüzde(int yüzde) {
        this.yüzde = yüzde;
    }

    public Giderler(String giderAdı, String giderGörsel, int tipBakiye, int yüzde) {
        this.giderAdı = giderAdı;
        this.giderGörsel = giderGörsel;
        this.tipBakiye = tipBakiye;
        this.yüzde = yüzde;
    }

    @Override
    public int compareTo(Giderler o) {
        return new Integer(this.tipBakiye).compareTo(o.tipBakiye);
    }
}
