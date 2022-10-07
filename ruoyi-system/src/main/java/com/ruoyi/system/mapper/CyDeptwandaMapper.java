package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyDeptwanda;

/**
 * 插单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
public interface CyDeptwandaMapper 
{
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
     * 查询销售行id
     *
     * @param cyDeptwanda 销售行id
     * @return 插单集合
     */
    public List<CyDeptwanda> selectBySaleslineIdList(CyDeptwanda cyDeptwanda);
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
     * 删除插单
     * 
     * @param id 插单主键
     * @return 结果
     */
    public int deleteCyDeptwandaById(Integer id);

    /**
     * 批量删除插单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptwandaByIds(Integer[] ids);
}
