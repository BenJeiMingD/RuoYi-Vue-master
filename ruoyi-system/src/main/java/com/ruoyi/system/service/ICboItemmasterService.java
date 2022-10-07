package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CboItemmaster;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-08-26
 */
public interface ICboItemmasterService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CboItemmaster selectCboItemmasterById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CboItemmaster> selectCboItemmasterList(CboItemmaster cboItemmaster);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 结果
     */
    public int insertCboItemmaster(CboItemmaster cboItemmaster);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 结果
     */
    public int updateCboItemmaster(CboItemmaster cboItemmaster);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteCboItemmasterByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCboItemmasterById(Long id);
}
