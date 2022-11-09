package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptzhuMapper;
import com.ruoyi.system.domain.Deptzhu;
import com.ruoyi.system.service.IDeptzhuService;

import javax.annotation.Resource;

/**
 * 成型方式分组Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-19
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class DeptzhuServiceImpl implements IDeptzhuService
{
    @Resource
    private DeptzhuMapper deptzhuMapper;

    /**
     * 查询成型方式分组
     *
     * @param id 成型方式分组主键
     * @return 成型方式分组
     */
    @Override
    public Deptzhu selectDeptzhuById(Integer id)
    {
        return deptzhuMapper.selectDeptzhuById(id);
    }

    /**
     * 查询成型方式分组列表
     *
     * @param deptzhu 成型方式分组
     * @return 成型方式分组
     */
    @Override
    public List<Deptzhu> selectDeptzhuList(Deptzhu deptzhu)
    {
        return deptzhuMapper.selectDeptzhuList(deptzhu);
    }

    /**
     * 新增成型方式分组
     *
     * @param deptzhu 成型方式分组
     * @return 结果
     */
    @Override
    public int insertDeptzhu(Deptzhu deptzhu)
    {
        return deptzhuMapper.insertDeptzhu(deptzhu);
    }

    /**
     * 修改成型方式分组
     *
     * @param deptzhu 成型方式分组
     * @return 结果
     */
    @Override
    public int updateDeptzhu(Deptzhu deptzhu)
    {
        return deptzhuMapper.updateDeptzhu(deptzhu);
    }

    /**
     * 批量删除成型方式分组
     *
     * @param ids 需要删除的成型方式分组主键
     * @return 结果
     */
    @Override
    public int deleteDeptzhuByIds(Integer[] ids)
    {
        return deptzhuMapper.deleteDeptzhuByIds(ids);
    }

    /**
     * 删除成型方式分组信息
     *
     * @param id 成型方式分组主键
     * @return 结果
     */
    @Override
    public int deleteDeptzhuById(Integer id)
    {
        return deptzhuMapper.deleteDeptzhuById(id);
    }
}
