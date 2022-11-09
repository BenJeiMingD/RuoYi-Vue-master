package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDepcombinMapper;
import com.ruoyi.system.domain.CyDepcombin;
import com.ruoyi.system.service.ICyDepcombinService;

import javax.annotation.Resource;

/**
 * 合并汇总Service业务层处理
 *
 * @author ruoyi
 * @date 2022-10-12
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class CyDepcombinServiceImpl implements ICyDepcombinService
{
    @Resource
    private CyDepcombinMapper cyDepcombinMapper;

    /**
     * 查询合并汇总
     *
     * @param id 合并汇总主键
     * @return 合并汇总
     */
    @Override
    public CyDepcombin selectCyDepcombinById(Integer id)
    {
        return cyDepcombinMapper.selectCyDepcombinById(id);
    }

    /**
     * 查询合并汇总列表
     *
     * @param cyDepcombin 合并汇总
     * @return 合并汇总
     */
    @Override
    public List<CyDepcombin> selectCyDepcombinList(CyDepcombin cyDepcombin)
    {
        return cyDepcombinMapper.selectCyDepcombinList(cyDepcombin);
    }

    /**
     * 新增合并汇总
     *
     * @param cyDepcombin 合并汇总
     * @return 结果
     */
    @Override
    public int insertCyDepcombin(CyDepcombin cyDepcombin)
    {
        return cyDepcombinMapper.insertCyDepcombin(cyDepcombin);
    }

    /**
     * 修改合并汇总
     *
     * @param cyDepcombin 合并汇总
     * @return 结果
     */
    @Override
    public int updateCyDepcombin(CyDepcombin cyDepcombin)
    {
        return cyDepcombinMapper.updateCyDepcombin(cyDepcombin);
    }

    /**
     * 批量删除合并汇总
     *
     * @param ids 需要删除的合并汇总主键
     * @return 结果
     */
    @Override
    public int deleteCyDepcombinByIds(Integer[] ids)
    {
        return cyDepcombinMapper.deleteCyDepcombinByIds(ids);
    }

    /**
     * 删除合并汇总信息
     *
     * @param id 合并汇总主键
     * @return 结果
     */
    @Override
    public int deleteCyDepcombinById(Integer id)
    {
        return cyDepcombinMapper.deleteCyDepcombinById(id);
    }
}
