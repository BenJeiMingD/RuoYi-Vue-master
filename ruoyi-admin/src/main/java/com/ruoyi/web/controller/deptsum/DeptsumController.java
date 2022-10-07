package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
/*@RequestMapping("/system/depsum")*/
public class DeptsumController extends BaseController
{
    @Autowired
    private IDeptsumService deptsumService;

    /**
     * 查询合并汇总列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:depsum:list')")*/
    @GetMapping("/system/depsum")
    public TableDataInfo list(Deptsum deptsum)
    {
        startPage();
        List<Deptsum> list = deptsumService.selectDeptsumList(deptsum);
        return getDataTable(list);
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

    /**
     * 新增合并汇总
     */
    /*@PreAuthorize("@ss.hasPermi('system:depsum:add')")
    @Log(title = "合并汇总", businessType = BusinessType.INSERT)
    @PostMapping*/
    /*public AjaxResult add(@RequestBody Deptsum deptsum)
    {
        return toAjax(deptsumService.insertDeptsum(deptsum));
    }*/

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
