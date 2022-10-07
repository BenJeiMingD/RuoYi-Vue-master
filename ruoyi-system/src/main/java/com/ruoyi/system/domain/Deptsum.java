package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合并汇总对象 cy_deptsum
 *
 * @author ruoyi
 * @date 2022-09-26
 */
public class Deptsum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Integer id;

    /** 汇总时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "汇总时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date summaryTime;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 汇总人 */
    @Excel(name = "汇总人")
    private String summaryBy;

    /** 是否汇总 */
    @Excel(name = "是否汇总")
    private Integer merge;

    /** 合并人 */
    @Excel(name = "合并人")
    private String mergeBy;

    /** 合并时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合并时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date mergeTime;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 汇总状态 */
    @Excel(name = "汇总状态")
    private String sumStatus;

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
    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }
    public void setSummaryBy(String summaryBy)
    {
        this.summaryBy = summaryBy;
    }

    public String getSummaryBy()
    {
        return summaryBy;
    }
    public void setMerge(Integer merge)
    {
        this.merge = merge;
    }

    public Integer getMerge()
    {
        return merge;
    }
    public void setMergeBy(String mergeBy)
    {
        this.mergeBy = mergeBy;
    }

    public String getMergeBy()
    {
        return mergeBy;
    }
    public void setMergeTime(Date mergeTime)
    {
        this.mergeTime = mergeTime;
    }

    public Date getMergeTime()
    {
        return mergeTime;
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
    public void setSumStatus(String sumStatus)
    {
        this.sumStatus = sumStatus;
    }

    public String getSumStatus()
    {
        return sumStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("summaryTime", getSummaryTime())
                .append("issueNumber", getIssueNumber())
                .append("summaryBy", getSummaryBy())
                .append("merge", getMerge())
                .append("mergeBy", getMergeBy())
                .append("mergeTime", getMergeTime())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("sumStatus", getSumStatus())
                .toString();
    }
}
