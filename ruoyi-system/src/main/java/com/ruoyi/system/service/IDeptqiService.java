package com.ruoyi.system.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.Deptqi;
import org.springframework.scheduling.annotation.Async;

/**
 * 期数Service接口
 *
 * @author ruoyi
 * @date 2022-08-19
 */
public interface IDeptqiService
{
    /**
     * 查询期数
     *
     * @param id 期数主键
     * @return 期数
     */
    public Deptqi selectDeptqiById(Integer id);

    /**
     * 执行存储过程
     *
     * @param startTime 提单日期
     * @return 期数
     */
    @Async
    public void AsyncService(Date startTime);

    /**
     * 查询当前年的最大期号
     *
     * @param yearCode 年号
     * @return 期数
     */
    public Deptqi MaxIssueNumber(Integer yearCode);

    /**
     * 查询期数列表
     *
     * @param deptqi 期数
     * @return 期数集合
     */
    public List<Deptqi> selectDeptqiList(Deptqi deptqi);

    /**
     * 新增期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    public int insertDeptqi(Deptqi deptqi);

    /**
     * 修改期数
     *
     * @param deptqi 期数
     * @return 结果
     */
    public int updateDeptqi(Deptqi deptqi);

    /**
     * 批量删除期数
     *
     * @param ids 需要删除的期数主键集合
     * @return 结果
     */
    public int deleteDeptqiByIds(Integer[] ids);

    /**
     * 删除期数信息
     *
     * @param id 期数主键
     * @return 结果
     */
    public int deleteDeptqiById(Integer id);
}
