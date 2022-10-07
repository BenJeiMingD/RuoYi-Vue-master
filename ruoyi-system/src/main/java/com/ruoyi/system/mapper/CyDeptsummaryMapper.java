package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyDeptsummary;

/**
 * 填报派单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
public interface CyDeptsummaryMapper 
{
    /**
     * 查询填报派单
     * 
     * @param id 填报派单主键
     * @return 填报派单
     */
    public CyDeptsummary selectCyDeptsummaryById(Integer id);

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsummary 填报派单
     * @return 填报派单集合
     */
    public List<CyDeptsummary> selectCyDeptsummaryList(CyDeptsummary cyDeptsummary);

    /**
     * 新增填报派单
     * 
     * @param cyDeptsummary 填报派单
     * @return 结果
     */
    public int insertCyDeptsummary(CyDeptsummary cyDeptsummary);

    /**
     * 修改填报派单
     * 
     * @param cyDeptsummary 填报派单
     * @return 结果
     */
    public int updateCyDeptsummary(CyDeptsummary cyDeptsummary);

    /**
     * 删除填报派单
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    public int deleteCyDeptsummaryById(Integer id);

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptsummaryByIds(Integer[] ids);
}
