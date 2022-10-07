package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * config 中 merge 对象
 * @author Administrator
 */

public class ConfigMergeModel implements Serializable {
    /**
     * 行
     */
    private int r;
    /**
     * 列
     */
    private int c;
    /**
     * 内容
     */
   private ConfigMergeModelv v;

    public ConfigMergeModel() {
    }

    public ConfigMergeModel(int r, int c, ConfigMergeModelv v) {
        this.r = r;
        this.c = c;
        this.v = v;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public ConfigMergeModelv getV() {
        return v;
    }

    public void setV(ConfigMergeModelv v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "ConfigMergeModel{" +
                "r=" + r +
                ", c=" + c +
                ", " + v +
                '}';
    }
}
