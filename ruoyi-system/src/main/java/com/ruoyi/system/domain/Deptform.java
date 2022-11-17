package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 填报派单
 (派单确认)
 (填报派单)对象 cy_deptform
 *
 * @author ruoyi
 * @date 2022-09-22
 */
public class Deptform extends BaseEntity
{
    /*private static final long serialVersionUID = 1L;*/

    /** 派单id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userid;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** json表 */
    @Excel(name = "json表")
    private Integer jsonId;

    /** 期数id */
    @Excel(name = "期数id")
    private Integer deptqiId;

    /** 状态确认 */
    @Excel(name = "状态确认")
    private Integer state;

    /** 确认人 */
    @Excel(name = "确认人")
    private String confirmedBy;

    /** 确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmedTime;

    /** 是否插单 */
    @Excel(name = "是否插单")
    private Integer insertOrder;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

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
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public Integer getUserid()
    {
        return userid;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setJsonId(Integer jsonId)
    {
        this.jsonId = jsonId;
    }

    public Integer getJsonId()
    {
        return jsonId;
    }
    public void setDeptqiId(Integer deptqiId)
    {
        this.deptqiId = deptqiId;
    }

    public Integer getDeptqiId()
    {
        return deptqiId;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
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
    public void setInsertOrder(Integer insertOrder)
    {
        this.insertOrder = insertOrder;
    }

    public Integer getInsertOrder()
    {
        return insertOrder;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Deptform{" +
                "id=" + id +
                ", userid=" + userid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", jsonId=" + jsonId +
                ", deptqiId=" + deptqiId +
                ", state=" + state +
                ", confirmedBy='" + confirmedBy + '\'' +
                ", confirmedTime=" + confirmedTime +
                ", insertOrder='" + insertOrder + '\'' +
                ", userName='" + userName + '\'' +
                ", issueNumber=" + issueNumber +
                '}';
    }
}
