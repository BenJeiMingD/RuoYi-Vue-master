package com.ruoyi.system.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.system.domain.CyDeptsalesexcel;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 填报派单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
public interface CyDeptsalesexcelMapper 
{
    /**
     * 查询总的销售需求
     * 
     * @param cyDeptsalesexcel 填报派单用户名
     * @return 填报派单
     * public int deleteDeptziByIdst(@Param("deptId")Integer deptId, @Param("deptzhuId") Integer deptzhuId);
     */
    public CyDeptsalesexcel selectsumXqList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询总的本组最大产能类
     *
     * @param cyDeptsalesexcel 无处传入 返回主参能的累计类型
     * @return 填报派单
     */
    public List<CyDeptsalesexcel> selectGroupsumList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询总的本期产能
     *
     * @param
     * @return 填报派单
     */
    public Integer selectsumZhuList();

    /**
     * 查询填报派单
     *
     * @param id 填报派单主键
     * @return 填报派单
     */
    public CyDeptsalesexcel selectCyDeptsalesexcelById(Integer id);

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 填报派单集合
     */
    public List<CyDeptsalesexcel> selectCyDeptsalesexcelList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询填报派单列表
     *
     * @param cyDeptsalesexcel 填报派单
     * @return 返回需求不为0的数据
     */
    public List<CyDeptsalesexcel> selectCyDeptSummaryList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 新增填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    public int insertCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 新增填报派单
     *
     * @param cyDeptsalesexcel 填报派单
     * @return 结果-批量删除
     */
    public List<Integer> insertBatch(@Param("cyDeptsalesexcel") List<CyDeptsalesexcel> cyDeptsalesexcel);

    /**
     * 修改填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    public int updateCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 删除填报派单
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    public int deleteCyDeptsalesexcelById(Integer id);


    public int deleteFrom();

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptsalesexcelByIds(Integer[] ids);
}
