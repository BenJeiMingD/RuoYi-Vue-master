package com.ruoyi.system.service;

import java.math.BigDecimal;
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
     * 查询填报派单列表
     *
     * @param cyDeptsalesexcel 填报派单
     * @return 填报派单集合
     */
    public List<CyDeptsalesexcel> selectCyDeptSummaryList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询 个人需求
     *
     * @param  cyDeptsalesexcel 用户名，issueNumber 期号 --计算出除个人外的需求和
     * @return 填报派单集合
     */
    public CyDeptsalesexcel selectsumXqList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询 个人需求
     *
     * @param  cyDeptsalesexcel 处传入 返回主参能的累计类型
     * @return 填报派单集合
     */
    public List<CyDeptsalesexcel> selectGroupsumList(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 查询本组的当期最大产能
     *
     * @param
     * @return 填报派单集合
     */
    public Integer selectsumZhuList();

    /**
     * 新增填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    public int insertCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel);

    /**
     * 新增填报派单
     *
     * @param cyDeptsalesexcel 填报派单 --批量删除
     * @return 结果
     */
    public List<Integer> insertBatch(List<CyDeptsalesexcel> cyDeptsalesexcel);

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

    /**
     * 删除填报派单信息
     *
     * @return 整表删除结果
     */
    public int deleteFrom();
}
