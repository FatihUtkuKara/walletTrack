package com.example.wallet;

public class Giderler {
    private int tipId;
    private String tipAd;
    private String tipIcon;

    public Giderler(int tipId, String tipAd, String tipIcon) {
        this.tipId = tipId;
        this.tipAd = tipAd;
        this.tipIcon = tipIcon;
    }

    public int getTipId() {
        return tipId;
    }

    public String getTipAd() {
        return tipAd;
    }

    public String getTipIcon() {
        return tipIcon;
    }

    public void setTipId(int tipId) {
        this.tipId = tipId;
    }

    public void setTipAd(String tipAd) {
        this.tipAd = tipAd;
    }

    public void setTipIcon(String tipIcon) {
        this.tipIcon = tipIcon;
    }
}
