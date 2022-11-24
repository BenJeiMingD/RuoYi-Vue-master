package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.*;
import org.springframework.data.repository.query.Param;

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
     * 调用存储过程
     * 传入时间
     * @param
     * @return 插单集合
     */
    public String execuStoredprocedure(@Param("startTime") Date startTime);
    /**
     * 调用存储过程
     * 传入时间
     * @param
     * @return 插单集合
     */
    public String execuStoredprocedureX(@Param("startTime") Date startTime);
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
     * @param cyWdsumcon 汇总表数据
     * @return 插单集合
     */
    public List<CyWdsumcon> selectCyDeptExWanCoBin(CyWdsumcon cyWdsumcon);

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
     * 删除万达表
     *
     * @param
     * @return 结果
     */
    public int deleteCyDeptwanda();

    /**
     * 批量删除插单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptwandaByIds(Integer[] ids);
}
