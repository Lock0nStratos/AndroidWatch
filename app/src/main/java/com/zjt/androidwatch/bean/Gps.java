package com.zjt.androidwatch.bean;

/**
 * Created by Y410P on 2018/1/9.
 */

public class Gps {
    private double wgLat;
    private double wgLon;

    public double getWgLat() {
        return wgLat;
    }

    public void setWgLat(double wgLat) {
        this.wgLat = wgLat;
    }

    public double getWgLon() {
        return wgLon;
    }

    public void setWgLon(double wgLon) {
        this.wgLon = wgLon;
    }

    public Gps(double wgLat, double wgLon){
        setWgLat(wgLat);
        setWgLon(wgLon);
    }
}
