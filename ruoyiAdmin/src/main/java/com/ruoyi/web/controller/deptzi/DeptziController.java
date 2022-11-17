package com.ruoyi.web.controller.deptzi;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Deptzhu;
import com.ruoyi.system.domain.Deptzi;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 成型方式分组信息子Controller
 * 
 * @author ruoyi
 * @date 2022-08-17
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
public class DeptziController extends BaseController
{
    @Autowired
    private IDeptziService deptziService;
    @Autowired
    private IDeptproductService deptproductService;
    @Autowired
    private IDeptzhuService deptzhuService;

    /**
     - 新增产能模板数据详细信息子接口
     */
    /*@PreAuthorize("@ss.hasPermi('capacity:template')")
    @Log(title = "产能模板数据详细信息子接口", businessType = BusinessType.INSERT)*/
    @RequestMapping("/capacity/templateInfo")
    public AjaxResult template(@RequestBody String string)
    {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        String data = jsonObject.getString("rowData");
        JSONObject jsonResult = JSON.parseObject(data);
        Deptzi deptzi = JSON.toJavaObject(data, Deptzi.class);
        if (deptzi.getSize()!=null&&deptzi.getType()!=null&&deptzi.getClassification()!=null&&deptzi.getDeptzhuId()!=null){
            int rows = deptziService.insertDeptzi(deptzi);
            Integer deptid = deptzi.getDeptId();//获取子表id
            return toAjax(rows,deptid);
        }
        return toAjax(0);
    }
    /**
     - 根据主子表删除信息
     - 实体类中包含主子id
     */
    @PostMapping ("/capacity/templatedelete")
    public AjaxResult templates(@RequestBody String string)
    {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        Deptzi deptzi = JSON.toJavaObject(jsonObject, Deptzi.class);
        System.out.println("deptzi = " + deptzi);
        int byId=0;
        Integer deptzhuId = deptzi.getDeptzhuId();//主id
        if (deptzhuId!=null){//只有一个组
            byId= deptzhuService.deleteDeptzhuById(deptzhuId);
        }
        if (deptzi.getDeptzis().length!=0){
            byId= deptziService.deleteDeptziByIds(deptzi.getDeptzis());
        }
        return toAjax(byId);
    }

}

