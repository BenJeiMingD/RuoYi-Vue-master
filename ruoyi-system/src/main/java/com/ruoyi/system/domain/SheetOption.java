package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.List;

public class SheetOption {
    private String name;   //工作表名称
    private String color;  //颜色
    private int status;     //状态
    private String index;      //索引
    private int hide;       //是否隐藏
    private List<Celldata> celldata = new ArrayList<Celldata>();      //数据

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public List<Celldata> getCelldata() {
        return celldata;
    }

    public void setCelldata(List<Celldata> celldata) {
        this.celldata = celldata;
    }

    @Override
    public String toString() {
        return "SheetOption{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", status=" + status +
                ", index=" + index +
                ", hide=" + hide +
                ", celldata=" + celldata +
                '}';
    }

}
