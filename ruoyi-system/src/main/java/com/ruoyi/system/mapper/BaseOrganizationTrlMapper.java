package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BaseOrganizationTrl;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-24
 */
public interface BaseOrganizationTrlMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BaseOrganizationTrl selectBaseOrganizationTrlById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BaseOrganizationTrl> selectBaseOrganizationTrlList(BaseOrganizationTrl baseOrganizationTrl);

    /**
     * 新增【请填写功能名称】
     *
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 结果
     */
    public int insertBaseOrganizationTrl(BaseOrganizationTrl baseOrganizationTrl);

    /**
     * 修改【请填写功能名称】
     *
     * @param baseOrganizationTrl 【请填写功能名称】
     * @return 结果
     */
    public int updateBaseOrganizationTrl(BaseOrganizationTrl baseOrganizationTrl);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBaseOrganizationTrlById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseOrganizationTrlByIds(Long[] ids);
}
