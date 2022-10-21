package com.ruoyi.web.controller.cyDeptpozi;

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
import com.ruoyi.system.domain.CyDeptpoZi;
import com.ruoyi.system.service.ICyDeptpoZiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成型方式分组信息子Controller
 *
 * @author ruoyi
 * @date 2022-09-19
 */
@RestController
@RequestMapping("/system/zi")
public class CyDeptpoZiController extends BaseController
{
    @Autowired
    private ICyDeptpoZiService cyDeptpoZiService;

    /**
     * 查询成型方式分组信息子列表
     */
    @PreAuthorize("@ss.hasPermi('system:zi:list')")
    @GetMapping("/list")
    public TableDataInfo list(CyDeptpoZi cyDeptpoZi)
    {
        startPage();
        List<CyDeptpoZi> list = cyDeptpoZiService.selectCyDeptpoZiList(cyDeptpoZi);
        return getDataTable(list);
    }

    /**
     * 导出成型方式分组信息子列表
     */
    @PreAuthorize("@ss.hasPermi('system:zi:export')")
    @Log(title = "成型方式分组信息子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptpoZi cyDeptpoZi)
    {
        List<CyDeptpoZi> list = cyDeptpoZiService.selectCyDeptpoZiList(cyDeptpoZi);
        ExcelUtil<CyDeptpoZi> util = new ExcelUtil<CyDeptpoZi>(CyDeptpoZi.class);
        util.exportExcel(response, list, "成型方式分组信息子数据");
    }

    /**
     * 获取成型方式分组信息子详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zi:query')")
    @GetMapping(value = "/{deptpoziId}")
    public AjaxResult getInfo(@PathVariable("deptpoziId") Integer deptpoziId)
    {
        return AjaxResult.success(cyDeptpoZiService.selectCyDeptpoZiByDeptpoziId(deptpoziId));
    }

    /**
     * 新增成型方式分组信息子
     */
    @PreAuthorize("@ss.hasPermi('system:zi:add')")
    @Log(title = "成型方式分组信息子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyDeptpoZi cyDeptpoZi)
    {
        return toAjax(cyDeptpoZiService.insertCyDeptpoZi(cyDeptpoZi));
    }

    /**
     * 修改成型方式分组信息子
     */
    @PreAuthorize("@ss.hasPermi('system:zi:edit')")
    @Log(title = "成型方式分组信息子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptpoZi cyDeptpoZi)
    {
        return toAjax(cyDeptpoZiService.updateCyDeptpoZi(cyDeptpoZi));
    }

    /**
     * 删除成型方式分组信息子
     */
    @PreAuthorize("@ss.hasPermi('system:zi:remove')")
    @Log(title = "成型方式分组信息子", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptpoziIds}")
    public AjaxResult remove(@PathVariable Integer[] deptpoziIds)
    {
        return toAjax(cyDeptpoZiService.deleteCyDeptpoZiByDeptpoziIds(deptpoziIds));
    }
}
