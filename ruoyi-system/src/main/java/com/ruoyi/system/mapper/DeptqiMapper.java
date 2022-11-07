package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deptqi;

/**
 * 期数Mapper接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface DeptqiMapper
{
    /**
     * 查询期数
     *
     * @param id 期数主键
     * @return 期数
     */
    public Deptqi selectDeptqiById(Integer id);

    /**
     * 查询本年的最大期数
     *
     * @param yearCode 年号
     * @return 期数
     */
    public Deptqi MaxIssueNumber(Integer yearCode);

    /**
     * 查询期数列表
     *
     * @param deptqi 期数
     * @return 期数集合
     */
    public List<Deptqi> selectDeptqiList(Deptqi deptqi);

    /**
     * 新增期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    public int insertDeptqi(Deptqi deptqi);

    /**
     * 修改期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    public int updateDeptqi(Deptqi deptqi);

    /**
     * 删除期数
     *
     * @param id 期数主键
     * @return 结果
     */
    public int deleteDeptqiById(Integer id);

    /**
     * 批量删除期数
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeptqiByIds(Integer[] ids);
}
