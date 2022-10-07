package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptzi;

/**
 * 成型方式分组信息子Service接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface IDeptziService
{
    /**
     * 查询成型方式分组信息子
     *
     * @param deptId 成型方式分组信息子主键
     * @return 成型方式分组信息子
     */
    public Deptzi selectDeptziById(Integer deptId);

    /**
     * 查询成型方式分组信息子列表
     *
     * @param deptzi 成型方式分组信息子
     * @return 成型方式分组信息子集合
     */
    public List<Deptzi> selectDeptziList(Deptzi deptzi);

    /**
     * 查询成型方式分组信息子列表
     *
     * @param deptzhuId 成型方式分组信息子
     * @return 成型方式分组信息子集合
     */
    public List<Deptzi> selectDeptziListDeptid(Integer deptzhuId);
    /**
     * 新增成型方式分组信息子
     *
     * @param deptzi 成型方式分组信息子
     * @return 结果
     */
    public int insertDeptzi(Deptzi deptzi);

    /**
     * 修改成型方式分组信息子
     *
     * @param deptzi 成型方式分组信息子
     * @return 结果
     */
    public int updateDeptzi(Deptzi deptzi);

    /**
     * 批量删除成型方式分组信息子
     *
     * @param ids 需要删除的成型方式分组信息子主键集合
     * @return 结果
     */
    public int deleteDeptziByIds(Integer[] ids);

    /**
     * 删除成型方式分组信息子信息
     *
     * @param deptId 成型方式分组信息子主键
     * @return 结果
     */
    public int deleteDeptziById(Integer deptId);

    /**
     * 删除成型方式分组信息子信息
     *
     * @param deptId 成型方式分组信息子主键
     * @return 结果
     */
    public int deleteDeptziByIdst(Integer deptId ,Integer deptzhuId);


}
