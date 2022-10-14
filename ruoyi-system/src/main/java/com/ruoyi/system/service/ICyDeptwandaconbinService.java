package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyDeptwandaconbin;

/**
 * 万达jsonService接口
 *
 * @author ruoyi
 * @date 2022-10-13
 */
public interface ICyDeptwandaconbinService
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
     * 批量删除万达json
     *
     * @param ids 需要删除的万达json主键集合
     * @return 结果
     */
    public int deleteCyDeptwandaconbinByIds(Integer[] ids);

    /**
     * 删除万达json信息
     *
     * @param id 万达json主键
     * @return 结果
     */
    public int deleteCyDeptwandaconbinById(Integer id);
}
