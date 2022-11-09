package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptproductMapper;
import com.ruoyi.system.domain.Deptproduct;
import com.ruoyi.system.service.IDeptproductService;

/**
 * 物料产能对照Service业务层处理
 *
 * @author ruoyi
 * @date 2022-10-18
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class DeptproductServiceImpl implements IDeptproductService
{
    @Autowired
    private DeptproductMapper deptproductMapper;

    /**
     * 查询物料产能对照
     *
     * @param id 物料产能对照主键
     * @return 物料产能对照
     */
    @Override
    public Deptproduct selectDeptproductById(Integer id)
    {
        return deptproductMapper.selectDeptproductById(id);
    }

    /**
     * 查询物料产能对照列表
     *
     * @param deptproduct 物料产能对照
     * @return 物料产能对照
     */
    @Override
    public List<Deptproduct> selectDeptproductList(Deptproduct deptproduct)
    {
        return deptproductMapper.selectDeptproductList(deptproduct);
    }

    /**
     * 新增物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    @Override
    public int insertDeptproduct(Deptproduct deptproduct)
    {
        return deptproductMapper.insertDeptproduct(deptproduct);
    }

    /**
     * 修改物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    @Override
    public int updateDeptproduct(Deptproduct deptproduct)
    {
        return deptproductMapper.updateDeptproduct(deptproduct);
    }

    /**
     * 批量删除物料产能对照
     *
     * @param ids 需要删除的物料产能对照主键
     * @return 结果
     */
    @Override
    public int deleteDeptproductByIds(Integer[] ids)
    {
        return deptproductMapper.deleteDeptproductByIds(ids);
    }

    /**
     * 删除物料产能对照信息
     *
     * @param id 物料产能对照主键
     * @return 结果
     */
    @Override
    public int deleteDeptproductById(Integer id)
    {
        return deptproductMapper.deleteDeptproductById(id);
    }
}
