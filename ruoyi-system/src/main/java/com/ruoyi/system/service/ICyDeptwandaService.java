package com.ruoyi.system.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.domain.CyWdsumcon;
import com.ruoyi.system.domain.Deptqi;

/**
 * 插单Service接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface ICyDeptwandaService 
{
    /**
     * 查询销售行id
     * 
     * @param cyDeptwanda 销售行id
     * @return id
     */
    public List<CyDeptwanda> selectBySaleslineIdList(CyDeptwanda cyDeptwanda);

    /**
     * 执行存储过程
     *
     * @param
     * @return 插单
     */
    public String execuStoredprocedure(Date startTime);

    /**
     * 执行存储过程
     *
     * @param
     * @return 插单
     */
    public String execuStoredprocedureX(Date startTime);

    /**
     * 查询插单
     *
     * @param id 插单主键
     * @return 插单
     */
    public CyDeptwanda selectCyDeptwandaById(Integer id);

    /**
     * 查询插单列表
     * 
     * @param cyDeptwanda 插单
     * @return 插单集合
     */
    public List<CyDeptwanda> selectCyDeptwandaList(CyDeptwanda cyDeptwanda);

    /**
     * 查询插单列表
     *
     * @param cyWdsumcon 汇总表
     * @return 插单集合
     */
    public List<CyWdsumcon> selectCyDeptExWanCoBin(CyWdsumcon cyWdsumcon);

    /**
     * 新增插单
     * 
     * @param cyDeptwanda 插单
     * @return 结果
     */
    public int insertCyDeptwanda(CyDeptwanda cyDeptwanda);

    /**
     * 修改插单
     * 
     * @param cyDeptwanda 插单
     * @return 结果
     */
    public int updateCyDeptwanda(CyDeptwanda cyDeptwanda);

    /**
     * 批量删除插单
     * 
     * @param ids 需要删除的插单主键集合
     * @return 结果
     */
    public int deleteCyDeptwandaByIds(Integer[] ids);

    /**
     * 删除插单信息
     * 
     * @param id 插单主键
     * @return 结果
     */
    public int deleteCyDeptwandaById(Integer id);
    /**
     * 删除插单信息
     *
     * @param
     * @return 结果
     */
    public int deleteCyDeptwanda();
}
