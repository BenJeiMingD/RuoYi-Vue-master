package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptproductMapper;
import com.ruoyi.system.domain.Deptproduct;
import com.ruoyi.system.service.IDeptproductService;

import javax.annotation.Resource;

/**
 * 物料产能对照Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-23
 */
@Service
public class DeptproductServiceImpl implements IDeptproductService
{
    @Resource
    private DeptproductMapper deptproductMapper;

    /**
     * 查询物料产能对照
     *
     * @param id 物料产能对照主键
     * @return 物料产能对照
     */
    @Override
    public Deptproduct selectDeptproductById(Integer id)
    {
        return deptproductMapper.selectDeptproductById(id);
    }

    /**
     * 查询物料产能对照列表
     *
     * @param deptproduct 物料产能对照
     * @return 物料产能对照
     */
    @Override
    public List<Deptproduct> selectDeptproductList(Deptproduct deptproduct)
    {

        // 每页展示的个数：pageSize
        // 起始页数：pageNum
        Integer pageNum=deptproduct.getPackage();
        int pageSize = 30;
        PageHelper.startPage(pageNum, pageSize);
        List<Deptproduct> deptproducts = deptproductMapper.selectDeptproductList(deptproduct);
        return deptproducts;
    }

    /**
     * 新增物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    @Override
    public int insertDeptproduct(Deptproduct deptproduct)
    {
        return deptproductMapper.insertDeptproduct(deptproduct);
    }

    /**
     * 修改物料产能对照
     *
     * @param deptproduct 物料产能对照
     * @return 结果
     */
    @Override
    public int updateDeptproduct(Deptproduct deptproduct)
    {
        return deptproductMapper.updateDeptproduct(deptproduct);
    }

    /**
     * 批量删除物料产能对照
     *
     * @param ids 需要删除的物料产能对照主键
     * @return 结果
     */
    @Override
    public int deleteDeptproductByIds(Integer[] ids)
    {
        return deptproductMapper.deleteDeptproductByIds(ids);
    }

    /**
     * 删除物料产能对照信息
     *
     * @param id 物料产能对照主键
     * @return 结果
     */
    @Override
    public int deleteDeptproductById(Integer id)
    {
        return deptproductMapper.deleteDeptproductById(id);
    }

    @Override
    public  List<Deptproduct> LegalJudgment() {

        //从数据库中获取集合size，id
        List<Deptproduct> deptproducts = deptproductMapper.selectDeptproductSizeIdList();
        System.out.println("deptproducts = " + deptproducts);
        return null;
    }
}
