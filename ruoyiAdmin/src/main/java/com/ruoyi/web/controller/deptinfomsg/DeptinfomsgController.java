package com.ruoyi.web.controller.deptinfomsg;

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
import com.ruoyi.system.domain.Deptinfomsg;
import com.ruoyi.system.service.IDeptinfomsgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-08-19
 */
@RestController
@RequestMapping("/system/deptinfomsg")
public class DeptinfomsgController extends BaseController
{
    @Autowired
    private IDeptinfomsgService deptinfomsgService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deptinfomsg deptinfomsg)
    {
        startPage();
        List<Deptinfomsg> list = deptinfomsgService.selectDeptinfomsgList(deptinfomsg);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptinfomsg deptinfomsg)
    {
        List<Deptinfomsg> list = deptinfomsgService.selectDeptinfomsgList(deptinfomsg);
        ExcelUtil<Deptinfomsg> util = new ExcelUtil<Deptinfomsg>(Deptinfomsg.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptinfomsgService.selectDeptinfomsgById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptinfomsg deptinfomsg)
    {
        return toAjax(deptinfomsgService.insertDeptinfomsg(deptinfomsg));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptinfomsg deptinfomsg)
    {
        return toAjax(deptinfomsgService.updateDeptinfomsg(deptinfomsg));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:deptinfomsg:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptinfomsgService.deleteDeptinfomsgByIds(ids));
    }
}
