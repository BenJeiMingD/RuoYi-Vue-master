package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 cy_skew
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class CySkew extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String demandcode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String itemCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String plmItemCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer dayShift;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer noonShift;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer nightShift;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fh;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long importno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long itemtype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String importyear;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String salesLineId;

    public String getSalesLineId() {
        return salesLineId;
    }

    public void setSalesLineId(String salesLineId) {
        this.salesLineId = salesLineId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDemandcode(String demandcode) 
    {
        this.demandcode = demandcode;
    }

    public String getDemandcode() 
    {
        return demandcode;
    }
    public void setItemCode(String itemCode) 
    {
        this.itemCode = itemCode;
    }

    public String getItemCode() 
    {
        return itemCode;
    }
    public void setPlmItemCode(String plmItemCode) 
    {
        this.plmItemCode = plmItemCode;
    }

    public String getPlmItemCode() 
    {
        return plmItemCode;
    }
    public void setDayShift(Integer dayShift)
    {
        this.dayShift = dayShift;
    }

    public Integer getDayShift()
    {
        return dayShift;
    }
    public void setNoonShift(Integer noonShift)
    {
        this.noonShift = noonShift;
    }

    public Integer getNoonShift()
    {
        return noonShift;
    }
    public void setNightShift(Integer nightShift)
    {
        this.nightShift = nightShift;
    }

    public Integer getNightShift()
    {
        return nightShift;
    }
    public void setFh(String fh) 
    {
        this.fh = fh;
    }

    public String getFh() 
    {
        return fh;
    }
    public void setImportno(Long importno) 
    {
        this.importno = importno;
    }

    public Long getImportno() 
    {
        return importno;
    }
    public void setItemtype(Long itemtype) 
    {
        this.itemtype = itemtype;
    }

    public Long getItemtype() 
    {
        return itemtype;
    }
    public void setImportyear(String importyear) 
    {
        this.importyear = importyear;
    }

    public String getImportyear() 
    {
        return importyear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("demandcode", getDemandcode())
            .append("itemCode", getItemCode())
            .append("plmItemCode", getPlmItemCode())
            .append("dayShift", getDayShift())
            .append("noonShift", getNoonShift())
            .append("nightShift", getNightShift())
            .append("fh", getFh())
            .append("importno", getImportno())
            .append("itemtype", getItemtype())
            .append("importyear", getImportyear())
            .toString();
    }
}
