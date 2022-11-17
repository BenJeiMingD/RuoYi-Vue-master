package com.ruoyi.web.controller.cyDeptorderinsert;

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
import com.ruoyi.system.domain.CyDeptorderinsert;
import com.ruoyi.system.service.ICyDeptorderinsertService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 填报派单插单Controller
 *
 * @author ruoyi
 * @date 2022-11-16
 */
@RestController
@RequestMapping("/system/deptorderinsert")
public class CyDeptorderinsertController extends BaseController
{
    @Autowired
    private ICyDeptorderinsertService cyDeptorderinsertService;

    /**
     * 查询填报派单插单列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:list')")
    @GetMapping("/list")
    public TableDataInfo list(CyDeptorderinsert cyDeptorderinsert)
    {
        startPage();
        List<CyDeptorderinsert> list = cyDeptorderinsertService.selectCyDeptorderinsertList(cyDeptorderinsert);
        return getDataTable(list);
    }

    /**
     * 导出填报派单插单列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:export')")
    @Log(title = "填报派单插单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptorderinsert cyDeptorderinsert)
    {
        List<CyDeptorderinsert> list = cyDeptorderinsertService.selectCyDeptorderinsertList(cyDeptorderinsert);
        ExcelUtil<CyDeptorderinsert> util = new ExcelUtil<CyDeptorderinsert>(CyDeptorderinsert.class);
        util.exportExcel(response, list, "填报派单插单数据");
    }

    /**
     * 获取填报派单插单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cyDeptorderinsertService.selectCyDeptorderinsertById(id));
    }

    /**
     * 新增填报派单插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:add')")
    @Log(title = "填报派单插单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyDeptorderinsert cyDeptorderinsert)
    {
        return toAjax(cyDeptorderinsertService.insertCyDeptorderinsert(cyDeptorderinsert));
    }

    /**
     * 修改填报派单插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:edit')")
    @Log(title = "填报派单插单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptorderinsert cyDeptorderinsert)
    {
        return toAjax(cyDeptorderinsertService.updateCyDeptorderinsert(cyDeptorderinsert));
    }

    /**
     * 删除填报派单插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptorderinsert:remove')")
    @Log(title = "填报派单插单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(cyDeptorderinsertService.deleteCyDeptorderinsertByIds(ids));
    }
}
