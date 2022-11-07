package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CySkewMapper;
import com.ruoyi.system.domain.CySkew;
import com.ruoyi.system.service.ICySkewService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service

public class CySkewServiceImpl implements ICySkewService 
{
    @Autowired
    private CySkewMapper cySkewMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public CySkew selectCySkewById(Long id)
    {
        return cySkewMapper.selectCySkewById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cySkew 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CySkew> selectCySkewList(CySkew cySkew)
    {
        return cySkewMapper.selectCySkewList(cySkew);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CySkew> selectSkewYear(CySkew cySkew) {
        return cySkewMapper.selectSkewYear(cySkew);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CySkew> CySkewView(CySkew cySkew) {
        return cySkewMapper.CySkewView(cySkew);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param cySkew 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCySkew(CySkew cySkew)
    {
        return cySkewMapper.insertCySkew(cySkew);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param cySkew 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCySkew(CySkew cySkew)
    {
        return cySkewMapper.updateCySkew(cySkew);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCySkewByIds(Long[] ids)
    {
        return cySkewMapper.deleteCySkewByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCySkewById(Long id)
    {
        return cySkewMapper.deleteCySkewById(id);
    }
}
