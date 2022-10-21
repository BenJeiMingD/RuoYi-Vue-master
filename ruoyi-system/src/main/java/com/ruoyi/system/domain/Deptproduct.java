package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料产能对照对象 cy_deptproduct
 *
 * @author ruoyi
 * @date 2022-10-18
 */
public class Deptproduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料产能对照表id */
    private Integer id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String code;

    /** 产能主表id */
    @Excel(name = "产能主表id")
    private Integer deptzhuId;

    /** 成型方式 */
    @Excel(name = "成型方式")
    private String type;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 万达历史数据code */
    @Excel(name = "万达历史数据code")
    private String cboItemmasterId;

    /** 产能子表id */
    @Excel(name = "产能子表id")
    private Integer deptziId;

    /** 产能调整表id */
    @Excel(name = "产能调整表id")
    private Integer deptpoId;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setDeptzhuId(Integer deptzhuId)
    {
        this.deptzhuId = deptzhuId;
    }

    public Integer getDeptzhuId()
    {
        return deptzhuId;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setSize(Integer size)
    {
        this.size = size;
    }

    public Integer getSize()
    {
        return size;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setCboItemmasterId(String cboItemmasterId)
    {
        this.cboItemmasterId = cboItemmasterId;
    }

    public String getCboItemmasterId()
    {
        return cboItemmasterId;
    }
    public void setDeptziId(Integer deptziId)
    {
        this.deptziId = deptziId;
    }

    public Integer getDeptziId()
    {
        return deptziId;
    }
    public void setDeptpoId(Integer deptpoId)
    {
        this.deptpoId = deptpoId;
    }

    public Integer getDeptpoId()
    {
        return deptpoId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("deptzhuId", getDeptzhuId())
                .append("type", getType())
                .append("size", getSize())
                .append("name", getName())
                .append("cboItemmasterId", getCboItemmasterId())
                .append("deptziId", getDeptziId())
                .append("deptpoId", getDeptpoId())
                .toString();
    }
}
