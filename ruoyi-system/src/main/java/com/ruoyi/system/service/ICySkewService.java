package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CySkew;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface ICySkewService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CySkew selectCySkewById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cySkew 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CySkew> selectCySkewList(CySkew cySkew);

    /**
     * 查询【上期排产量】列表
     *
     * @param cySkew 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CySkew> selectSkewYear(CySkew cySkew);

    /**
     * 查询【上期排产量】列表
     *
     * @param cySkew 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CySkew> CySkewView(CySkew cySkew);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cySkew 【请填写功能名称】
     * @return 结果
     */
    public int insertCySkew(CySkew cySkew);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cySkew 【请填写功能名称】
     * @return 结果
     */
    public int updateCySkew(CySkew cySkew);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCySkewByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCySkewById(Long id);
}
