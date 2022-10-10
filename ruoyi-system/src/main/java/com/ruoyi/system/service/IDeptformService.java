package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptform;

/**
 * 填报派单
 (派单确认)
 (填报派单)Service接口
 *
 * @author ruoyi
 * @date 2022-09-22
 */
public interface IDeptformService
{
    /**
     * 查询填报派单
     (派单确认)
     (填报派单)
     *
     * @param id 填报派单
    (派单确认)
    (填报派单)主键
     * @return 填报派单
    (派单确认)
    (填报派单)
     */
    public Deptform selectDeptformById(Integer id);

    /**
     * 查询填报派单
     (派单确认)
     (填报派单)列表
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 填报派单
    (派单确认)
    (填报派单)集合
     */
    public List<Deptform> selectDeptformList(Deptform deptform);

    /**
     * 新增填报派单
     (派单确认)
     (填报派单)
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 结果
     */
    public int insertDeptform(Deptform deptform);

    /**
     * 修改填报派单
     (派单确认)
     (填报派单)
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 结果
     */
    public int updateDeptform(Deptform deptform);

    /**
     * 批量删除填报派单
     (派单确认)
     (填报派单)
     *
     * @param ids 需要删除的填报派单
    (派单确认)
    (填报派单)主键集合
     * @return 结果
     */
    public int deleteDeptformByIds(Integer[] ids);

    /**
     * 删除填报派单
     (派单确认)
     (填报派单)信息
     *
     * @param id 填报派单
    (派单确认)
    (填报派单)主键
     * @return 结果
     */
    public int deleteDeptformById(Integer id);
}
