package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptorderinsertMapper;
import com.ruoyi.system.domain.CyDeptorderinsert;
import com.ruoyi.system.service.ICyDeptorderinsertService;

/**
 * 填报派单插单Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-16
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class CyDeptorderinsertServiceImpl implements ICyDeptorderinsertService
{
    @Autowired
    private CyDeptorderinsertMapper cyDeptorderinsertMapper;

    /**
     * 查询填报派单插单
     *
     * @param id 填报派单插单主键
     * @return 填报派单插单
     */
    @Override
    public CyDeptorderinsert selectCyDeptorderinsertById(Integer id)
    {
        return cyDeptorderinsertMapper.selectCyDeptorderinsertById(id);
    }

    /**
     * 查询填报派单插单列表
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 填报派单插单
     */
    @Override
    public List<CyDeptorderinsert> selectCyDeptorderinsertList(CyDeptorderinsert cyDeptorderinsert)
    {
        return cyDeptorderinsertMapper.selectCyDeptorderinsertList(cyDeptorderinsert);
    }

    /**
     * 新增填报派单插单
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 结果
     */
    @Override
    public int insertCyDeptorderinsert(CyDeptorderinsert cyDeptorderinsert)
    {
        return cyDeptorderinsertMapper.insertCyDeptorderinsert(cyDeptorderinsert);
    }

    /**
     * 修改填报派单插单
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 结果
     */
    @Override
    public int updateCyDeptorderinsert(CyDeptorderinsert cyDeptorderinsert)
    {
        return cyDeptorderinsertMapper.updateCyDeptorderinsert(cyDeptorderinsert);
    }

    /**
     * 批量删除填报派单插单
     *
     * @param ids 需要删除的填报派单插单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptorderinsertByIds(Integer[] ids)
    {
        return cyDeptorderinsertMapper.deleteCyDeptorderinsertByIds(ids);
    }

    /**
     * 删除填报派单插单信息
     *
     * @param id 填报派单插单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptorderinsertById(Integer id)
    {
        return cyDeptorderinsertMapper.deleteCyDeptorderinsertById(id);
    }
}
