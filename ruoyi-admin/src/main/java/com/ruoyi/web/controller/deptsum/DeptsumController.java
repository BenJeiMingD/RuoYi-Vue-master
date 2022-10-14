package com.ruoyi.web.controller.deptsum;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Deptform;
import com.ruoyi.system.service.IDeptformService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Deptsum;
import com.ruoyi.system.service.IDeptsumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合并汇总Controller
 *
 * @author ruoyi
 * @date 2022-09-26
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/depsum")*/
public class DeptsumController extends BaseController
{
    @Autowired
    private IDeptsumService deptsumService;

    @Autowired
    private IDeptformService deptformService;

    /**
     * 查询合并汇总列表 --查询往期数据
     */
    /*@PreAuthorize("@ss.hasPermi('system:depsum:list')")*/
    @GetMapping("/system/deptsum")
    public TableDataInfo list(Deptsum deptsum)
    {

        /*Deptform deptform = new Deptform();
        List<Deptsum> list =null;
        Integer state = null;
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        List<Deptsum> deptsumFirst = deptsumService.selectDeptsumList(deptsum);
        //复制派单确认表到汇总表
        for (int i = 0; i < deptforms.size(); i++) {
            Integer issueNumber = deptforms.get(i).getIssueNumber();
            Date startTime = deptforms.get(i).getStartTime();
            Date endTime = deptforms.get(i).getEndTime();
            state = deptforms.get(i).getState();
            Date confirmedTime = deptforms.get(i).getConfirmedTime();
            String confirmedBy = deptforms.get(i).getConfirmedBy();
            deptsum.setConfirmedBy(confirmedBy);
            deptsum.setEndTime(endTime);
            deptsum.setStartTime(startTime);
            deptsum.setIssueNumber(issueNumber);
            deptsum.setState(state);
            deptsum.setConfirmedTime(confirmedTime);
            deptsumService.insertDeptsum(deptsum);
        }
        Deptsum deptsum1 = new Deptsum();*/
        List<Deptsum> deptsums = deptsumService.selectDeptsumList(deptsum);
        return getDataTable(deptsums);
    }

    /**
     * 导出合并汇总列表
    @PreAuthorize("@ss.hasPermi('system:depsum:export')")
    @Log(title = "合并汇总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptsum deptsum)
    {
        List<Deptsum> list = deptsumService.selectDeptsumList(deptsum);
        ExcelUtil<Deptsum> util = new ExcelUtil<Deptsum>(Deptsum.class);
        util.exportExcel(response, list, "合并汇总数据");
    }*/
    /**
     * 获取合并汇总详细信息
     */
    /*@PreAuthorize("@ss.hasPermi('system:depsum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptsumService.selectDeptsumById(id));
    }*/
    /*新增合并汇总*/
    /*@PreAuthorize("@ss.hasPermi('system:depsum:add')")*/
    /*@Log(title = "合并汇总", businessType = BusinessType.INSERT)*/
    @RequestMapping ("/inster/deptsum")
    public Object Insterlistadd(Deptsum deptsum)
    {
        Deptform deptform = new Deptform();
        List<Deptsum> list =null;
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        List<Deptsum> deptsumFirst = deptsumService.selectDeptsumList(deptsum);
        //只新增最后一条
        //复制派单确认表到汇总表
            Integer issueNumber = deptforms.get(deptforms.size()-1).getIssueNumber();
            Date startTime = deptforms.get(deptforms.size()-1).getStartTime();
            Date endTime = deptforms.get(deptforms.size()-1).getEndTime();
            Integer state = deptforms.get(deptforms.size() - 1).getState();
            Date confirmedTime = deptforms.get(deptforms.size()-1).getConfirmedTime();
            String confirmedBy = deptforms.get(deptforms.size()-1).getConfirmedBy();
            deptsum.setConfirmedBy(confirmedBy);
            deptsum.setEndTime(endTime);
            deptsum.setStartTime(startTime);
            deptsum.setIssueNumber(issueNumber);
            deptsum.setState(state);
            deptsum.setConfirmedTime(confirmedTime);
        List<Deptsum> deptsu = deptsumService.selectDeptsumList(deptsum);
        //如果有一期就不新增
        if (deptsu.size()==0){
            int row= deptsumService.insertDeptsum(deptsum);
            if (row==1 ){
                List<Deptsum> deptsums = deptsumService.selectDeptsumList(deptsum);
                Integer id = deptsums.get(deptsums.size() - 1).getId();
                return (deptsumService.selectDeptsumById(id));
            }
        }else {
            for (int i = 0; i < deptsu.size(); i++) {
                Integer issueNumber1 = deptsu.get(i).getIssueNumber();
                if (issueNumber1==issueNumber){
                    return 0;
                }
                else {
                    int row= deptsumService.insertDeptsum(deptsum);
                    if (row==1 ){
                        List<Deptsum> deptsums = deptsumService.selectDeptsumList(deptsum);
                        Integer id = deptsums.get(deptsums.size() - 1).getId();
                        return (deptsumService.selectDeptsumById(id));
                    }
                }
            }
        }
        return null;
    }
    /**
     * 修改合并汇总
     */
    /*@PreAuthorize("@ss.hasPermi('system:depsum:edit')")
    @Log(title = "合并汇总", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptsum deptsum)
    {
        return toAjax(deptsumService.updateDeptsum(deptsum));
    }
*/
    /**
     * 删除合并汇总
     *//*
    @PreAuthorize("@ss.hasPermi('system:depsum:remove')")
    @Log(title = "合并汇总", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptsumService.deleteDeptsumByIds(ids));
    }*/
}
