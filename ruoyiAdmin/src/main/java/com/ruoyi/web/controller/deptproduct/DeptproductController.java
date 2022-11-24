package com.ruoyi.web.controller.deptproduct;

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
import com.ruoyi.system.domain.Deptproduct;
import com.ruoyi.system.service.IDeptproductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料产能对照Controller
 *
 * @author ruoyi
 * @date 2022-10-18
 */
@RestController
@RequestMapping("/system/deptproduct")
public class DeptproductController extends BaseController
{
    @Autowired
    private IDeptproductService deptproductService;

    /**
     * 查询物料产能对照列表
     */
    //@PreAuthorize("@ss.hasPermi('system:deptproduct:list')")
    @GetMapping("/list")//开发接口
    public TableDataInfo list(Deptproduct deptproduct)
    {
        startPage();
        List<Deptproduct> list = deptproductService.selectDeptproductList(deptproduct);
        return getDataTable(list);
    }

    /**
     * 导出物料产能对照列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptproduct:export')")
    @Log(title = "物料产能对照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptproduct deptproduct)
    {
        List<Deptproduct> list = deptproductService.selectDeptproductList(deptproduct);
        ExcelUtil<Deptproduct> util = new ExcelUtil<Deptproduct>(Deptproduct.class);
        util.exportExcel(response, list, "物料产能对照数据");
    }

    /**
     * 获取物料产能对照详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptproduct:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptproductService.selectDeptproductById(id));
    }

    /**
     * 新增物料产能对照
     */
    @PreAuthorize("@ss.hasPermi('system:deptproduct:add')")
    @Log(title = "物料产能对照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptproduct deptproduct)
    {
        return toAjax(deptproductService.insertDeptproduct(deptproduct));
    }

    /**
     * 修改物料产能对照
     */
    @PreAuthorize("@ss.hasPermi('system:deptproduct:edit')")
    @Log(title = "物料产能对照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptproduct deptproduct)
    {
        return toAjax(deptproductService.updateDeptproduct(deptproduct));
    }

    /**
     * 删除物料产能对照
     */
    @PreAuthorize("@ss.hasPermi('system:deptproduct:remove')")
    @Log(title = "物料产能对照", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptproductService.deleteDeptproductByIds(ids));
    }
}
