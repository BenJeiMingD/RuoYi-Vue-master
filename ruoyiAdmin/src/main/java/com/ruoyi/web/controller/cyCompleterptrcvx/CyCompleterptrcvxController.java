package com.ruoyi.web.controller.cyCompleterptrcvx;

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
import com.ruoyi.system.domain.CyCompleterptrcvx;
import com.ruoyi.system.service.ICyCompleterptrcvxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@RestController
@RequestMapping("/system/completerptrcvx")
public class CyCompleterptrcvxController extends BaseController
{
    @Autowired
    private ICyCompleterptrcvxService cyCompleterptrcvxService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:list')")
    @GetMapping("/list")
    public TableDataInfo list(CyCompleterptrcvx cyCompleterptrcvx)
    {
        startPage();
        List<CyCompleterptrcvx> list = cyCompleterptrcvxService.selectCyCompleterptrcvxList(cyCompleterptrcvx);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyCompleterptrcvx cyCompleterptrcvx)
    {
        List<CyCompleterptrcvx> list = cyCompleterptrcvxService.selectCyCompleterptrcvxList(cyCompleterptrcvx);
        ExcelUtil<CyCompleterptrcvx> util = new ExcelUtil<CyCompleterptrcvx>(CyCompleterptrcvx.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:query')")
    @GetMapping(value = "/{rcvlotno}")
    public AjaxResult getInfo(@PathVariable("rcvlotno") String rcvlotno)
    {
        return AjaxResult.success(cyCompleterptrcvxService.selectCyCompleterptrcvxByRcvlotno(rcvlotno));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyCompleterptrcvx cyCompleterptrcvx)
    {
        return toAjax(cyCompleterptrcvxService.insertCyCompleterptrcvx(cyCompleterptrcvx));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyCompleterptrcvx cyCompleterptrcvx)
    {
        return toAjax(cyCompleterptrcvxService.updateCyCompleterptrcvx(cyCompleterptrcvx));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:completerptrcvx:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rcvlotnos}")
    public AjaxResult remove(@PathVariable String[] rcvlotnos)
    {
        return toAjax(cyCompleterptrcvxService.deleteCyCompleterptrcvxByRcvlotnos(rcvlotnos));
    }
}
