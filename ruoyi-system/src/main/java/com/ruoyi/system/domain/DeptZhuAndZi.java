package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptZhuAndZi {
    private Integer id;
    private Integer deptId;
    private List<Deptzi> deptzis;
    private List<Deptzhu> deptzhus;
    /** 成形方式 */

    @Excel(name = "成形方式")
    private String type;

    /** 总产能 */
    @Excel(name = "总产能")
    private Integer sumNumber;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 期数id */
    @Excel(name = "期数id")
    private Integer deptqiId;

    /** 寸别 */
    @Excel(name = "寸别")
    private Integer size;

    /** 最大日产能 */
    @Excel(name = "最大日产能")
    private BigDecimal todayNumber;


    /** 产能主表id */
    @Excel(name = "产能主表id")
    private Integer deptzhuId;

    /** 运算符号 */
    @Excel(name = "运算符号")
    private String symbol;

    /** 标记 */
    @Excel(name = "标记")
    private String remark;

}
