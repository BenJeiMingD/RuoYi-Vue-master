package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BaseOrganizationTrlMapper;
import com.ruoyi.system.domain.BaseOrganizationTrl;
import com.ruoyi.system.service.IBaseOrganizationTrlService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-24
 */
@Service
public class BaseOrganizationTrlServiceImpl implements IBaseOrganizationTrlService 
{
    @Autowired
    private BaseOrganizationTrlMapper baseOrganizationTrlMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public BaseOrganizationTrl selectBaseOrganizationTrlById(Long id)
    {
        return baseOrganizationTrlMapper.selectBaseOrganizationTrlById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BaseOrganizationTrl> selectBaseOrganizationTrlList(BaseOrganizationTrl baseOrganizationTrl)
    {
        return baseOrganizationTrlMapper.selectBaseOrganizationTrlList(baseOrganizationTrl);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBaseOrganizationTrl(BaseOrganizationTrl baseOrganizationTrl)
    {
        return baseOrganizationTrlMapper.insertBaseOrganizationTrl(baseOrganizationTrl);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBaseOrganizationTrl(BaseOrganizationTrl baseOrganizationTrl)
    {
        return baseOrganizationTrlMapper.updateBaseOrganizationTrl(baseOrganizationTrl);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBaseOrganizationTrlByIds(Long[] ids)
    {
        return baseOrganizationTrlMapper.deleteBaseOrganizationTrlByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBaseOrganizationTrlById(Long id)
    {
        return baseOrganizationTrlMapper.deleteBaseOrganizationTrlById(id);
    }
}
