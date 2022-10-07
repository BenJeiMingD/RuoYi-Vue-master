package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 填报派单对象 cy_deptsummary
 *
 * @author ruoyi
 * @date 2022-09-27
 */
public class CyDeptsummary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 派单编号 */
    private Integer id;

    /** 销售订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedon;

    /** 需求分类 */
    @Excel(name = "需求分类")
    private String demandname;

    /** 料号 */
    @Excel(name = "料号")
    private String code;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String plmname2;

    /** 番号 */
    @Excel(name = "番号")
    private String seibancode;

    /** 花纹 */
    @Excel(name = "花纹")
    private String plmname5;

    /** 商标 */
    @Excel(name = "商标")
    private String plmname3;

    /** 工艺 */
    @Excel(name = "工艺")
    private String descflexfieldPubdescseg32;

    /** 订单数量 */
    @Excel(name = "订单数量")
    private Integer shuliang;

    /** 累计排产量 */
    @Excel(name = "累计排产量")
    private Integer ljpc;

    /** 可排产量 */
    @Excel(name = "可排产量")
    private String t3;

    /** 销售需求 */
    @Excel(name = "销售需求")
    private Integer xq;

    /** 备注 */
    @Excel(name = "备注")
    private String mark;

    /** 夏季硫化定额 */
    @Excel(name = "夏季硫化定额")
    private String descflexfieldPrivatedescseg7;

    /** 模具总数量 */
    @Excel(name = "模具总数量")
    private String descflexfieldPrivatedescseg9;

    /** 模具号 */
    @Excel(name = "模具号")
    private String descflexfieldPrivatedescseg11;

    /** 填报派单编号 */
    @Excel(name = "填报派单编号")
    private Integer deptformId;

    /** 部门汇总子表编号 */
    @Excel(name = "部门汇总子表编号")
    private String deptsumziId;

    /** 合并汇总 */
    @Excel(name = "合并汇总")
    private Integer deptsumId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 销售行id */
    @Excel(name = "销售行id")
    private String saleslineId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 总产能 */
    @Excel(name = "总产能")
    private BigDecimal todayNumber;

    /** 个人需求 */
    @Excel(name = "个人需求")
    private Integer personalNeeds;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setModifiedon(Date modifiedon)
    {
        this.modifiedon = modifiedon;
    }

    public Date getModifiedon()
    {
        return modifiedon;
    }
    public void setDemandname(String demandname)
    {
        this.demandname = demandname;
    }

    public String getDemandname()
    {
        return demandname;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPlmname2(String plmname2)
    {
        this.plmname2 = plmname2;
    }

    public String getPlmname2()
    {
        return plmname2;
    }
    public void setSeibancode(String seibancode)
    {
        this.seibancode = seibancode;
    }

    public String getSeibancode()
    {
        return seibancode;
    }
    public void setPlmname5(String plmname5)
    {
        this.plmname5 = plmname5;
    }

    public String getPlmname5()
    {
        return plmname5;
    }
    public void setPlmname3(String plmname3)
    {
        this.plmname3 = plmname3;
    }

    public String getPlmname3()
    {
        return plmname3;
    }
    public void setDescflexfieldPubdescseg32(String descflexfieldPubdescseg32)
    {
        this.descflexfieldPubdescseg32 = descflexfieldPubdescseg32;
    }

    public String getDescflexfieldPubdescseg32()
    {
        return descflexfieldPubdescseg32;
    }
    public void setShuliang(Integer shuliang)
    {
        this.shuliang = shuliang;
    }

    public Integer getShuliang()
    {
        return shuliang;
    }
    public void setLjpc(Integer ljpc)
    {
        this.ljpc = ljpc;
    }

    public Integer getLjpc()
    {
        return ljpc;
    }
    public void setT3(String t3)
    {
        this.t3 = t3;
    }

    public String getT3()
    {
        return t3;
    }
    public void setXq(Integer xq)
    {
        this.xq = xq;
    }

    public Integer getXq()
    {
        return xq;
    }
    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getMark()
    {
        return mark;
    }
    public void setDescflexfieldPrivatedescseg7(String descflexfieldPrivatedescseg7)
    {
        this.descflexfieldPrivatedescseg7 = descflexfieldPrivatedescseg7;
    }

    public String getDescflexfieldPrivatedescseg7()
    {
        return descflexfieldPrivatedescseg7;
    }
    public void setDescflexfieldPrivatedescseg9(String descflexfieldPrivatedescseg9)
    {
        this.descflexfieldPrivatedescseg9 = descflexfieldPrivatedescseg9;
    }

    public String getDescflexfieldPrivatedescseg9()
    {
        return descflexfieldPrivatedescseg9;
    }
    public void setDescflexfieldPrivatedescseg11(String descflexfieldPrivatedescseg11)
    {
        this.descflexfieldPrivatedescseg11 = descflexfieldPrivatedescseg11;
    }

    public String getDescflexfieldPrivatedescseg11()
    {
        return descflexfieldPrivatedescseg11;
    }
    public void setDeptformId(Integer deptformId)
    {
        this.deptformId = deptformId;
    }

    public Integer getDeptformId()
    {
        return deptformId;
    }
    public void setDeptsumziId(String deptsumziId)
    {
        this.deptsumziId = deptsumziId;
    }

    public String getDeptsumziId()
    {
        return deptsumziId;
    }
    public void setDeptsumId(Integer deptsumId)
    {
        this.deptsumId = deptsumId;
    }

    public Integer getDeptsumId()
    {
        return deptsumId;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setSaleslineId(String saleslineId)
    {
        this.saleslineId = saleslineId;
    }

    public String getSaleslineId()
    {
        return saleslineId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setTodayNumber(BigDecimal todayNumber)
    {
        this.todayNumber = todayNumber;
    }

    public BigDecimal getTodayNumber()
    {
        return todayNumber;
    }
    public void setPersonalNeeds(Integer personalNeeds)
    {
        this.personalNeeds = personalNeeds;
    }

    public Integer getPersonalNeeds()
    {
        return personalNeeds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("modifiedon", getModifiedon())
                .append("demandname", getDemandname())
                .append("code", getCode())
                .append("name", getName())
                .append("plmname2", getPlmname2())
                .append("seibancode", getSeibancode())
                .append("plmname5", getPlmname5())
                .append("plmname3", getPlmname3())
                .append("descflexfieldPubdescseg32", getDescflexfieldPubdescseg32())
                .append("shuliang", getShuliang())
                .append("ljpc", getLjpc())
                .append("t3", getT3())
                .append("xq", getXq())
                .append("mark", getMark())
                .append("descflexfieldPrivatedescseg7", getDescflexfieldPrivatedescseg7())
                .append("descflexfieldPrivatedescseg9", getDescflexfieldPrivatedescseg9())
                .append("descflexfieldPrivatedescseg11", getDescflexfieldPrivatedescseg11())
                .append("deptformId", getDeptformId())
                .append("deptsumziId", getDeptsumziId())
                .append("deptsumId", getDeptsumId())
                .append("userId", getUserId())
                .append("saleslineId", getSaleslineId())
                .append("userName", getUserName())
                .append("todayNumber", getTodayNumber())
                .append("personalNeeds", getPersonalNeeds())
                .toString();
    }
}
