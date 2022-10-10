package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成型方式分组信息子对象 cy_deptzi
 *
 * @author ruoyi
 * @date 2022-09-02
 */
public class Deptzi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产能子表id */
    private Integer deptId;

    private Integer[] deptzis;

    /** 等级 */
    @Excel(name = "等级")
    private Integer level;

    /** 等级 */
    @Excel(name = "子所属组索引")
    private Integer primaryRowId;

    /** 索引 */
    @Excel(name = "索引")
    private Integer indexId;

    /* children */
    private List<Deptzi> children;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 最大日产能 */
    @Excel(name = "最大日产能")
    private BigDecimal todayNumber;

    /** 总产能 */
    @Excel(name = "总产能")
    private BigDecimal sumNumber;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 成形方式 */
    @Excel(name = "成形方式")
    private String type;

    /** 期表id */
    @Excel(name = "期表id")
    private Integer deptqiId;

    /** 产能主表id */
    @Excel(name = "产能主表id")
    private Integer deptzhuId;

    /** 运算符号 */
    @Excel(name = "运算符号")
    private String symbol;

    public Deptzi() {
    }

    /** 包装类型 */
    @Excel(name = "包装类型")
    private String classification;

    public Integer getPrimaryRowId() {
        return primaryRowId;
    }

    public void setPrimaryRowId(Integer primaryRowId) {
        this.primaryRowId = primaryRowId;
    }

    public Integer[] getDeptzis() {
        return deptzis;
    }

    public void setDeptzis(Integer[] deptzis) {
        this.deptzis = deptzis;
    }

    public void setDeptId(Integer deptId)
    {
        this.deptId = deptId;
    }

    public Integer getDeptId()
    {
        return deptId;
    }
    public void setSize(Integer size)
    {
        this.size = size;
    }

    public Deptzi(List children) {
        this.children = children;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public Integer getSize()
    {
        return size;
    }
    public void setTodayNumber(BigDecimal todayNumber)
    {
        this.todayNumber = todayNumber;
    }

    public BigDecimal getTodayNumber()
    {
        return todayNumber;
    }
    public void setSumNumber(BigDecimal sumNumber)
    {
        this.sumNumber = sumNumber;
    }

    public BigDecimal getSumNumber()
    {
        return sumNumber;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setDeptqiId(Integer deptqiId)
    {
        this.deptqiId = deptqiId;
    }

    public Integer getDeptqiId()
    {
        return deptqiId;
    }
    public void setDeptzhuId(Integer deptzhuId)
    {
        this.deptzhuId = deptzhuId;
    }

    public Integer getDeptzhuId()
    {
        return deptzhuId;
    }
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }
    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getClassification()
    {
        return classification;
    }

    /*@Override
    public String toString() {
        return "Deptzi{" +
                "deptId=" + deptId +
                ", children=" + children +
                ", size=" + size +
                ", todayNumber=" + todayNumber +
                ", sumNumber=" + sumNumber +
                ", startTime=" + startTime +
                ", type='" + type + '\'' +
                ", deptqiId=" + deptqiId +
                ", deptzhuId=" + deptzhuId +
                ", symbol='" + symbol + '\'' +
                ", level=" + level +
                ", indexId='" + indexId +
                ", classification='" + classification + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Deptzi{" +
                "deptId=" + deptId +
                ", deptzis=" + Arrays.toString(deptzis) +
                ", level=" + level +
                ", primaryRowId=" + primaryRowId +
                ", indexId=" + indexId +
                ", children=" + children +
                ", size=" + size +
                ", todayNumber=" + todayNumber +
                ", sumNumber=" + sumNumber +
                ", startTime=" + startTime +
                ", type='" + type + '\'' +
                ", deptqiId=" + deptqiId +
                ", deptzhuId=" + deptzhuId +
                ", symbol='" + symbol + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}
