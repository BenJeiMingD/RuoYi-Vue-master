package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptsalesexcelMapper;
import com.ruoyi.system.domain.CyDeptsalesexcel;
import com.ruoyi.system.service.ICyDeptsalesexcelService;

/**
 * 填报派单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
@Service
public class CyDeptsalesexcelServiceImpl implements ICyDeptsalesexcelService 
{
    @Autowired
    private CyDeptsalesexcelMapper cyDeptsalesexcelMapper;

    /**
     * 查询填报派单
     * 
     * @param id 填报派单主键
     * @return 填报派单
     */
    @Override
    public CyDeptsalesexcel selectCyDeptsalesexcelById(Integer id)
    {
        return cyDeptsalesexcelMapper.selectCyDeptsalesexcelById(id);
    }

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 填报派单
     */
    @Override
    public List<CyDeptsalesexcel> selectCyDeptsalesexcelList(CyDeptsalesexcel cyDeptsalesexcel)
    {
        return cyDeptsalesexcelMapper.selectCyDeptsalesexcelList(cyDeptsalesexcel);
    }

    /**
     * 新增填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    @Override
    public int insertCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel)
    {
        return cyDeptsalesexcelMapper.insertCyDeptsalesexcel(cyDeptsalesexcel);
    }

    /**
     * 修改填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    @Override
    public int updateCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel)
    {
        return cyDeptsalesexcelMapper.updateCyDeptsalesexcel(cyDeptsalesexcel);
    }

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsalesexcelByIds(Integer[] ids)
    {
        return cyDeptsalesexcelMapper.deleteCyDeptsalesexcelByIds(ids);
    }

    /**
     * 删除填报派单信息
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsalesexcelById(Integer id)
    {
        return cyDeptsalesexcelMapper.deleteCyDeptsalesexcelById(id);
    }
}
