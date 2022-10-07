package com.ruoyi.system.domain;

import java.io.Serializable;


public class ConfigMergeModelS implements Serializable {
    private String fa ;
    private String t ;

    public ConfigMergeModelS() {
    }

    public ConfigMergeModelS(String fa, String t) {
        this.fa = fa;
        this.t = t;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ct{" +
                "fa='" + fa + '\'' +
                ", t='" + t + '\'' +
                '}';
    }
}

