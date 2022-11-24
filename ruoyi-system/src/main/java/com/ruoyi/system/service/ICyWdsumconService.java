package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyWdsumcon;

/**
 * 查询Service接口
 *
 * @author Life
 * @date 2022-11-11
 */
public interface ICyWdsumconService
{
    /**
     * 查询查询
     *
     * @param id 查询主键
     * @return 查询
     */
    public CyWdsumcon selectCyWdsumconById(Long id);

    /**
     * 查询查询列表
     *
     * @param cyWdsumcon 查询
     * @return 查询集合
     */
    public List<CyWdsumcon> selectCyWdsumconList(CyWdsumcon cyWdsumcon);

    /**
     * 新增查询
     *
     * @param cyWdsumcon 查询
     * @return 结果
     */
    public int insertCyWdsumcon(CyWdsumcon cyWdsumcon);

    /**
     * 修改查询
     *
     * @param cyWdsumcon 查询
     * @return 结果
     */
    public int updateCyWdsumcon(CyWdsumcon cyWdsumcon);

    /**
     * 批量删除查询
     *
     * @param ids 需要删除的查询主键集合
     * @return 结果
     */
    public int deleteCyWdsumconByIds(Long[] ids);

    /**
     * 删除查询信息
     *
     * @param
     * @return 结果
     */
    public int deleteCyWdsumconById();
}
