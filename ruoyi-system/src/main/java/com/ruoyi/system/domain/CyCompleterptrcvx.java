package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 cy_completerptrcvx
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class CyCompleterptrcvx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String rcvlotno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long seiban;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String seibancode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String code;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long item;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal qty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tddate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long docstate;

    public void setRcvlotno(String rcvlotno) 
    {
        this.rcvlotno = rcvlotno;
    }

    public String getRcvlotno() 
    {
        return rcvlotno;
    }
    public void setSeiban(Long seiban) 
    {
        this.seiban = seiban;
    }

    public Long getSeiban() 
    {
        return seiban;
    }
    public void setSeibancode(String seibancode) 
    {
        this.seibancode = seibancode;
    }

    public String getSeibancode() 
    {
        return seibancode;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setItem(Long item) 
    {
        this.item = item;
    }

    public Long getItem() 
    {
        return item;
    }
    public void setQty(BigDecimal qty) 
    {
        this.qty = qty;
    }

    public BigDecimal getQty() 
    {
        return qty;
    }
    public void setTddate(String tddate) 
    {
        this.tddate = tddate;
    }

    public String getTddate() 
    {
        return tddate;
    }
    public void setDocstate(Long docstate) 
    {
        this.docstate = docstate;
    }

    public Long getDocstate() 
    {
        return docstate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rcvlotno", getRcvlotno())
            .append("seiban", getSeiban())
            .append("seibancode", getSeibancode())
            .append("code", getCode())
            .append("item", getItem())
            .append("qty", getQty())
            .append("tddate", getTddate())
            .append("docstate", getDocstate())
            .toString();
    }
}
