package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyDeptwandaconbin;

/**
 * 万达jsonMapper接口
 *
 * @author ruoyi
 * @date 2022-10-13
 */
public interface CyDeptwandaconbinMapper
{
    /**
     * 查询万达json
     *
     * @param id 万达json主键
     * @return 万达json
     */
    public CyDeptwandaconbin selectCyDeptwandaconbinById(Integer id);

    /**
     * 查询万达json列表
     *
     * @param cyDeptwandaconbin 万达json
     * @return 万达json集合
     */
    public List<CyDeptwandaconbin> selectCyDeptwandaconbinList(CyDeptwandaconbin cyDeptwandaconbin);

    /**
     * 新增万达json
     *
     * @param cyDeptwandaconbin 万达json
     * @return 结果
     */
    public int insertCyDeptwandaconbin(CyDeptwandaconbin cyDeptwandaconbin);

    /**
     * 修改万达json
     *
     * @param cyDeptwandaconbin 万达json
     * @return 结果
     */
    public int updateCyDeptwandaconbin(CyDeptwandaconbin cyDeptwandaconbin);

    /**
     * 删除万达json
     *
     * @param id 万达json主键
     * @return 结果
     */
    public int deleteCyDeptwandaconbinById(Integer id);

    /**
     * 批量删除万达json
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyDeptwandaconbinByIds(Integer[] ids);
}
