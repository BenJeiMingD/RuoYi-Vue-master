package com.ruoyi.web.controller.deptform;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.CyDeptsalesexcel;
import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.domain.Deptform;
import com.ruoyi.system.service.ICyDeptsalesexcelService;
import com.ruoyi.system.service.ICyDeptwandaService;
import com.ruoyi.system.service.IDeptformService;
import com.ruoyi.system.service.impl.CyDeptsalesexcelServiceImpl;
import com.ruoyi.web.controller.cydeptSalesExcel.CyDeptsalesexcelController;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 填报派单Controller
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/deptform")*/
public class DeptformController extends BaseController
{
    @Autowired
    private IDeptformService deptformService;
    @Autowired
    private ICyDeptwandaService cyDeptwandaService;
    @Autowired
    private ICyDeptsalesexcelService cyDeptsalesexcelService;

    /**
     * 查询填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:list')")*/
    @RequestMapping("/system/deptform/list")
    public TableDataInfo list(Deptform deptform)
    {
        /*String userName = deptform.getUserName();
        CyDeptsalesexcel cyDeptsalesexcel = new CyDeptsalesexcel();
        cyDeptsalesexcel.setUserName(userName);//按理需要根据期号和用户名进行合并查询
        List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        if (cyDeptsalesexcels.size()==0){
        }*/
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        return getDataTable(list);
    }

    /**
     * 导出填报派单列表
     */
    @PreAuthorize("@ss.hasPermi('system:deptform:export')")
    @Log(title = "填报派单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptform deptform)
    {
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        ExcelUtil<Deptform> util = new ExcelUtil<Deptform>(Deptform.class);
        util.exportExcel(response, list, "填报派单数据");
    }

    /**
     * 获取填报派单详细信息
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptformService.selectDeptformById(id));
    }
*/
    /**
     * 新增填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:add')")
    @Log(title = "填报派单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptform deptform)
    {
        //派单表和派单信息表
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        Integer id = deptform.getId();
        cyDeptwanda.setDeptformId(id);
        int insertCyDeptwanda = cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
        int insertDeptform = deptformService.insertDeptform(deptform);
        if (insertDeptform!=insertCyDeptwanda){
            return toAjax(0);
        }
        return toAjax(insertDeptform);
    }*/

    /**
     * 修改填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:edit')")
    @Log(title = "填报派单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptform deptform)
    {
        return toAjax(deptformService.updateDeptform(deptform));
    }
*/
    /**
     * 删除填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:remove')")
    @Log(title = "填报派单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptformService.deleteDeptformByIds(ids));
    }*/
}
