package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyDeptorderinsert;

/**
 * 填报派单插单Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-16
 */
public interface CyDeptorderinsertMapper
{
    /**
     * 查询填报派单插单
     *
     * @param id 填报派单插单主键
     * @return 填报派单插单
     */
    public CyDeptorderinsert selectCyDeptorderinsertById(Integer id);

    /**
     * 查询填报派单插单列表
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 填报派单插单集合
     */
    public List<CyDeptorderinsert> selectCyDeptorderinsertList(CyDeptorderinsert cyDeptorderinsert);

    /**
     * 新增填报派单插单
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 结果
     */
    public int insertCyDeptorderinsert(CyDeptorderinsert cyDeptorderinsert);

    /**
     * 修改填报派单插单
     *
     * @param cyDeptorderinsert 填报派单插单
     * @return 结果
     */
    public int updateCyDeptorderinsert(CyDeptorderinsert cyDeptorderinsert);

    /**
     * 删除填报派单插单
     *
     * @param id 填报派单插单主键
     * @return 结果
     */
    public int deleteCyDeptorderinsertById(Integer id);

    /**
     * 批量删除填报派单插单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptorderinsertByIds(Integer[] ids);
}
