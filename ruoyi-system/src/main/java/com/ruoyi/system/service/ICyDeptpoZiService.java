package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyDeptpoZi;

/**
 * 成型方式分组信息子Service接口
 *
 * @author ruoyi
 * @date 2022-09-19
 */
public interface ICyDeptpoZiService
{
    /**
     * 查询成型方式分组信息子
     *
     * @param deptpoziId 成型方式分组信息子主键
     * @return 成型方式分组信息子
     */
    public CyDeptpoZi selectCyDeptpoZiByDeptpoziId(Integer deptpoziId);

    /**
     * 查询成型方式分组信息子列表
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 成型方式分组信息子集合
     */
    public List<CyDeptpoZi> selectCyDeptpoZiList(CyDeptpoZi cyDeptpoZi);

    /**
     * 新增成型方式分组信息子
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 结果
     */
    public int insertCyDeptpoZi(CyDeptpoZi cyDeptpoZi);

    /**
     * 修改成型方式分组信息子
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 结果
     */
    public int updateCyDeptpoZi(CyDeptpoZi cyDeptpoZi);

    /**
     * 批量删除成型方式分组信息子
     *
     * @param deptpoziIds 需要删除的成型方式分组信息子主键集合
     * @return 结果
     */
    public int deleteCyDeptpoZiByDeptpoziIds(Integer[] deptpoziIds);

    /**
     * 删除成型方式分组信息子信息
     *
     * @param deptpoziId 成型方式分组信息子主键
     * @return 结果
     */
    public int deleteCyDeptpoZiByDeptpoziId(Integer deptpoziId);
}
