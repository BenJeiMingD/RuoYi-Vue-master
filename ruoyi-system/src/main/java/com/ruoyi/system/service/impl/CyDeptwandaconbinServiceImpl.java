package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptwandaconbinMapper;
import com.ruoyi.system.domain.CyDeptwandaconbin;
import com.ruoyi.system.service.ICyDeptwandaconbinService;

import javax.annotation.Resource;

/**
 * 万达jsonService业务层处理
 *
 * @author ruoyi
 * @date 2022-10-13
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class CyDeptwandaconbinServiceImpl implements ICyDeptwandaconbinService
{
    @Resource
    private CyDeptwandaconbinMapper cyDeptwandaconbinMapper;

    /**
     * 查询万达json
     *
     * @param id 万达json主键
     * @return 万达json
     */
    @Override
    public CyDeptwandaconbin selectCyDeptwandaconbinById(Integer id)
    {
        return cyDeptwandaconbinMapper.selectCyDeptwandaconbinById(id);
    }

    /**
     * 查询万达json列表
     *
     * @param cyDeptwandaconbin 万达json
     * @return 万达json
     */
    @Override
    public List<CyDeptwandaconbin> selectCyDeptwandaconbinList(CyDeptwandaconbin cyDeptwandaconbin)
    {
        return cyDeptwandaconbinMapper.selectCyDeptwandaconbinList(cyDeptwandaconbin);
    }

    /**
     * 新增万达json
     *
     * @param cyDeptwandaconbin 万达json
     * @return 结果
     */
    @Override
    public int insertCyDeptwandaconbin(CyDeptwandaconbin cyDeptwandaconbin)
    {
        return cyDeptwandaconbinMapper.insertCyDeptwandaconbin(cyDeptwandaconbin);
    }

    /**
     * 修改万达json
     *
     * @param cyDeptwandaconbin 万达json
     * @return 结果
     */
    @Override
    public int updateCyDeptwandaconbin(CyDeptwandaconbin cyDeptwandaconbin)
    {
        return cyDeptwandaconbinMapper.updateCyDeptwandaconbin(cyDeptwandaconbin);
    }

    /**
     * 批量删除万达json
     *
     * @param ids 需要删除的万达json主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptwandaconbinByIds(Integer[] ids)
    {
        return cyDeptwandaconbinMapper.deleteCyDeptwandaconbinByIds(ids);
    }

    /**
     * 删除万达json信息
     *
     * @param id 万达json主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptwandaconbinById(Integer id)
    {
        return cyDeptwandaconbinMapper.deleteCyDeptwandaconbinById(id);
    }
}
