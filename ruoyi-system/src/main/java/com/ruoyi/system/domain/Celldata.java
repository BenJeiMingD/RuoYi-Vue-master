package com.ruoyi.system.domain;

public class Celldata {
    //r、c是行列值，从（0，0）开始
    private String r;
    private String c;
    private V v = new V();

    public Celldata() {
    }

    public Celldata(String r, String c, String m,String v) {
        this.r = r;
        this.c = c;
        this.v.setM(m);
        this.v.setV(v);

    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }


}
