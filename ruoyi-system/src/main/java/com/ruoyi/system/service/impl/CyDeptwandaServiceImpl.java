package com.ruoyi.system.service.impl;

import java.util.*;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.ConfigMergeModel;
import com.ruoyi.system.domain.CyWdsumcon;
import com.ruoyi.system.domain.Deptqi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptwandaMapper;
import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.service.ICyDeptwandaService;

import javax.annotation.Resource;

/**
 * 插单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@Service
public class CyDeptwandaServiceImpl implements ICyDeptwandaService
{
    @Resource
    private CyDeptwandaMapper cyDeptwandaMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CyDeptwanda> selectBySaleslineIdList(CyDeptwanda cyDeptwanda) {
        return cyDeptwandaMapper.selectBySaleslineIdList(cyDeptwanda);
    }

    @Override

    public String execuStoredprocedure(Date startTime) {
        return cyDeptwandaMapper.execuStoredprocedure(startTime);
    }

    @Override
    public String execuStoredprocedureX(Date startTime) {
        return cyDeptwandaMapper.execuStoredprocedureX(startTime);
    }

    /**
     * 查询插单
     * 
     * @param id 插单主键
     * @return 插单
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public CyDeptwanda selectCyDeptwandaById(Integer id)
    {
        return cyDeptwandaMapper.selectCyDeptwandaById(id);
    }

    /**
     * 查询插单列表
     * 
     * @param cyDeptwanda 插单
     * @return 插单
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CyDeptwanda> selectCyDeptwandaList(CyDeptwanda cyDeptwanda)
    {
        List<CyDeptwanda> list = cyDeptwandaMapper.selectCyDeptwandaList(cyDeptwanda);
        return list;
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CyWdsumcon> selectCyDeptExWanCoBin(CyWdsumcon cyWdsumcon)
    {
        List<CyWdsumcon> list = cyDeptwandaMapper.selectCyDeptExWanCoBin(cyWdsumcon);
        return list;
    }

    /**
     * 新增插单
     * 
     * @param cyDeptwanda 插单
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertCyDeptwanda(CyDeptwanda cyDeptwanda)
    {
        return cyDeptwandaMapper.insertCyDeptwanda(cyDeptwanda);
    }

    /**
     * 修改插单
     * 
     * @param cyDeptwanda 插单
     * @return 结果
     */
    @Override
    public int updateCyDeptwanda(CyDeptwanda cyDeptwanda)
    {
        return cyDeptwandaMapper.updateCyDeptwanda(cyDeptwanda);
    }

    /**
     * 批量删除插单
     * 
     * @param ids 需要删除的插单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptwandaByIds(Integer[] ids)
    {
        return cyDeptwandaMapper.deleteCyDeptwandaByIds(ids);
    }

    /**
     * 删除插单信息
     * 
     * @param id 插单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptwandaById(Integer id)
    {
        return cyDeptwandaMapper.deleteCyDeptwandaById(id);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteCyDeptwanda() {
        return cyDeptwandaMapper.deleteCyDeptwanda();
    }
}
