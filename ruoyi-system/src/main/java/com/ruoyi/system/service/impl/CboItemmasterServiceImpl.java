package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CboItemmasterMapper;
import com.ruoyi.system.domain.CboItemmaster;
import com.ruoyi.system.service.ICboItemmasterService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-26
 */
@Service
public class CboItemmasterServiceImpl implements ICboItemmasterService 
{
    @Autowired
    private CboItemmasterMapper cboItemmasterMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public CboItemmaster selectCboItemmasterById(Long id)
    {
        return cboItemmasterMapper.selectCboItemmasterById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CboItemmaster> selectCboItemmasterList(CboItemmaster cboItemmaster)
    {
        return cboItemmasterMapper.selectCboItemmasterList(cboItemmaster);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCboItemmaster(CboItemmaster cboItemmaster)
    {
        return cboItemmasterMapper.insertCboItemmaster(cboItemmaster);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param cboItemmaster 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCboItemmaster(CboItemmaster cboItemmaster)
    {
        return cboItemmasterMapper.updateCboItemmaster(cboItemmaster);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCboItemmasterByIds(Long[] ids)
    {
        return cboItemmasterMapper.deleteCboItemmasterByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteCboItemmasterById(Long id)
    {
        return cboItemmasterMapper.deleteCboItemmasterById(id);
    }
}
