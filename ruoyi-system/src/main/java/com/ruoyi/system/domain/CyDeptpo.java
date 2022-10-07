package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产能调整对象 cy_deptpo
 *
 * @author ruoyi
 * @date 2022-09-30
 */
public class CyDeptpo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 组序号 */
    @Excel(name = "组序号")
    private Integer deptzhuId;

    /** 子序号 */
    @Excel(name = "子序号")
    private Integer deptziId;

    /** 成型方式 */
    @Excel(name = "成型方式")
    private String type;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 日产能 */
    @Excel(name = "日产能")
    private BigDecimal todayNumber;

    /** 最大产能 */
    @Excel(name = "最大产能")
    private BigDecimal sumProductive;

    /** 期表id */
    @Excel(name = "期表id")
    private Integer deptqiId;

    /** 产能调整表id */
    private Integer deptpoId;

    /** 天数 */
    @Excel(name = "天数")
    private BigDecimal duration;

    /** 类型 */
    @Excel(name = "类型")
    private String classification;

    /** 下标 */
    @Excel(name = "下标")
    private Integer indexId;

    /** 等级 */
    @Excel(name = "等级")
    private Integer level;

    /** 组的本期最大产能 */
    @Excel(name = "组的本期最大产能")
    private BigDecimal sumZhu;

    public void setIssueNumber(Integer issueNumber)
    {
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber()
    {
        return issueNumber;
    }
    public void setDeptzhuId(Integer deptzhuId)
    {
        this.deptzhuId = deptzhuId;
    }

    public Integer getDeptzhuId()
    {
        return deptzhuId;
    }
    public void setDeptziId(Integer deptziId)
    {
        this.deptziId = deptziId;
    }

    public Integer getDeptziId()
    {
        return deptziId;
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
    public void setDeptqiId(Integer deptqiId)
    {
        this.deptqiId = deptqiId;
    }

    public Integer getDeptqiId()
    {
        return deptqiId;
    }
    public void setDeptpoId(Integer deptpoId)
    {
        this.deptpoId = deptpoId;
    }

    public Integer getDeptpoId()
    {
        return deptpoId;
    }
    public void setDuration(BigDecimal duration)
    {
        this.duration = duration;
    }

    public BigDecimal getDuration()
    {
        return duration;
    }
    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getClassification()
    {
        return classification;
    }
    public void setIndexId(Integer indexId)
    {
        this.indexId = indexId;
    }

    public Integer getIndexId()
    {
        return indexId;
    }
    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public Integer getLevel()
    {
        return level;
    }
    public void setSumZhu(BigDecimal sumZhu)
    {
        this.sumZhu = sumZhu;
    }

    public BigDecimal getSumZhu()
    {
        return sumZhu;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("issueNumber", getIssueNumber())
                .append("deptzhuId", getDeptzhuId())
                .append("deptziId", getDeptziId())
                .append("type", getType())
                .append("size", getSize())
                .append("todayNumber", getTodayNumber())
                .append("sumProductive", getSumProductive())
                .append("deptqiId", getDeptqiId())
                .append("deptpoId", getDeptpoId())
                .append("duration", getDuration())
                .append("classification", getClassification())
                .append("indexId", getIndexId())
                .append("level", getLevel())
                .append("sumZhu", getSumZhu())
                .toString();
    }
}
