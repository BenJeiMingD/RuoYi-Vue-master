package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptqiMapper;
import com.ruoyi.system.domain.Deptqi;
import com.ruoyi.system.service.IDeptqiService;

/**
 * 期数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-19
 */
@Service
public class DeptqiServiceImpl implements IDeptqiService
{
    @Autowired
    private DeptqiMapper deptqiMapper;

    /**
     * 查询期数
     *
     * @param id 期数主键
     * @return 期数
     */
    @Override
    public Deptqi selectDeptqiById(Integer id)
    {
        return deptqiMapper.selectDeptqiById(id);
    }

    /**
     * 查询期数列表
     *
     * @param deptqi 期数
     * @return 期数
     */
    @Override
    public List<Deptqi> selectDeptqiList(Deptqi deptqi)
    {
        return deptqiMapper.selectDeptqiList(deptqi);
    }

    /**
     * 新增期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    @Override
    public int insertDeptqi(Deptqi deptqi)
    {
        return deptqiMapper.insertDeptqi(deptqi);
    }

    /**
     * 修改期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    @Override
    public int updateDeptqi(Deptqi deptqi)
    {
        return deptqiMapper.updateDeptqi(deptqi);
    }

    /**
     * 批量删除期数
     *
     * @param ids 需要删除的期数主键
     * @return 结果
     */
    @Override
    public int deleteDeptqiByIds(Integer[] ids)
    {
        return deptqiMapper.deleteDeptqiByIds(ids);
    }

    /**
     * 删除期数信息
     *
     * @param id 期数主键
     * @return 结果
     */
    @Override
    public int deleteDeptqiById(Integer id)
    {
        return deptqiMapper.deleteDeptqiById(id);
    }
}
