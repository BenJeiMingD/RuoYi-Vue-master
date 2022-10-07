package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptinfomsgMapper;
import com.ruoyi.system.domain.Deptinfomsg;
import com.ruoyi.system.service.IDeptinfomsgService;

import javax.annotation.Resource;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-19
 */
@Service
public class DeptinfomsgServiceImpl implements IDeptinfomsgService
{
    @Resource
    private DeptinfomsgMapper deptinfomsgMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Deptinfomsg selectDeptinfomsgById(Integer id)
    {
        return deptinfomsgMapper.selectDeptinfomsgById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Deptinfomsg> selectDeptinfomsgList(Deptinfomsg deptinfomsg)
    {
        return deptinfomsgMapper.selectDeptinfomsgList(deptinfomsg);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeptinfomsg(Deptinfomsg deptinfomsg)
    {
        return deptinfomsgMapper.insertDeptinfomsg(deptinfomsg);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param deptinfomsg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeptinfomsg(Deptinfomsg deptinfomsg)
    {
        return deptinfomsgMapper.updateDeptinfomsg(deptinfomsg);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeptinfomsgByIds(Integer[] ids)
    {
        return deptinfomsgMapper.deleteDeptinfomsgByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeptinfomsgById(Integer id)
    {
        return deptinfomsgMapper.deleteDeptinfomsgById(id);
    }
}
