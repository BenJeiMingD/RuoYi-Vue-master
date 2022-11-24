package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 base_organization_trl
 *
 * @author ruoyi
 * @date 2022-11-24
 */
public class BaseOrganizationTrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    private String sysmlflag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String descflexfieldCombinename;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSysmlflag(String sysmlflag)
    {
        this.sysmlflag = sysmlflag;
    }

    public String getSysmlflag()
    {
        return sysmlflag;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescflexfieldCombinename(String descflexfieldCombinename)
    {
        this.descflexfieldCombinename = descflexfieldCombinename;
    }

    public String getDescflexfieldCombinename()
    {
        return descflexfieldCombinename;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sysmlflag", getSysmlflag())
                .append("name", getName())
                .append("description", getDescription())
                .append("descflexfieldCombinename", getDescflexfieldCombinename())
                .toString();
    }
}
