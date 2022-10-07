package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门汇总子对象 deptsumzi
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
public class Deptsumzi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门汇总子表id编号 */
    private Integer id;

    /** 汇总主表id编号 */
    @Excel(name = "汇总主表id编号")
    private Integer deptsumId;

    /** json字段 */
    @Excel(name = "json字段")
    private String jsonData;

    /** 派单人 */
    @Excel(name = "派单人")
    private String dispatcher;

    /** 确认人 */
    @Excel(name = "确认人")
    private String confirmedBy;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDeptsumId(Integer deptsumId)
    {
        this.deptsumId = deptsumId;
    }

    public Integer getDeptsumId()
    {
        return deptsumId;
    }
    public void setJsonData(String jsonData) 
    {
        this.jsonData = jsonData;
    }

    public String getJsonData() 
    {
        return jsonData;
    }
    public void setDispatcher(String dispatcher) 
    {
        this.dispatcher = dispatcher;
    }

    public String getDispatcher() 
    {
        return dispatcher;
    }
    public void setConfirmedBy(String confirmedBy) 
    {
        this.confirmedBy = confirmedBy;
    }

    public String getConfirmedBy() 
    {
        return confirmedBy;
    }

    public Deptsumzi() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptsumId", getDeptsumId())
            .append("jsonData", getJsonData())
            .append("dispatcher", getDispatcher())
            .append("confirmedBy", getConfirmedBy())
            .toString();
    }
}
