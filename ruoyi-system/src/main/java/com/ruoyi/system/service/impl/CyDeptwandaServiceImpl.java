package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.ConfigMergeModel;
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
    public List<CyDeptwanda> selectBySaleslineIdList(CyDeptwanda cyDeptwanda) {
        return cyDeptwandaMapper.selectBySaleslineIdList(cyDeptwanda);
    }

    /**
     * 查询插单
     * 
     * @param id 插单主键
     * @return 插单
     */
    @Override
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

    public List<CyDeptwanda> selectCyDeptwandaList(CyDeptwanda cyDeptwanda)
    {

        List<CyDeptwanda> list = cyDeptwandaMapper.selectCyDeptwandaList(cyDeptwanda);
        return list;
    }

    /**
     * 新增插单
     * 
     * @param cyDeptwanda 插单
     * @return 结果
     */
    @Override
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
}
