package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptsumzi;

/**
 * 部门汇总子Service接口
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
public interface IDeptsumziService 
{
    /**
     * 查询部门汇总子
     * 
     * @param id 部门汇总子主键
     * @return 部门汇总子
     */
    public Deptsumzi selectDeptsumziById(Integer id);

    /**
     * 查询部门汇总子列表
     * 
     * @param deptsumzi 部门汇总子
     * @return 部门汇总子集合
     */
    public List<Deptsumzi> selectDeptsumziList(Deptsumzi deptsumzi);

    /**
     * 新增部门汇总子
     * 
     * @param deptsumzi 部门汇总子
     * @return 结果
     */
    public int insertDeptsumzi(Deptsumzi deptsumzi);

    /**
     * 修改部门汇总子
     * 
     * @param deptsumzi 部门汇总子
     * @return 结果
     */
    public int updateDeptsumzi(Deptsumzi deptsumzi);

    /**
     * 批量删除部门汇总子
     * 
     * @param ids 需要删除的部门汇总子主键集合
     * @return 结果
     */
    public int deleteDeptsumziByIds(Integer[] ids);

    /**
     * 删除部门汇总子信息
     * 
     * @param id 部门汇总子主键
     * @return 结果
     */
    public int deleteDeptsumziById(Integer id);
}
