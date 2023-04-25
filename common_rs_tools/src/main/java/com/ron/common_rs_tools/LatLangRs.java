package com.ron.common_rs_tools;

public class LatLangRs {

    private double lat;
    private double lang;

    public LatLangRs(double lat, double lang) {
        this.lat = lat;
        this.lang = lang;
    }

    public LatLangRs() {
    }

    public double getLat() {
        return lat;
    }

    public LatLangRs setLat(float lat) {
        this.lat = lat;
        return this;
    }

    public double getLang() {
        return lang;
    }

    public LatLangRs setLang(float lang) {
        this.lang = lang;
        return this;
    }

    @Override
    public String toString() {
        return "LatLangRs{" +
                "lat=" + lat +
                ", lang=" + lang +
                '}';
    }
}
