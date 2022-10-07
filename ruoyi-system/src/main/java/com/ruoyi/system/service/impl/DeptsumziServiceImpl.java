package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptsumziMapper;
import com.ruoyi.system.domain.Deptsumzi;
import com.ruoyi.system.service.IDeptsumziService;

/**
 * 部门汇总子Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@Service
public class DeptsumziServiceImpl implements IDeptsumziService 
{
    @Autowired
    private DeptsumziMapper deptsumziMapper;

    /**
     * 查询部门汇总子
     * 
     * @param id 部门汇总子主键
     * @return 部门汇总子
     */
    @Override
    public Deptsumzi selectDeptsumziById(Integer id)
    {
        return deptsumziMapper.selectDeptsumziById(id);
    }

    /**
     * 查询部门汇总子列表
     * 
     * @param deptsumzi 部门汇总子
     * @return 部门汇总子
     */
    @Override
    public List<Deptsumzi> selectDeptsumziList(Deptsumzi deptsumzi)
    {
        return deptsumziMapper.selectDeptsumziList(deptsumzi);
    }

    /**
     * 新增部门汇总子
     * 
     * @param deptsumzi 部门汇总子
     * @return 结果
     */
    @Override
    public int insertDeptsumzi(Deptsumzi deptsumzi)
    {
        return deptsumziMapper.insertDeptsumzi(deptsumzi);
    }

    /**
     * 修改部门汇总子
     * 
     * @param deptsumzi 部门汇总子
     * @return 结果
     */
    @Override
    public int updateDeptsumzi(Deptsumzi deptsumzi)
    {
        return deptsumziMapper.updateDeptsumzi(deptsumzi);
    }

    /**
     * 批量删除部门汇总子
     * 
     * @param ids 需要删除的部门汇总子主键
     * @return 结果
     */
    @Override
    public int deleteDeptsumziByIds(Integer[] ids)
    {
        return deptsumziMapper.deleteDeptsumziByIds(ids);
    }

    /**
     * 删除部门汇总子信息
     * 
     * @param id 部门汇总子主键
     * @return 结果
     */
    @Override
    public int deleteDeptsumziById(Integer id)
    {
        return deptsumziMapper.deleteDeptsumziById(id);
    }
}
