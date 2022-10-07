package com.ruoyi.web.controller.deptsumzi;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.service.ICyDeptwandaService;
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
import com.ruoyi.system.domain.Deptsumzi;
import com.ruoyi.system.service.IDeptsumziService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门汇总子Controller
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@RestController
@RequestMapping("/system/deptsumzi")
public class DeptsumziController extends BaseController
{
    @Autowired
    private IDeptsumziService deptsumziService;
    @Autowired
    private ICyDeptwandaService cyDeptwandaService;

    /**
     * 查询部门汇总子列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deptsumzi deptsumzi)
    {
        startPage();
        List<Deptsumzi> list = deptsumziService.selectDeptsumziList(deptsumzi);
        return getDataTable(list);
    }

    /**
     * 导出部门汇总子列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:export')")
    @Log(title = "部门汇总子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptsumzi deptsumzi)
    {
        List<Deptsumzi> list = deptsumziService.selectDeptsumziList(deptsumzi);
        ExcelUtil<Deptsumzi> util = new ExcelUtil<Deptsumzi>(Deptsumzi.class);
        util.exportExcel(response, list, "部门汇总子数据");
    }

    /**
     * 获取部门汇总子详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptsumziService.selectDeptsumziById(id));
    }

    /**
     * 新增部门汇总子
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:add')")
    @Log(title = "部门汇总子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptsumzi deptsumzi)
    {
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        Integer deptsumziId = deptsumzi.getId();
        cyDeptwanda.setDeptsumziId(deptsumziId);
        int rows = cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
        int insertDeptsumzi = deptsumziService.insertDeptsumzi(deptsumzi);
        if (insertDeptsumzi!=rows){
            return toAjax(0);
        }
        return toAjax(rows);
    }

    /**
     * 修改部门汇总子
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:edit')")
    @Log(title = "部门汇总子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptsumzi deptsumzi)
    {
        return toAjax(deptsumziService.updateDeptsumzi(deptsumzi));
    }

    /**
     * 删除部门汇总子
     */
    @PreAuthorize("@ss.hasPermi('system:deptsumzi:remove')")
    @Log(title = "部门汇总子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptsumziService.deleteDeptsumziByIds(ids));
    }
}
