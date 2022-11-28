package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 期数对象 deptqi
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public class Deptqi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Integer id;

    /** 转义 */
    private String username;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;
    /** 结束时间 */


    /** 时长 */
    @Excel(name = "时长")
    private BigDecimal duration;

    /** 年号 */
    @Excel(name = "年号")
    private Integer yearCode;

    /** 提单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ladingTime;

    public char getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(char deptOrder) {
        this.deptOrder = deptOrder;
    }

    /** 是否生成产能表 */
    @Excel(name = "是否生成产能表")
    private char deptOrder;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
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

    public Deptqi() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLadingTime(Date ladingTime)
    {
        this.ladingTime = ladingTime;
    }

    public Date getLadingTime()
    {
        return ladingTime;
    }

    @Override
    public String toString() {
        return "Deptqi{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", yearCode=" + yearCode +
                ", InsertOrder=" + deptOrder +
                ", issueNumber=" + issueNumber +
                ", ladingTime=" + ladingTime +
                '}';
    }
}
