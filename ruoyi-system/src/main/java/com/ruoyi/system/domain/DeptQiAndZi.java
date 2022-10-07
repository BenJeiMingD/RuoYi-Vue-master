package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptQiAndZi implements Serializable {

    /** 编号 */
    private Integer id;
    /** 成形方式 */
    @Excel(name = "成形方式")
    private String type;
    /** 等级 */
    @Excel(name = "等级")
    private Integer level;

    /** 索引 */
    @Excel(name = "索引")
    private Integer indexId;

    /** 总产能 */
    @Excel(name = "本期总产能")
    private BigDecimal sumProductive;

    /** 总产能 */
    @Excel(name = "总产能")
    private BigDecimal todayNumber;

    /** 期数id */
    @Excel(name = "期号")
    private Integer issueNumber;

    /** 天数 */
    @Excel(name = "天数")
    private BigDecimal duration;

    /** 包装类型 */
    @Excel(name = "包装类型")
    private String classification;

    private List<CyDeptpo> children;
}
