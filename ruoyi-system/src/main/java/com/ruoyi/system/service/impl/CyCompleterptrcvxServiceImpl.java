package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyCompleterptrcvxMapper;
import com.ruoyi.system.domain.CyCompleterptrcvx;
import com.ruoyi.system.service.ICyCompleterptrcvxService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service

public class CyCompleterptrcvxServiceImpl implements ICyCompleterptrcvxService 
{
    @Autowired
    private CyCompleterptrcvxMapper cyCompleterptrcvxMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param rcvlotno 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public CyCompleterptrcvx selectCyCompleterptrcvxByRcvlotno(String rcvlotno)
    {
        return cyCompleterptrcvxMapper.selectCyCompleterptrcvxByRcvlotno(rcvlotno);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<CyCompleterptrcvx> selectCyCompleterptrcvxList(CyCompleterptrcvx cyCompleterptrcvx)
    {
        return cyCompleterptrcvxMapper.selectCyCompleterptrcvxList(cyCompleterptrcvx);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCyCompleterptrcvx(CyCompleterptrcvx cyCompleterptrcvx)
    {
        return cyCompleterptrcvxMapper.insertCyCompleterptrcvx(cyCompleterptrcvx);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCyCompleterptrcvx(CyCompleterptrcvx cyCompleterptrcvx)
    {
        return cyCompleterptrcvxMapper.updateCyCompleterptrcvx(cyCompleterptrcvx);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rcvlotnos 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCyCompleterptrcvxByRcvlotnos(String[] rcvlotnos)
    {
        return cyCompleterptrcvxMapper.deleteCyCompleterptrcvxByRcvlotnos(rcvlotnos);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param rcvlotno 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCyCompleterptrcvxByRcvlotno(String rcvlotno)
    {
        return cyCompleterptrcvxMapper.deleteCyCompleterptrcvxByRcvlotno(rcvlotno);
    }
}
