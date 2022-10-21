package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptproduct;

/**
 * 物料产能对照Service接口
 *
 * @author ruoyi
 * @date 2022-10-18
 */
public interface IDeptproductService
{
    /**
     * 查询物料产能对照
     *
     * @param id 物料产能对照主键
     * @return 物料产能对照
     */
    public Deptproduct selectDeptproductById(Integer id);

    /**
     * 查询物料产能对照列表
     *
     * @param deptproduct 物料产能对照
     * @return 物料产能对照集合
     */
    public List<Deptproduct> selectDeptproductList(Deptproduct deptproduct);

    /**
     * 新增物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    public int insertDeptproduct(Deptproduct deptproduct);

    /**
     * 修改物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    public int updateDeptproduct(Deptproduct deptproduct);

    /**
     * 批量删除物料产能对照
     *
     * @param ids 需要删除的物料产能对照主键集合
     * @return 结果
     */
    public int deleteDeptproductByIds(Integer[] ids);

    /**
     * 删除物料产能对照信息
     *
     * @param id 物料产能对照主键
     * @return 结果
     */
    public int deleteDeptproductById(Integer id);
}
