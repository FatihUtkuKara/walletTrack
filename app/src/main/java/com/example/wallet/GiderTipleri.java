package com.example.wallet;

import android.widget.ImageView;

public class GiderTipleri {
    public String getGiderAdı() {
        return giderAdı;
    }

    public void setFilmAdı(String giderAdı) {
        this.giderAdı = giderAdı;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String giderAdı;
    private String icon;

    public GiderTipleri(){

    }


    public GiderTipleri(String giderAdı, String icon) {
        this.giderAdı = giderAdı;
        this.icon = icon;
    }
}
