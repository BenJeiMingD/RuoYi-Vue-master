package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyDeptsalesexcel;

/**
 * 填报派单Service接口
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
public interface ICyDeptsalesexcelService 
{
    /**
     * 查询填报派单
     * 
     * @param id 填报派单主键
     * @return 填报派单
     */
    public CyDeptsalesexcel selectCyDeptsalesexcelById(Integer id);

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 填报派单集合
     */
    public List<CyDeptsalesexcel> selectCyDeptsalesexcelList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 新增填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    public int insertCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 修改填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    public int updateCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的填报派单主键集合
     * @return 结果
     */
    public int deleteCyDeptsalesexcelByIds(Integer[] ids);

    /**
     * 删除填报派单信息
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    public int deleteCyDeptsalesexcelById(Integer id);
}
