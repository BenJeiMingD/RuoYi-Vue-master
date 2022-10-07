package com.ruoyi.system.service.impl;
import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.system.domain.CyDeptpo;
import com.ruoyi.system.domain.Deptqi;
import com.ruoyi.system.domain.Deptzhu;
import com.ruoyi.system.mapper.CyDeptpoMapper;
import com.ruoyi.system.mapper.DeptqiMapper;
import com.ruoyi.system.mapper.DeptzhuMapper;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DeptziMapper;
import com.ruoyi.system.domain.Deptzi;
import com.ruoyi.system.service.IDeptziService;

import javax.annotation.Resource;

/**
 * 成型方式分组信息子Service业务层处理
 *
 * @author ruoyi
 * @date 2022-08-19
 */
@Service
public class DeptziServiceImpl implements IDeptziService
{
    @Resource
    private DeptziMapper deptziMapper;
    @Resource
    private CyDeptpoMapper cyDeptpoMapper;
    @Resource
    private DeptzhuMapper deptzhuMapper;
    @Resource
    private DeptqiMapper deptqiMapper;

    /**
     * 查询成型方式分组信息子
     *
     * @param deptId 成型方式分组信息子主键
     * @return 成型方式分组信息子
     */
    @Override
    public Deptzi selectDeptziById(Integer deptId)
    {
        return deptziMapper.selectDeptziById(deptId);
    }

    /**
     * 查询成型方式分组信息子列表
     *
     * @param deptzi 成型方式分组信息子
     * @return 成型方式分组信息子
     */
    @Override
    public List<Deptzi> selectDeptziList(Deptzi deptzi)
    {
        return deptziMapper.selectDeptziList(deptzi);
    }

    @Override
    public List<Deptzi> selectDeptziListDeptid(Integer deptzhuId) {
        return deptziMapper.selectDeptziListDeptid(deptzhuId);
    }

    /**
     * 新增成型方式分组信息子
     *
     * @param deptzi 成型方式分组信息子
     * @return 结果
     */
    @Override
    public int insertDeptzi(Deptzi deptzi)
    {
        int rows = deptziMapper.insertDeptzi(deptzi);//所有信息位置已经占好

        return rows;
    }

    /**
     * 修改成型方式分组信息子
     *
     * @param deptzi 成型方式分组信息子
     * @return 结果
     */
    @Override
    public int updateDeptzi(Deptzi deptzi)
    {

        int updateDeptzi = deptziMapper.updateDeptzi(deptzi);//更新的时候会更新填充整条信息

        return updateDeptzi;
    }

    /**
     * 批量删除成型方式分组信息子
     *
     * @param ids 需要删除的成型方式分组信息子主键
     * @return 结果
     */
    @Override
    public int deleteDeptziByIds(Integer[] ids)
    {
        return deptziMapper.deleteDeptziByIds(ids);
    }

    /**
     * 删除成型方式分组信息子信息
     *
     * @param deptId 成型方式分组信息子主键
     * @return 结果
     */
    @Override
    public int deleteDeptziById(Integer deptId)
    {
        return deptziMapper.deleteDeptziById(deptId);
    }
    /**
     *
     * @param deptId 成型方式分组信息子主键
     * @param deptzhuId 成型方式分组主键
     * @return 返回是否删除的信息
     */
    @Override
    public int deleteDeptziByIdst(Integer deptId, Integer deptzhuId) {
        if (deptzhuId!=null&&deptId!=null){
            return deptziMapper.deleteDeptziByIdst(deptId, deptzhuId);
        }
        else {
            if (deptzhuId!=null&&deptId==null){
                return deptzhuMapper.deleteDeptzhuById(deptzhuId);
            }
        }
        return 0;
    }

}
