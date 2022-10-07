package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptsumMapper;
import com.ruoyi.system.domain.Deptsum;
import com.ruoyi.system.service.IDeptsumService;

/**
 * 合并汇总Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-26
 */
@Service
public class DeptsumServiceImpl implements IDeptsumService
{
    @Autowired
    private DeptsumMapper deptsumMapper;

    /**
     * 查询合并汇总
     *
     * @param id 合并汇总主键
     * @return 合并汇总
     */
    @Override
    public Deptsum selectDeptsumById(Integer id)
    {
        return deptsumMapper.selectDeptsumById(id);
    }

    /**
     * 查询合并汇总列表
     *
     * @param deptsum 合并汇总
     * @return 合并汇总
     */
    @Override
    public List<Deptsum> selectDeptsumList(Deptsum deptsum)
    {
        return deptsumMapper.selectDeptsumList(deptsum);
    }

    /**
     * 新增合并汇总
     *
     * @param deptsum 合并汇总
     * @return 结果
     */
    @Override
    public int insertDeptsum(Deptsum deptsum)
    {
        return deptsumMapper.insertDeptsum(deptsum);
    }

    /**
     * 修改合并汇总
     *
     * @param deptsum 合并汇总
     * @return 结果
     */
    @Override
    public int updateDeptsum(Deptsum deptsum)
    {
        return deptsumMapper.updateDeptsum(deptsum);
    }

    /**
     * 批量删除合并汇总
     *
     * @param ids 需要删除的合并汇总主键
     * @return 结果
     */
    @Override
    public int deleteDeptsumByIds(Integer[] ids)
    {
        return deptsumMapper.deleteDeptsumByIds(ids);
    }

    /**
     * 删除合并汇总信息
     *
     * @param id 合并汇总主键
     * @return 结果
     */
    @Override
    public int deleteDeptsumById(Integer id)
    {
        return deptsumMapper.deleteDeptsumById(id);
    }
}
