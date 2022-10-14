package com.ruoyi.web.controller.deptform;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICyDeptsalesexcelService;
import com.ruoyi.system.service.ICyDeptwandaService;
import com.ruoyi.system.service.IDeptformService;
import com.ruoyi.system.service.IDeptqiService;
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
    @Autowired
    private IDeptqiService deptqiService;
    /**
     * 查询填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:list')")*/
    @RequestMapping("/system/deptform/list")
    public TableDataInfo list(Deptform deptform)
    {
        /*Deptform deptform = new Deptform();
        deptform.setDeptqiId(deptqiId);
        deptform.setStartTime(deptqi.getStartTime());
        deptform.setEndTime(deptqi.getEndTime());
        deptform.setUserName(userName);
        deptform.setConfirmedBy(userName);
        deptform.setCreateBy(userName);
        deptform.setIssueNumber(Number);
        rows = deptformService.insertDeptform(deptform);//将数据更新到派单填报表*/
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        return getDataTable(list);
    }
    /**
     * 查询填报派单列表
     */
    @RequestMapping("/system/deptform/listAdd")
    public Object listAdd(@RequestBody String string)
    {
        System.out.println("deptform = " + string);

        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        List<Deptqi> deptqis = deptqiService.selectDeptqiList(new Deptqi());
        Integer id = deptqis.get(deptqis.size() - 1).getId();
        char deptOrder = deptqis.get(deptqis.size() - 1).getDeptOrder();
        deptform.setDeptqiId(id);
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        if (deptOrder!='1'){//说明重复添加--没有生成
            return 0;
        }else {
            deptform.setDeptqiId(id);
            deptform.setStartTime(deptqis.get(deptqis.size()-1).getStartTime());
            deptform.setEndTime(deptqis.get(deptqis.size()-1).getEndTime());
            Integer issueNumber = deptqis.get(deptqis.size() - 1).getIssueNumber();
            deptform.setIssueNumber(issueNumber);
            List<Deptform> listFirst = deptformService.selectDeptformList(deptform);
            if (listFirst.size()==0){
                deptformService.insertDeptform(deptform);//将数据更新到派单填报表
                List<Deptform> list = deptformService.selectDeptformList(deptform);
                return getDataTable(list);
            }if(listFirst!=null){
                if (issueNumber==listFirst.get(listFirst.size()-1).getIssueNumber()){
                    return null;
                }
            }
            return null;
        }
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
    /*@PreAuthorize("@ss.hasPermi('system:deptform:edit')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.UPDATE)*/
    @PutMapping("/system/deptform/listUpdate")
    public AjaxResult edit(@RequestBody String string)
    {
        System.out.println("deptform = " + string);
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        return toAjax(deptformService.updateDeptform(deptform));
    }

    /**
     * 删除填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:remove')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.DELETE)*/
	@DeleteMapping("/system/deptform/{id}")
    public AjaxResult remove(@PathVariable Integer id)
    {
        Deptform deptform = deptformService.selectDeptformById(id);
        String userName = deptform.getUserName();
        Integer issueNumber = deptform.getIssueNumber();
        CyDeptsalesexcel cyDeptsalesexcel = new CyDeptsalesexcel();
        cyDeptsalesexcel.setIssueNumber(issueNumber);
        cyDeptsalesexcel.setUserName(userName);
        //批量删除
        Integer[] array2=null;
        ArrayList<Integer> objects = new ArrayList<>();
        List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        if (cyDeptsalesexcels.size()!=0){
        for (int i = 0; i < cyDeptsalesexcels.size(); i++) {
            Integer id1 = cyDeptsalesexcels.get(i).getId();
            objects.add(id1);
        }
        array2 = objects.toArray(new Integer[objects.size()]);//将arrays转成list
        cyDeptsalesexcelService.deleteCyDeptsalesexcelByIds(array2);
        }
        int row1 = deptformService.deleteDeptformById(id);
        return toAjax(row1);
    }
}
