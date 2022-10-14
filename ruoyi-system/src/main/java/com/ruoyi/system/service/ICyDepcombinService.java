package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyDepcombin;

/**
 * 合并汇总Service接口
 *
 * @author ruoyi
 * @date 2022-10-12
 */
public interface ICyDepcombinService
{
    /**
     * 查询合并汇总
     *
     * @param id 合并汇总主键
     * @return 合并汇总
     */
    public CyDepcombin selectCyDepcombinById(Integer id);

    /**
     * 查询合并汇总列表
     *
     * @param cyDepcombin 合并汇总
     * @return 合并汇总集合
     */
    public List<CyDepcombin> selectCyDepcombinList(CyDepcombin cyDepcombin);

    /**
     * 新增合并汇总
     *
     * @param cyDepcombin 合并汇总
     * @return 结果
     */
    public int insertCyDepcombin(CyDepcombin cyDepcombin);

    /**
     * 修改合并汇总
     *
     * @param cyDepcombin 合并汇总
     * @return 结果
     */
    public int updateCyDepcombin(CyDepcombin cyDepcombin);

    /**
     * 批量删除合并汇总
     *
     * @param ids 需要删除的合并汇总主键集合
     * @return 结果
     */
    public int deleteCyDepcombinByIds(Integer[] ids);

    /**
     * 删除合并汇总信息
     *
     * @param id 合并汇总主键
     * @return 结果
     */
    public int deleteCyDepcombinById(Integer id);
}
