package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptformMapper;
import com.ruoyi.system.domain.Deptform;
import com.ruoyi.system.service.IDeptformService;

/**
 * 填报派单
 (派单确认)
 (填报派单)Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-22
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class DeptformServiceImpl implements IDeptformService
{
    @Autowired
    private DeptformMapper deptformMapper;

    /**
     * 查询填报派单
     (派单确认)
     (填报派单)
     *
     * @param id 填报派单
    (派单确认)
    (填报派单)主键
     * @return 填报派单
    (派单确认)
    (填报派单)
     */
    @Override
    public Deptform selectDeptformById(Integer id)
    {
        return deptformMapper.selectDeptformById(id);
    }

    /**
     * 查询填报派单
     (派单确认)
     (填报派单)列表
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 填报派单
    (派单确认)
    (填报派单)
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Deptform> selectDeptformList(Deptform deptform)
    {
        return deptformMapper.selectDeptformList(deptform);
    }

    /**
     * 新增填报派单
     (派单确认)
     (填报派单)
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 结果
     */
    @Override
    public int insertDeptform(Deptform deptform)
    {
        return deptformMapper.insertDeptform(deptform);
    }

    /**
     * 修改填报派单
     (派单确认)
     (填报派单)
     *
     * @param deptform 填报派单
    (派单确认)
    (填报派单)
     * @return 结果
     */
    @Override
    public int updateDeptform(Deptform deptform)
    {
        deptform.setUpdateTime(DateUtils.getNowDate());
        return deptformMapper.updateDeptform(deptform);
    }

    /**
     * 批量删除填报派单
     (派单确认)
     (填报派单)
     *
     * @param ids 需要删除的填报派单
    (派单确认)
    (填报派单)主键
     * @return 结果
     */
    @Override
    public int deleteDeptformByIds(Integer[] ids)
    {
        return deptformMapper.deleteDeptformByIds(ids);
    }

    /**
     * 删除填报派单
     (派单确认)
     (填报派单)信息
     *
     * @param id 填报派单
    (派单确认)
    (填报派单)主键
     * @return 结果
     */
    @Override
    public int deleteDeptformById(Integer id)
    {
        return deptformMapper.deleteDeptformById(id);
    }
}
