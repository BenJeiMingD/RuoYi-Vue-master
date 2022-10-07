package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptzhu;

/**
 * 成型方式分组Service接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface IDeptzhuService
{
    /**
     * 查询成型方式分组
     *
     * @param id 成型方式分组主键
     * @return 成型方式分组
     */
    public Deptzhu selectDeptzhuById(Integer id);

    /**
     * 查询成型方式分组列表
     *
     * @param deptzhu 成型方式分组
     * @return 成型方式分组集合
     */
    public List<Deptzhu> selectDeptzhuList(Deptzhu deptzhu);

    /**
     * 新增成型方式分组
     *
     * @param deptzhu 成型方式分组
     * @return 结果
     */
    public int insertDeptzhu(Deptzhu deptzhu);

    /**
     * 修改成型方式分组
     *
     * @param deptzhu 成型方式分组
     * @return 结果
     */
    public int updateDeptzhu(Deptzhu deptzhu);

    /**
     * 批量删除成型方式分组
     *
     * @param ids 需要删除的成型方式分组主键集合
     * @return 结果
     */
    public int deleteDeptzhuByIds(Integer[] ids);

    /**
     * 删除成型方式分组信息
     *
     * @param id 成型方式分组主键
     * @return 结果
     */
    public int deleteDeptzhuById(Integer id);
}
