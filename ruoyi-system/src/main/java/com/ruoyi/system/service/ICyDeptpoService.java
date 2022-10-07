package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyDeptpo;

/**
 * 产能调整Service接口
 *
 * @author ruoyi
 * @date 2022-09-19
 */
public interface ICyDeptpoService
{
    /**
     * 查询产能调整
     *
     * @param deptpoId 产能调整主键
     * @return 产能调整
     */
    public CyDeptpo selectCyDeptpoByDeptpoId(Integer deptpoId);

    /**
     * 查询产能调整列表
     *
     * @param cyDeptpo 产能调整
     * @return 产能调整集合
     */
    public List<CyDeptpo> selectCyDeptpoList(CyDeptpo cyDeptpo);

    /**
     * 新增产能调整
     *
     * @param cyDeptpo 产能调整
     * @return 结果
     */
    public int insertCyDeptpo(CyDeptpo cyDeptpo);

    /**
     * 修改产能调整
     *
     * @param cyDeptpo 产能调整
     * @return 结果
     */
    public int updateCyDeptpo(CyDeptpo cyDeptpo);

    /**
     * 批量删除产能调整
     *
     * @param deptpoIds 需要删除的产能调整主键集合
     * @return 结果
     */
    public int deleteCyDeptpoByDeptpoIds(Integer[] deptpoIds);

    /**
     * 删除产能调整信息
     *
     * @param deptpoId 产能调整主键
     * @return 结果
     */
    public int deleteCyDeptpoByDeptpoId(Integer deptpoId);
}
