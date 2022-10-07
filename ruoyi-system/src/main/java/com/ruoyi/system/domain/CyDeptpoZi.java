package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成型方式分组信息子对象 cy_deptpo_zi
 *
 * @author ruoyi
 * @date 2022-09-19
 */
public class CyDeptpoZi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产能调整子表id */
    private Integer deptpoziId;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 最大日产能 */
    @Excel(name = "最大日产能")
    private BigDecimal todayNumber;

    /** 总产能 */
    @Excel(name = "总产能")
    private BigDecimal sumProductive;

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

    /** 包装类型 */
    @Excel(name = "包装类型")
    private String classification;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 产能子表id */
    @Excel(name = "产能子表id")
    private Integer deptziId;

    /** 天数 */
    @Excel(name = "天数")
    private BigDecimal duration;

    public void setDeptpoziId(Integer deptpoziId)
    {
        this.deptpoziId = deptpoziId;
    }

    public Integer getDeptpoziId()
    {
        return deptpoziId;
    }
    public void setSize(Integer size)
    {
        this.size = size;
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
    public void setSumProductive(BigDecimal sumProductive)
    {
        this.sumProductive = sumProductive;
    }

    public BigDecimal getSumProductive()
    {
        return sumProductive;
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
    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }
    public void setDeptziId(Integer deptziId)
    {
        this.deptziId = deptziId;
    }

    public Integer getDeptziId()
    {
        return deptziId;
    }
    public void setDuration(BigDecimal duration)
    {
        this.duration = duration;
    }

    public BigDecimal getDuration()
    {
        return duration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("deptpoziId", getDeptpoziId())
                .append("size", getSize())
                .append("todayNumber", getTodayNumber())
                .append("sumProductive", getSumProductive())
                .append("startTime", getStartTime())
                .append("type", getType())
                .append("remark", getRemark())
                .append("deptqiId", getDeptqiId())
                .append("deptzhuId", getDeptzhuId())
                .append("symbol", getSymbol())
                .append("classification", getClassification())
                .append("issueNumber", getIssueNumber())
                .append("deptziId", getDeptziId())
                .append("duration", getDuration())
                .toString();
    }
}
