package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptpoZiMapper;
import com.ruoyi.system.domain.CyDeptpoZi;
import com.ruoyi.system.service.ICyDeptpoZiService;

/**
 * 成型方式分组信息子Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-19
 */
@Service
public class CyDeptpoZiServiceImpl implements ICyDeptpoZiService
{
    @Autowired
    private CyDeptpoZiMapper cyDeptpoZiMapper;

    /**
     * 查询成型方式分组信息子
     *
     * @param deptpoziId 成型方式分组信息子主键
     * @return 成型方式分组信息子
     */
    @Override
    public CyDeptpoZi selectCyDeptpoZiByDeptpoziId(Integer deptpoziId)
    {
        return cyDeptpoZiMapper.selectCyDeptpoZiByDeptpoziId(deptpoziId);
    }

    /**
     * 查询成型方式分组信息子列表
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 成型方式分组信息子
     */
    @Override
    public List<CyDeptpoZi> selectCyDeptpoZiList(CyDeptpoZi cyDeptpoZi)
    {
        return cyDeptpoZiMapper.selectCyDeptpoZiList(cyDeptpoZi);
    }

    /**
     * 新增成型方式分组信息子
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 结果
     */
    @Override
    public int insertCyDeptpoZi(CyDeptpoZi cyDeptpoZi)
    {
        return cyDeptpoZiMapper.insertCyDeptpoZi(cyDeptpoZi);
    }

    /**
     * 修改成型方式分组信息子
     *
     * @param cyDeptpoZi 成型方式分组信息子
     * @return 结果
     */
    @Override
    public int updateCyDeptpoZi(CyDeptpoZi cyDeptpoZi)
    {
        return cyDeptpoZiMapper.updateCyDeptpoZi(cyDeptpoZi);
    }

    /**
     * 批量删除成型方式分组信息子
     *
     * @param deptpoziIds 需要删除的成型方式分组信息子主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptpoZiByDeptpoziIds(Integer[] deptpoziIds)
    {
        return cyDeptpoZiMapper.deleteCyDeptpoZiByDeptpoziIds(deptpoziIds);
    }

    /**
     * 删除成型方式分组信息子信息
     *
     * @param deptpoziId 成型方式分组信息子主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptpoZiByDeptpoziId(Integer deptpoziId)
    {
        return cyDeptpoZiMapper.deleteCyDeptpoZiByDeptpoziId(deptpoziId);
    }
}
