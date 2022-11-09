package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptpoMapper;
import com.ruoyi.system.domain.CyDeptpo;
import com.ruoyi.system.service.ICyDeptpoService;

/**
 * 产能调整Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-19
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class CyDeptpoServiceImpl implements ICyDeptpoService
{
    @Autowired
    private CyDeptpoMapper cyDeptpoMapper;

    /**
     * 查询产能调整
     *
     * @param deptpoId 产能调整主键
     * @return 产能调整
     */
    @Override
    public CyDeptpo selectCyDeptpoByDeptpoId(Integer deptpoId)
    {
        return cyDeptpoMapper.selectCyDeptpoByDeptpoId(deptpoId);
    }

    /**
     * 查询产能调整列表
     *
     * @param cyDeptpo 产能调整
     * @return 产能调整
     */
    @Override
    public List<CyDeptpo> selectCyDeptpoList(CyDeptpo cyDeptpo)
    {
        return cyDeptpoMapper.selectCyDeptpoList(cyDeptpo);
    }

    /**
     * 新增产能调整
     *
     * @param cyDeptpo 产能调整
     * @return 结果
     */
    @Override
    public int insertCyDeptpo(CyDeptpo cyDeptpo)
    {
        return cyDeptpoMapper.insertCyDeptpo(cyDeptpo);
    }

    /**
     * 修改产能调整
     *
     * @param cyDeptpo 产能调整
     * @return 结果
     */
    @Override
    public int updateCyDeptpo(CyDeptpo cyDeptpo)
    {
        return cyDeptpoMapper.updateCyDeptpo(cyDeptpo);
    }

    /**
     * 批量删除产能调整
     *
     * @param deptpoIds 需要删除的产能调整主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptpoByDeptpoIds(Integer[] deptpoIds)
    {
        return cyDeptpoMapper.deleteCyDeptpoByDeptpoIds(deptpoIds);
    }

    /**
     * 删除产能调整信息
     *
     * @param deptpoId 产能调整主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptpoByDeptpoId(Integer deptpoId)
    {
        return cyDeptpoMapper.deleteCyDeptpoByDeptpoId(deptpoId);
    }
}
