package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyWdsumconMapper;
import com.ruoyi.system.domain.CyWdsumcon;
import com.ruoyi.system.service.ICyWdsumconService;

/**
 * 查询Service业务层处理
 *
 * @author Life
 * @date 2022-11-11
 */
@Service
public class CyWdsumconServiceImpl implements ICyWdsumconService
{
    @Autowired
    private CyWdsumconMapper cyWdsumconMapper;

    /**
     * 查询查询
     *
     * @param id 查询主键
     * @return 查询
     */
    @Override
    public CyWdsumcon selectCyWdsumconById(Long id)
    {
        return cyWdsumconMapper.selectCyWdsumconById(id);
    }

    /**
     * 查询查询列表
     *
     * @param cyWdsumcon 查询
     * @return 查询
     */
    @Override
    public List<CyWdsumcon> selectCyWdsumconList(CyWdsumcon cyWdsumcon)
    {
        return cyWdsumconMapper.selectCyWdsumconList(cyWdsumcon);
    }

    /**
     * 新增查询
     *
     * @param cyWdsumcon 查询
     * @return 结果
     */
    @Override
    public int insertCyWdsumcon(CyWdsumcon cyWdsumcon)
    {
        return cyWdsumconMapper.insertCyWdsumcon(cyWdsumcon);
    }

    /**
     * 修改查询
     *
     * @param cyWdsumcon 查询
     * @return 结果
     */
    @Override
    public int updateCyWdsumcon(CyWdsumcon cyWdsumcon)
    {
        return cyWdsumconMapper.updateCyWdsumcon(cyWdsumcon);
    }

    /**
     * 批量删除查询
     *
     * @param ids 需要删除的查询主键
     * @return 结果
     */
    @Override
    public int deleteCyWdsumconByIds(Long[] ids)
    {
        return cyWdsumconMapper.deleteCyWdsumconByIds(ids);
    }

    /**
     * 删除查询信息
     *
     * @param id 查询主键
     * @return 结果
     */
    @Override
    public int deleteCyWdsumconById(Long id)
    {
        return cyWdsumconMapper.deleteCyWdsumconById(id);
    }
}
