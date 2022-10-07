package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Deptinfomsg;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-18
 */
public interface DeptinfomsgMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeptinfomsgById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeptinfomsgByIds(Integer[] ids);
}
