package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 deptinfomsg
 * 
 * @author ruoyi
 * @date 2022-08-18
 */
public class Deptinfomsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产能子表id */
    private Integer id;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 最大日产能 */
    @Excel(name = "最大日产能")
    private Integer todayNumber;

    /** 产能主表id */
    @Excel(name = "产能主表id")
    private Integer deptzhuId;

    /** 运算符号 */
    @Excel(name = "运算符号")
    private String symbol;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 时长 */
    @Excel(name = "时长")
    private BigDecimal duration;

    /** 年号 */
    @Excel(name = "年号")
    private Integer yearCode;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 成形方式 */
    @Excel(name = "成形方式")
    private String type;

    /** 总产能 */
    @Excel(name = "总产能")
    private Integer sumNumber;

    /** 期数id */
    @Excel(name = "期数id")
    private Integer deptqiId;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Deptinfomsg() {
    }

    public Integer getId()
    {
        return id;
    }
    public void setSize(Integer size)
    {
        this.size = size;
    }

    public Integer getSize()
    {
        return size;
    }
    public void setTodayNumber(Integer todayNumber)
    {
        this.todayNumber = todayNumber;
    }

    public Integer getTodayNumber()
    {
        return todayNumber;
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
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setDuration(BigDecimal duration) 
    {
        this.duration = duration;
    }

    public BigDecimal getDuration() 
    {
        return duration;
    }
    public void setYearCode(Integer yearCode)
    {
        this.yearCode = yearCode;
    }

    public Integer getYearCode()
    {
        return yearCode;
    }
    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSumNumber(Integer sumNumber)
    {
        this.sumNumber = sumNumber;
    }

    public Integer getSumNumber()
    {
        return sumNumber;
    }
    public void setDeptqiId(Integer deptqiId)
    {
        this.deptqiId = deptqiId;
    }

    public Integer getDeptqiId()
    {
        return deptqiId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("size", getSize())
            .append("todayNumber", getTodayNumber())
            .append("remark", getRemark())
            .append("deptzhuId", getDeptzhuId())
            .append("symbol", getSymbol())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("duration", getDuration())
            .append("yearCode", getYearCode())
            .append("issueNumber", getIssueNumber())
            .append("type", getType())
            .append("sumNumber", getSumNumber())
            .append("deptqiId", getDeptqiId())
            .toString();
    }
}
