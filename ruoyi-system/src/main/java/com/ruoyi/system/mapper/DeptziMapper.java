package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deptzi;
import org.apache.ibatis.annotations.Param;


/**
 * 成型方式分组信息子Mapper接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface DeptziMapper
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
     * 删除成型方式分组信息子
     *
     * @param deptId 成型方式分组信息子主键
     * @return 结果
     */
    public int deleteDeptziById(Integer deptId);

    /**
     * 批量删除成型方式分组信息子
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeptziByIds(Integer[] ids);

    /**
     *
     * @param deptId 子产能表返回id
     * @param deptzhuId 主产能表返回id
     * @return
     */
    public int deleteDeptziByIdst(@Param("deptId")Integer deptId, @Param("deptzhuId") Integer deptzhuId);

    List<Deptzi> selectDeptziListDeptid(@Param("deptzhuId") Integer deptzhuId);
}
