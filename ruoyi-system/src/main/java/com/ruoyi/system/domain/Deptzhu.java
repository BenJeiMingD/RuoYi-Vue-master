package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 成型方式分组对象 cy_deptzhu
 *
 * @author ruoyi
 * @date 2022-09-01
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deptzhu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private List<Deptzi> deptzis;
    private List<Deptzhu> deptzhus;
    private HashMap<Deptzhu, Object> pernten;
    private List<Deptzi> children;
    /** 编号 */
    private Integer id;
    /** 格式编号 */
    private Integer deptzhuId;
    /** 成形方式 */
    @Excel(name = "成形方式")
    private String type;

    /** 总产能 */
    @Excel(name = "总产能")
    private BigDecimal todayNumber;

    /** 期数id */
    @Excel(name = "期数id")
    private Integer deptqiId;

    /** 包装类型 */
    @Excel(name = "包装类型")
    private String classification;

    /** 等级 */
    @Excel(name = "等级")
    private Integer level;

    /** 期号 */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 索引 */
    @Excel(name = "索引")
    private Integer indexId;

    /** 最大期产能 */
    @Excel(name = "最大期产能")
    private BigDecimal sumProductive;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setTodayNumber(BigDecimal todayNumber)
    {
        this.todayNumber = todayNumber;
    }

    public BigDecimal getTodayNumber()
    {
        return todayNumber;
    }
    public void setDeptqiId(Integer deptqiId)
    {
        this.deptqiId = deptqiId;
    }

    public Integer getDeptqiId()
    {
        return deptqiId;
    }
    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getClassification()
    {
        return classification;
    }

    public Integer getDeptzhuId() {
        return deptzhuId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public void setDeptzhuId(Integer deptzhuId) {
        this.deptzhuId = deptzhuId;
    }

    public BigDecimal getSumProductive() {
        return sumProductive;
    }

    public void setSumProductive(BigDecimal sumProductive) {
        this.sumProductive = sumProductive;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Deptzhu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", todayNumber=" + todayNumber +
                ", classification='" + classification +
                ", level=" + level +
                ", indexId='" + indexId +
                ", children='" + children +
                '\'' +
                '}';
    }
}
