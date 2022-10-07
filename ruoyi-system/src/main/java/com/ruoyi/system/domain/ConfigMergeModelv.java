package com.ruoyi.system.domain;

import java.io.Serializable;


public class ConfigMergeModelv implements Serializable {
    private String m;
    private String v;
    private ConfigMergeModelS ct;

    public ConfigMergeModelv() {
    }

    public ConfigMergeModelv(String m, String v, ConfigMergeModelS ct) {
        this.m = m;
        this.v = v;
        this.ct = ct;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public ConfigMergeModelS getCt() {
        return ct;
    }

    public void setCt(ConfigMergeModelS ct) {
        this.ct = ct;
    }

@Override
    public String toString() {
        return " v:{" +
                "ct:{" +
                "            fa\":\"General\",\n" +
                "            \"t\":\"g\"\n" +
                "        },"+
                "m='" + m + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
