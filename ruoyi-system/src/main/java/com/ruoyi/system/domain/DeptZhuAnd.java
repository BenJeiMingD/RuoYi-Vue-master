package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptZhuAnd {
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
    @Excel(name = "总产能")
    private BigDecimal todayNumber;

    /** 期数id */
    @Excel(name = "期数id")
    private Integer deptqiId;

    /** 包装类型 */
    @Excel(name = "包装类型")
    private String classification;

    private List<Deptzi> children;
}
