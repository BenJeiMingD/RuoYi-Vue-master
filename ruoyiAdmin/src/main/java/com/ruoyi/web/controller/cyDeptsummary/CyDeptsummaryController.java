package com.ruoyi.web.controller.cyDeptsummary;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.CyDeptsalesexcel;
import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.domain.Deptform;
import com.ruoyi.system.service.ICyDeptsalesexcelService;
import com.ruoyi.system.service.ICyDeptwandaService;
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
import com.ruoyi.system.domain.CyDeptsummary;
import com.ruoyi.system.service.ICyDeptsummaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 填报派单Controller
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
@RestController
@RequestMapping("/system/deptsummary")
public class CyDeptsummaryController extends BaseController
{
    @Autowired
    private ICyDeptsummaryService cyDeptsummaryService;

    @Autowired
    private IDeptformService deptformService;

    /**
     * 查询填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:list')")*/
    @GetMapping("cyDeptsummary/list")
    public TableDataInfo list(CyDeptsummary cyDeptsummary)
    {
        List<CyDeptsummary> list = cyDeptsummaryService.selectCyDeptsummaryList(cyDeptsummary);

        /*for (int i = 0; i < list.size(); i++) {
            cyDeptsummary.setModifiedon(cyDeptsalesexcel.getModifiedon());//16行基础数据
            cyDeptsummary.setDemandname(cyDeptsalesexcel.getDemandname());
            cyDeptsummary.setCode(cyDeptsalesexcel.getCode());
            cyDeptsummary.setName(cyDeptsalesexcel.getName());
            cyDeptsummary.setPlmname2(cyDeptsalesexcel.getPlmname2());
            cyDeptsummary.setSeibancode(cyDeptsalesexcel.getSeibancode());
            cyDeptsummary.setPlmname5(cyDeptsalesexcel.getPlmname5());
            cyDeptsummary.setPlmname3(cyDeptsalesexcel.getPlmname3());
            cyDeptsummary.setDescflexfieldPubdescseg32(cyDeptsalesexcel.getDescflexfieldPubdescseg32());
            cyDeptsummary.setShuliang(cyDeptsalesexcel.getShuliang());
            cyDeptsummary.setLjpc(cyDeptsalesexcel.getLjpc());
            cyDeptsummary.setT3(cyDeptsalesexcel.getT3());
            cyDeptsummary.setXq(cyDeptsalesexcel.getXq());
            cyDeptsummary.setMark(cyDeptsalesexcel.getMark());
            cyDeptsummary.setDescflexfieldPrivatedescseg7(cyDeptsalesexcel.getDescflexfieldPrivatedescseg7());
            cyDeptsummary.setDescflexfieldPrivatedescseg9(cyDeptsalesexcel.getDescflexfieldPrivatedescseg9());
            cyDeptsummary.setSaleslineId(cyDeptsalesexcel.getSaleslineId());
            cyDeptsummary.setName(cyDeptsalesexcel.getUserName());
            cyDeptsummary.setTodayNumber(cyDeptsalesexcel.getTodayNumber());//将主表的最大产能插入-----需要每改一次更新一次
        }*/
        return getDataTable(list);
    }

    /**
     * 导出填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:export')")
    @Log(title = "填报派单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptsummary cyDeptsummary)
    {
        List<CyDeptsummary> list = cyDeptsummaryService.selectCyDeptsummaryList(cyDeptsummary);
        ExcelUtil<CyDeptsummary> util = new ExcelUtil<CyDeptsummary>(CyDeptsummary.class);
        util.exportExcel(response, list, "填报派单数据");
    }*/

    /**
     * 获取填报派单详细信息
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cyDeptsummaryService.selectCyDeptsummaryById(id));
    }*/

    /**
     * 新增填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:add')")
    @Log(title = "填报派单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyDeptsummary cyDeptsummary)
    {
        return toAjax(cyDeptsummaryService.insertCyDeptsummary(cyDeptsummary));
    }*/

    /**
     * 修改填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:edit')")
    @Log(title = "填报派单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptsummary cyDeptsummary)
    {
        return toAjax(cyDeptsummaryService.updateCyDeptsummary(cyDeptsummary));
    }*/

    /**
     * 删除填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsummary:remove')")
    @Log(title = "填报派单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(cyDeptsummaryService.deleteCyDeptsummaryByIds(ids));
    }*/
}
