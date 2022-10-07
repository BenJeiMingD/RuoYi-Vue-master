package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Deptinfomsg;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface IDeptinfomsgService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deptinfomsg selectDeptinfomsgById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deptinfomsg> selectDeptinfomsgList(Deptinfomsg deptinfomsg);

    /**
     * 新增【请填写功能名称】
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 结果
     */
    public int insertDeptinfomsg(Deptinfomsg deptinfomsg);

    /**
     * 修改【请填写功能名称】
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 结果
     */
    public int updateDeptinfomsg(Deptinfomsg deptinfomsg);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeptinfomsgByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeptinfomsgById(Integer id);
}
