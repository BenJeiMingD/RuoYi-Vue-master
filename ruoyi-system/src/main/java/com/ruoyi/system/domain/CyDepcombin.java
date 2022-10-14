package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合并汇总对象 cy_depcombin
 *
 * @author ruoyi
 * @date 2022-10-13
 */
public class CyDepcombin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Integer id;

    /** 汇总时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "汇总时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date summaryTime;

    /** 汇总人 */
    @Excel(name = "汇总人")
    private String summaryBy;

    /** 是否汇总 */
    @Excel(name = "是否汇总")
    private Integer merger;

    /** 确认人 */
    @Excel(name = "确认人")
    private String confirmedBy;

    /** 确认日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确认日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmedTime;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

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
    public void setSummaryTime(Date summaryTime)
    {
        this.summaryTime = summaryTime;
    }

    public Date getSummaryTime()
    {
        return summaryTime;
    }
    public void setSummaryBy(String summaryBy)
    {
        this.summaryBy = summaryBy;
    }

    public String getSummaryBy()
    {
        return summaryBy;
    }
    public void setMerger(Integer merger)
    {
        this.merger = merger;
    }

    public Integer getMerger()
    {
        return merger;
    }
    public void setConfirmedBy(String confirmedBy)
    {
        this.confirmedBy = confirmedBy;
    }

    public String getConfirmedBy()
    {
        return confirmedBy;
    }
    public void setConfirmedTime(Date confirmedTime)
    {
        this.confirmedTime = confirmedTime;
    }

    public Date getConfirmedTime()
    {
        return confirmedTime;
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
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("summaryTime", getSummaryTime())
                .append("summaryBy", getSummaryBy())
                .append("merger", getMerger())
                .append("confirmedBy", getConfirmedBy())
                .append("confirmedTime", getConfirmedTime())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("state", getState())
                .append("issueNumber", getIssueNumber())
                .toString();
    }
}
