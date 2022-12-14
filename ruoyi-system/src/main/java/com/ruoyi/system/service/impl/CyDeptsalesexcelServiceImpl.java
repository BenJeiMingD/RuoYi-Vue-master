package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Deptproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyDeptsalesexcelMapper;
import com.ruoyi.system.domain.CyDeptsalesexcel;
import com.ruoyi.system.service.ICyDeptsalesexcelService;

import javax.annotation.Resource;

/**
 * 填报派单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class CyDeptsalesexcelServiceImpl implements ICyDeptsalesexcelService
{
    @Resource
    private CyDeptsalesexcelMapper cyDeptsalesexcelMapper;



    /**
     * 查询填报派单
     * 
     * @param id 填报派单主键
     * @return 填报派单
     */
    @Override
    public CyDeptsalesexcel selectCyDeptsalesexcelById(Integer id)
    {
        return cyDeptsalesexcelMapper.selectCyDeptsalesexcelById(id);
    }

    /**
     * 查询填报派单列表
     * 
     * @param cyDeptsalesexcel 填报派单 --查询的时候回传入用户名和期号
     * @return 填报派单
     */
    @Override
    public List<CyDeptsalesexcel> selectCyDeptsalesexcelList(CyDeptsalesexcel cyDeptsalesexcel)
    {
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();
        return cyDeptsalesexcelMapper.selectCyDeptsalesexcelList(cyDeptsalesexcel);
    }

    @Override
    public List<CyDeptsalesexcel> selectCyDeptSummaryList(CyDeptsalesexcel cyDeptsalesexcel) {
        return cyDeptsalesexcelMapper.selectCyDeptSummaryList(cyDeptsalesexcel);
    }

    @Override
    public CyDeptsalesexcel selectsumXqList(CyDeptsalesexcel cyDeptsalesexcel) {
        return cyDeptsalesexcelMapper.selectsumXqList(cyDeptsalesexcel);
    }

    @Override
    public List<CyDeptsalesexcel> selectGroupsumList(CyDeptsalesexcel cyDeptsalesexcel) {
        return cyDeptsalesexcelMapper.selectGroupsumList(cyDeptsalesexcel);
    }

    @Override
    public Integer selectsumZhuList() {
        return cyDeptsalesexcelMapper.selectsumZhuList();
    }


    /**
     * 新增填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    @Override
    public int insertCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel)
    {
        return cyDeptsalesexcelMapper.insertCyDeptsalesexcel(cyDeptsalesexcel);
    }

    @Override
    public List<Integer> insertBatch(List<CyDeptsalesexcel> cyDeptsalesexcel) {
        return cyDeptsalesexcelMapper.insertBatch(cyDeptsalesexcel);
    }

    /**
     * 修改填报派单
     * 
     * @param cyDeptsalesexcel 填报派单
     * @return 结果
     */
    @Override
    public int updateCyDeptsalesexcel(CyDeptsalesexcel cyDeptsalesexcel)
    {
        return cyDeptsalesexcelMapper.updateCyDeptsalesexcel(cyDeptsalesexcel);
    }

    /**
     * 批量删除填报派单
     * 
     * @param ids 需要删除的填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsalesexcelByIds(Integer[] ids)
    {
        return cyDeptsalesexcelMapper.deleteCyDeptsalesexcelByIds(ids);
    }

    /**
     * 删除填报派单信息
     * 
     * @param id 填报派单主键
     * @return 结果
     */
    @Override
    public int deleteCyDeptsalesexcelById(Integer id)
    {
        return cyDeptsalesexcelMapper.deleteCyDeptsalesexcelById(id);
    }

    @Override
    public int deleteFrom() {

        return cyDeptsalesexcelMapper.deleteFrom();
    }
}
