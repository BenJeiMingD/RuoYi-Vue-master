package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptsummaryMapper;
import com.ruoyi.system.domain.CyDeptsummary;
import com.ruoyi.system.service.ICyDeptsummaryService;

/**
 * 填报派单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
@Service
public class CyDeptsummaryServiceImpl implements ICyDeptsummaryService 
{
    @Autowired
    private CyDeptsummaryMapper cyDeptsummaryMapper;

    /**
     * 查询填报派单
     * 
     * @param id 填报派单主键
     * @return 填报派单
     */
    @Override
    public CyDeptsummary selectCyDeptsummaryById(Integer id)
    {
        return cyDeptsummaryMapper.selectCyDeptsummaryById(id);
    }

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsummary 填报派单
     * @return 填报派单
     */
    @Override
    public List<CyDeptsummary> selectCyDeptsummaryList(CyDeptsummary cyDeptsummary)
    {
        return cyDeptsummaryMapper.selectCyDeptsummaryList(cyDeptsummary);
    }

    /**
     * 新增填报派单
     * 
     * @param cyDeptsummary 填报派单
     * @return 结果
     */
    @Override
    public int insertCyDeptsummary(CyDeptsummary cyDeptsummary)
    {
        return cyDeptsummaryMapper.insertCyDeptsummary(cyDeptsummary);
    }

    /**
     * 修改填报派单
     * 
     * @param cyDeptsummary 填报派单
     * @return 结果
     */
    @Override
    public int updateCyDeptsummary(CyDeptsummary cyDeptsummary)
    {
        return cyDeptsummaryMapper.updateCyDeptsummary(cyDeptsummary);
    }

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsummaryByIds(Integer[] ids)
    {
        return cyDeptsummaryMapper.deleteCyDeptsummaryByIds(ids);
    }

    /**
     * 删除填报派单信息
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsummaryById(Integer id)
    {
        return cyDeptsummaryMapper.deleteCyDeptsummaryById(id);
    }
}
