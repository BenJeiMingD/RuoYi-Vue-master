package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 查询对象 cy_wdsumcon
 *
 * @author Life
 * @date 2022-11-11
 */
public class CyWdsumcon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批次号 */
    @Excel(name = "批次号")
    private String plancode;

    /**  销售订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = " 销售订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedon;

    /** 单号 */
    @Excel(name = "单号")
    private String docno;

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
    private String saleslineid;

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

    /** 累计释放数量 */
    @Excel(name = "累计释放数量")
    private String ljsf;

    /** 可释放量 */
    @Excel(name = "可释放量")
    private String t3u3;

    /** 累计排产量 */
    @Excel(name = "累计排产量")
    private String ljpc;

    /** 实际排产量 */
    @Excel(name = "实际排产量")
    private String y3ap3av3;

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
    private String cxj;

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
    private String cmj;

    /** 模具投产 */
    @Excel(name = "模具投产")
    private String mj;

    /** 模具号 */
    @Excel(name = "模具号")
    private String mjh;

    /** 零头库存 */
    @Excel(name = "零头库存")
    private String ltkc;

    /** 早 */
    @Excel(name = "早")
    private String dayShift;

    /** 晚 */
    @Excel(name = "晚")
    private String noonShift;

    /** 本周生产计划量 */
    @Excel(name = "本周生产计划量")
    private String suman3;

    /** 差异量 */
    @Excel(name = "差异量")
    private String ap3y3;

    /** 实际释放量 */
    @Excel(name = "实际释放量")
    private String qtys;

    /** 累计在制数量 */
    @Excel(name = "累计在制数量")
    private String u3;

    /** 新增排产 */
    @Excel(name = "新增排产")
    private String ap3;

    /** 剩余排产 */
    @Excel(name = "剩余排产")
    private String t3w3;

    /** 上周排产数 */
    @Excel(name = "上周排产数")
    private String lastWeek;

    /** 填报日期 */
    @Excel(name = "填报日期")
    private String filldata;

    /** 零头库存 */
    @Excel(name = "零头库存")
    private String zero;

    /** 是否有BOM */
    @Excel(name = "是否有BOM")
    private String iflen;

    /** 客户编码 */
    @Excel(name = "客户编码")
    private String custcode;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String custname;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String error;

    /** 工艺标志 */
    @Excel(name = "工艺标志")
    private String gybz;

    /** 工艺要求 */
    @Excel(name = "工艺要求")
    private String gyyq;

    /** 主键 */
    private Long id;

    public void setPlancode(String plancode)
    {
        this.plancode = plancode;
    }

    public String getPlancode()
    {
        return plancode;
    }
    public void setModifiedon(Date modifiedon)
    {
        this.modifiedon = modifiedon;
    }

    public Date getModifiedon()
    {
        return modifiedon;
    }
    public void setDocno(String docno)
    {
        this.docno = docno;
    }

    public String getDocno()
    {
        return docno;
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
    public void setSaleslineid(String saleslineid)
    {
        this.saleslineid = saleslineid;
    }

    public String getSaleslineid()
    {
        return saleslineid;
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
    public void setLjsf(String ljsf)
    {
        this.ljsf = ljsf;
    }

    public String getLjsf()
    {
        return ljsf;
    }
    public void setT3u3(String t3u3)
    {
        this.t3u3 = t3u3;
    }

    public String getT3u3()
    {
        return t3u3;
    }
    public void setLjpc(String ljpc)
    {
        this.ljpc = ljpc;
    }

    public String getLjpc()
    {
        return ljpc;
    }
    public void setY3ap3av3(String y3ap3av3)
    {
        this.y3ap3av3 = y3ap3av3;
    }

    public String getY3ap3av3()
    {
        return y3ap3av3;
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
    public void setCxj(String cxj)
    {
        this.cxj = cxj;
    }

    public String getCxj()
    {
        return cxj;
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
    public void setCmj(String cmj)
    {
        this.cmj = cmj;
    }

    public String getCmj()
    {
        return cmj;
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
    public void setDayShift(String dayShift)
    {
        this.dayShift = dayShift;
    }

    public String getDayShift()
    {
        return dayShift;
    }
    public void setNoonShift(String noonShift)
    {
        this.noonShift = noonShift;
    }

    public String getNoonShift()
    {
        return noonShift;
    }
    public void setSuman3(String suman3)
    {
        this.suman3 = suman3;
    }

    public String getSuman3()
    {
        return suman3;
    }
    public void setAp3y3(String ap3y3)
    {
        this.ap3y3 = ap3y3;
    }

    public String getAp3y3()
    {
        return ap3y3;
    }
    public void setQtys(String qtys)
    {
        this.qtys = qtys;
    }

    public String getQtys()
    {
        return qtys;
    }
    public void setU3(String u3)
    {
        this.u3 = u3;
    }

    public String getU3()
    {
        return u3;
    }
    public void setAp3(String ap3)
    {
        this.ap3 = ap3;
    }

    public String getAp3()
    {
        return ap3;
    }
    public void setT3w3(String t3w3)
    {
        this.t3w3 = t3w3;
    }

    public String getT3w3()
    {
        return t3w3;
    }
    public void setLastWeek(String lastWeek)
    {
        this.lastWeek = lastWeek;
    }

    public String getLastWeek()
    {
        return lastWeek;
    }
    public void setFilldata(String filldata)
    {
        this.filldata = filldata;
    }

    public String getFilldata()
    {
        return filldata;
    }
    public void setZero(String zero)
    {
        this.zero = zero;
    }

    public String getZero()
    {
        return zero;
    }
    public void setIflen(String iflen)
    {
        this.iflen = iflen;
    }

    public String getIflen()
    {
        return iflen;
    }
    public void setCustcode(String custcode)
    {
        this.custcode = custcode;
    }

    public String getCustcode()
    {
        return custcode;
    }
    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getCustname()
    {
        return custname;
    }
    public void setError(String error)
    {
        this.error = error;
    }

    public String getError()
    {
        return error;
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
                .append("plancode", getPlancode())
                .append("modifiedon", getModifiedon())
                .append("docno", getDocno())
                .append("demandname", getDemandname())
                .append("code", getCode())
                .append("plmItemCode", getPlmItemCode())
                .append("saleslineid", getSaleslineid())
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
                .append("ljsf", getLjsf())
                .append("t3u3", getT3u3())
                .append("ljpc", getLjpc())
                .append("y3ap3av3", getY3ap3av3())
                .append("t3", getT3())
                .append("t3ab3", getT3ab3())
                .append("bzpc", getBzpc())
                .append("swan", getSwan())
                .append("cxj", getCxj())
                .append("cdj", getCdj())
                .append("descflexfieldPrivatedescseg13", getDescflexfieldPrivatedescseg13())
                .append("gydm", getGydm())
                .append("tc", getTc())
                .append("memo", getMemo())
                .append("dd", getDd())
                .append("cmj", getCmj())
                .append("mj", getMj())
                .append("mjh", getMjh())
                .append("ltkc", getLtkc())
                .append("dayShift", getDayShift())
                .append("noonShift", getNoonShift())
                .append("suman3", getSuman3())
                .append("ap3y3", getAp3y3())
                .append("qtys", getQtys())
                .append("u3", getU3())
                .append("ap3", getAp3())
                .append("t3w3", getT3w3())
                .append("lastWeek", getLastWeek())
                .append("filldata", getFilldata())
                .append("zero", getZero())
                .append("iflen", getIflen())
                .append("custcode", getCustcode())
                .append("custname", getCustname())
                .append("error", getError())
                .append("gybz", getGybz())
                .append("gyyq", getGyyq())
                .append("id", getId())
                .toString();
    }
}
