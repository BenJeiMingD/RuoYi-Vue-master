package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptsum;

/**
 * 合并汇总Service接口
 *
 * @author ruoyi
 * @date 2022-09-26
 */
public interface IDeptsumService
{
    /**
     * 查询合并汇总
     *
     * @param id 合并汇总主键
     * @return 合并汇总
     */
    public Deptsum selectDeptsumById(Integer id);

    /**
     * 查询合并汇总列表
     *
     * @param deptsum 合并汇总
     * @return 合并汇总集合
     */
    public List<Deptsum> selectDeptsumList(Deptsum deptsum);

    /**
     * 新增合并汇总
     *
     * @param deptsum 合并汇总
     * @return 结果
     */
    public int insertDeptsum(Deptsum deptsum);

    /**
     * 修改合并汇总
     *
     * @param deptsum 合并汇总
     * @return 结果
     */
    public int updateDeptsum(Deptsum deptsum);

    /**
     * 批量删除合并汇总
     *
     * @param ids 需要删除的合并汇总主键集合
     * @return 结果
     */
    public int deleteDeptsumByIds(Integer[] ids);

    /**
     * 删除合并汇总信息
     *
     * @param id 合并汇总主键
     * @return 结果
     */
    public int deleteDeptsumById(Integer id);
}
