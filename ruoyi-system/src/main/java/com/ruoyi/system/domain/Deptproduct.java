package com.ruoyi.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料产能对照对象 deptproduct
 *
 * @author ruoyi
 * @date 2022-08-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deptproduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料产能对照表id */
    private Integer id;

    /** 产能子表 */
    private Deptzi deptzi;
    /** 页码数 */
    private Integer Package;

    /** itemmester表 */
    private CboItemmaster cboItemmaster;

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

    /** 万达历史数据编号 */
    @Excel(name = "万达历史数据编号")
    private Integer cboItemmasterId;

    /** 资产能表 */
    @Excel(name = "资产能表")
    private Integer deptziId;

    /** 产能调整表编号 */
    @Excel(name = "资产能表")
    private Integer deptpoId;

}
