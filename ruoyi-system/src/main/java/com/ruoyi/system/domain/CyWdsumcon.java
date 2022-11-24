package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 cy_wdsumcon
 *
 * @author ruoyi
 * @date 2022-11-23
 */
public class CyWdsumcon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  销售订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = " 销售订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedon;

    /**  需求分类 */
    @Excel(name = " 需求分类")
    private String demandname;

    /** 料号 */
    @Excel(name = "料号")
    private String code;

    /** PLM料号 */
    @Excel(name = "PLM料号")
    private String plmItemCode;

    /** 销售行id */
    @Excel(name = "销售行id")
    private String saleslineId;

    /** 生产组织 */
    @Excel(name = "生产组织")
    private String supplyorg;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 规格 */
    @Excel(name = "规格")
    private String plmname2;

    /** 番号 */
    @Excel(name = "番号")
    private String seibancode;

    /** 料品扩展字段 */
    @Excel(name = "料品扩展字段")
    private String ckzzd;

    /** 花纹 */
    @Excel(name = "花纹")
    private String plmname5;

    /** 商标 */
    @Excel(name = "商标")
    private String plmname3;

    /** TT/TL */
    @Excel(name = "TT/TL")
    private String plmname4;

    /** 配方 */
    @Excel(name = "配方")
    private String plmname6;

    /** TT/TL/配方 */
    @Excel(name = "TT/TL/配方")
    private String ctt;

    /** 工艺 */
    @Excel(name = "工艺")
    private String descflexfieldPubdescseg32;

    /** 订单数量 */
    @Excel(name = "订单数量")
    private String shuliang;

    /** 累计排产量 */
    @Excel(name = "累计排产量")
    private String ljpc;

    /** 可排产量 */
    @Excel(name = "可排产量")
    private String t3;

    /** 静态订单差数 */
    @Excel(name = "静态订单差数")
    private String t3ab3;

    /** 上期排产数 */
    @Excel(name = "上期排产数")
    private String bzpc;

    /** 累计到上周的完工数 */
    @Excel(name = "累计到上周的完工数")
    private String swan;

    /** 夏季硫化定额 */
    @Excel(name = "夏季硫化定额")
    private String descflexfieldPrivatedescseg7;

    /** 冬季硫化定额 */
    @Excel(name = "冬季硫化定额")
    private String cdj;

    /** 平均时间 */
    @Excel(name = "平均时间")
    private String descflexfieldPrivatedescseg13;

    /** 工艺代码 */
    @Excel(name = "工艺代码")
    private String gydm;

    /** 胎侧标识页码 */
    @Excel(name = "胎侧标识页码")
    private String tc;

    /** 排产要求 */
    @Excel(name = "排产要求")
    private String memo;

    /** 排产要求确认 */
    @Excel(name = "排产要求确认")
    private String dd;

    /** 模具总量 */
    @Excel(name = "模具总量")
    private String descflexfieldPrivatedescseg9;

    /** 模具投产 */
    @Excel(name = "模具投产")
    private String mj;

    /** 模具号 */
    @Excel(name = "模具号")
    private String mjh;

    /** 零头库存 */
    @Excel(name = "零头库存")
    private String ltkc;

    /** 早1 */
    @Excel(name = "早1")
    private String dayShift1;

    /** 晚1 */
    @Excel(name = "晚1")
    private String noonShift1;

    /** 早2 */
    @Excel(name = "早2")
    private String dayShift2;

    /** 晚2 */
    @Excel(name = "晚2")
    private String noonShift2;

    /** 早3 */
    @Excel(name = "早3")
    private String dayShift3;

    /** 晚3 */
    @Excel(name = "晚3")
    private String noonShift3;

    /** 早4 */
    @Excel(name = "早4")
    private String dayShift4;

    /** 晚4 */
    @Excel(name = "晚4")
    private String noonShift4;

    /** 早5 */
    @Excel(name = "早5")
    private String dayShift5;

    /** 晚5 */
    @Excel(name = "晚5")
    private String noonShift5;

    /** 早6 */
    @Excel(name = "早6")
    private String dayShift6;

    /** 晚6 */
    @Excel(name = "晚6")
    private String noonShift6;

    /** 早7 */
    @Excel(name = "早7")
    private String dayShift7;

    /** 晚7 */
    @Excel(name = "晚7")
    private String noonShift7;

    /** 本周生产计划量 */
    @Excel(name = "本周生产计划量")
    private String suman3;

    /** 新增排产 */
    @Excel(name = "新增排产")
    private String ap3;

    /** 是否有BOM */
    @Excel(name = "是否有BOM")
    private String iflen;

    /** 工艺标志 */
    @Excel(name = "工艺标志")
    private String gybz;

    /** 工艺要求 */
    @Excel(name = "工艺要求")
    private String gyyq;

    /** 主键 */
    private Long id;

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
    public void setPlmItemCode(String plmItemCode)
    {
        this.plmItemCode = plmItemCode;
    }

    public String getPlmItemCode()
    {
        return plmItemCode;
    }
    public void setSaleslineId(String saleslineId)
    {
        this.saleslineId = saleslineId;
    }

    public CyWdsumcon() {
    }

    public CyWdsumcon(Date modifiedon, String demandname, String code, String plmItemCode, String salesLineId, String supplyorg, String name, String plmname2, String seibancode, String ckzzd, String plmname5, String plmname3, String plmname4, String plmname6, String ctt, String descflexfieldPubdescseg32, String shuliang, String ljpc, String t3, String t3ab3, String bzpc, String swan, String descflexfieldPrivatedescseg7, String cdj, String descflexfieldPrivatedescseg13, String gydm, String tc, String memo, String dd, String descflexfieldPrivatedescseg9, String mj, String mjh, String ap3, String gybz, String gyyq) {
        this.modifiedon = modifiedon;
        this.demandname = demandname;
        this.code = code;
        this.plmItemCode = plmItemCode;
        this.saleslineId = salesLineId;
        this.supplyorg = supplyorg;
        this.name = name;
        this.plmname2 = plmname2;
        this.seibancode = seibancode;
        this.ckzzd = ckzzd;
        this.plmname5 = plmname5;
        this.plmname3 = plmname3;
        this.plmname4 = plmname4;
        this.plmname6 = plmname6;
        this.ctt = ctt;
        this.descflexfieldPubdescseg32 = descflexfieldPubdescseg32;
        this.shuliang = shuliang;
        this.ljpc = ljpc;
        this.t3 = t3;
        this.t3ab3 = t3ab3;
        this.bzpc = bzpc;
        this.swan = swan;
        this.descflexfieldPrivatedescseg7 = descflexfieldPrivatedescseg7;
        this.cdj = cdj;
        this.descflexfieldPrivatedescseg13 = descflexfieldPrivatedescseg13;
        this.gydm = gydm;
        this.tc = tc;
        this.memo = memo;
        this.dd = dd;
        this.descflexfieldPrivatedescseg9 = descflexfieldPrivatedescseg9;
        this.mj = mj;
        this.mjh = mjh;
        this.ap3 = ap3;
        this.gybz = gybz;
        this.gyyq = gyyq;
    }

    public String getSaleslineId()
    {
        return saleslineId;
    }
    public void setSupplyorg(String supplyorg)
    {
        this.supplyorg = supplyorg;
    }

    public String getSupplyorg()
    {
        return supplyorg;
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
    public void setCkzzd(String ckzzd)
    {
        this.ckzzd = ckzzd;
    }

    public String getCkzzd()
    {
        return ckzzd;
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
    public void setPlmname4(String plmname4)
    {
        this.plmname4 = plmname4;
    }

    public String getPlmname4()
    {
        return plmname4;
    }
    public void setPlmname6(String plmname6)
    {
        this.plmname6 = plmname6;
    }

    public String getPlmname6()
    {
        return plmname6;
    }
    public void setCtt(String ctt)
    {
        this.ctt = ctt;
    }

    public String getCtt()
    {
        return ctt;
    }
    public void setDescflexfieldPubdescseg32(String descflexfieldPubdescseg32)
    {
        this.descflexfieldPubdescseg32 = descflexfieldPubdescseg32;
    }

    public String getDescflexfieldPubdescseg32()
    {
        return descflexfieldPubdescseg32;
    }
    public void setShuliang(String shuliang)
    {
        this.shuliang = shuliang;
    }

    public String getShuliang()
    {
        return shuliang;
    }
    public void setLjpc(String ljpc)
    {
        this.ljpc = ljpc;
    }

    public String getLjpc()
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
    public void setT3ab3(String t3ab3)
    {
        this.t3ab3 = t3ab3;
    }

    public String getT3ab3()
    {
        return t3ab3;
    }
    public void setBzpc(String bzpc)
    {
        this.bzpc = bzpc;
    }

    public String getBzpc()
    {
        return bzpc;
    }
    public void setSwan(String swan)
    {
        this.swan = swan;
    }

    public String getSwan()
    {
        return swan;
    }
    public void setDescflexfieldPrivatedescseg7(String descflexfieldPrivatedescseg7)
    {
        this.descflexfieldPrivatedescseg7 = descflexfieldPrivatedescseg7;
    }

    public String getDescflexfieldPrivatedescseg7()
    {
        return descflexfieldPrivatedescseg7;
    }
    public void setCdj(String cdj)
    {
        this.cdj = cdj;
    }

    public String getCdj()
    {
        return cdj;
    }
    public void setDescflexfieldPrivatedescseg13(String descflexfieldPrivatedescseg13)
    {
        this.descflexfieldPrivatedescseg13 = descflexfieldPrivatedescseg13;
    }

    public String getDescflexfieldPrivatedescseg13()
    {
        return descflexfieldPrivatedescseg13;
    }
    public void setGydm(String gydm)
    {
        this.gydm = gydm;
    }

    public String getGydm()
    {
        return gydm;
    }
    public void setTc(String tc)
    {
        this.tc = tc;
    }

    public String getTc()
    {
        return tc;
    }
    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public String getMemo()
    {
        return memo;
    }
    public void setDd(String dd)
    {
        this.dd = dd;
    }

    public String getDd()
    {
        return dd;
    }
    public void setDescflexfieldPrivatedescseg9(String descflexfieldPrivatedescseg9)
    {
        this.descflexfieldPrivatedescseg9 = descflexfieldPrivatedescseg9;
    }

    public String getDescflexfieldPrivatedescseg9()
    {
        return descflexfieldPrivatedescseg9;
    }
    public void setMj(String mj)
    {
        this.mj = mj;
    }

    public String getMj()
    {
        return mj;
    }
    public void setMjh(String mjh)
    {
        this.mjh = mjh;
    }

    public String getMjh()
    {
        return mjh;
    }
    public void setLtkc(String ltkc)
    {
        this.ltkc = ltkc;
    }

    public String getLtkc()
    {
        return ltkc;
    }
    public void setDayShift1(String dayShift1)
    {
        this.dayShift1 = dayShift1;
    }

    public String getDayShift1()
    {
        return dayShift1;
    }
    public void setNoonShift1(String noonShift1)
    {
        this.noonShift1 = noonShift1;
    }

    public String getNoonShift1()
    {
        return noonShift1;
    }
    public void setDayShift2(String dayShift2)
    {
        this.dayShift2 = dayShift2;
    }

    public String getDayShift2()
    {
        return dayShift2;
    }
    public void setNoonShift2(String noonShift2)
    {
        this.noonShift2 = noonShift2;
    }

    public String getNoonShift2()
    {
        return noonShift2;
    }
    public void setDayShift3(String dayShift3)
    {
        this.dayShift3 = dayShift3;
    }

    public String getDayShift3()
    {
        return dayShift3;
    }
    public void setNoonShift3(String noonShift3)
    {
        this.noonShift3 = noonShift3;
    }

    public String getNoonShift3()
    {
        return noonShift3;
    }
    public void setDayShift4(String dayShift4)
    {
        this.dayShift4 = dayShift4;
    }

    public String getDayShift4()
    {
        return dayShift4;
    }
    public void setNoonShift4(String noonShift4)
    {
        this.noonShift4 = noonShift4;
    }

    public String getNoonShift4()
    {
        return noonShift4;
    }
    public void setDayShift5(String dayShift5)
    {
        this.dayShift5 = dayShift5;
    }

    public String getDayShift5()
    {
        return dayShift5;
    }
    public void setNoonShift5(String noonShift5)
    {
        this.noonShift5 = noonShift5;
    }

    public String getNoonShift5()
    {
        return noonShift5;
    }
    public void setDayShift6(String dayShift6)
    {
        this.dayShift6 = dayShift6;
    }

    public String getDayShift6()
    {
        return dayShift6;
    }
    public void setNoonShift6(String noonShift6)
    {
        this.noonShift6 = noonShift6;
    }

    public String getNoonShift6()
    {
        return noonShift6;
    }
    public void setDayShift7(String dayShift7)
    {
        this.dayShift7 = dayShift7;
    }

    public String getDayShift7()
    {
        return dayShift7;
    }
    public void setNoonShift7(String noonShift7)
    {
        this.noonShift7 = noonShift7;
    }

    public String getNoonShift7()
    {
        return noonShift7;
    }
    public void setSuman3(String suman3)
    {
        this.suman3 = suman3;
    }

    public String getSuman3()
    {
        return suman3;
    }
    public void setAp3(String ap3)
    {
        this.ap3 = ap3;
    }

    public String getAp3()
    {
        return ap3;
    }
    public void setIflen(String iflen)
    {
        this.iflen = iflen;
    }

    public String getIflen()
    {
        return iflen;
    }
    public void setGybz(String gybz)
    {
        this.gybz = gybz;
    }

    public String getGybz()
    {
        return gybz;
    }
    public void setGyyq(String gyyq)
    {
        this.gyyq = gyyq;
    }

    public String getGyyq()
    {
        return gyyq;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("modifiedon", getModifiedon())
                .append("demandname", getDemandname())
                .append("code", getCode())
                .append("plmItemCode", getPlmItemCode())
                .append("saleslineId", getSaleslineId())
                .append("supplyorg", getSupplyorg())
                .append("name", getName())
                .append("plmname2", getPlmname2())
                .append("seibancode", getSeibancode())
                .append("ckzzd", getCkzzd())
                .append("plmname5", getPlmname5())
                .append("plmname3", getPlmname3())
                .append("plmname4", getPlmname4())
                .append("plmname6", getPlmname6())
                .append("ctt", getCtt())
                .append("descflexfieldPubdescseg32", getDescflexfieldPubdescseg32())
                .append("shuliang", getShuliang())
                .append("ljpc", getLjpc())
                .append("t3", getT3())
                .append("t3ab3", getT3ab3())
                .append("bzpc", getBzpc())
                .append("swan", getSwan())
                .append("descflexfieldPrivatedescseg7", getDescflexfieldPrivatedescseg7())
                .append("cdj", getCdj())
                .append("descflexfieldPrivatedescseg13", getDescflexfieldPrivatedescseg13())
                .append("gydm", getGydm())
                .append("tc", getTc())
                .append("memo", getMemo())
                .append("dd", getDd())
                .append("descflexfieldPrivatedescseg9", getDescflexfieldPrivatedescseg9())
                .append("mj", getMj())
                .append("mjh", getMjh())
                .append("ltkc", getLtkc())
                .append("dayShift1", getDayShift1())
                .append("noonShift1", getNoonShift1())
                .append("dayShift2", getDayShift2())
                .append("noonShift2", getNoonShift2())
                .append("dayShift3", getDayShift3())
                .append("noonShift3", getNoonShift3())
                .append("dayShift4", getDayShift4())
                .append("noonShift4", getNoonShift4())
                .append("dayShift5", getDayShift5())
                .append("noonShift5", getNoonShift5())
                .append("dayShift6", getDayShift6())
                .append("noonShift6", getNoonShift6())
                .append("dayShift7", getDayShift7())
                .append("noonShift7", getNoonShift7())
                .append("suman3", getSuman3())
                .append("ap3", getAp3())
                .append("iflen", getIflen())
                .append("gybz", getGybz())
                .append("gyyq", getGyyq())
                .append("id", getId())
                .toString();
    }
}
