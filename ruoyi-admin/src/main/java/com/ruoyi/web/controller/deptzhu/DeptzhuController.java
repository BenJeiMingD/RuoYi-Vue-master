package com.ruoyi.web.controller.deptzhu;
import com.alibaba.druid.pool.ha.selector.RandomDataSourceValidateThread;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IDeptproductService;
import com.ruoyi.system.service.IDeptzhuService;
import com.ruoyi.system.service.IDeptziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**

 - 成型方式分组Controller

 -

 - @author ruoyi

 - @date 2022-08-17
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
public class DeptzhuController extends BaseController
{
    @Autowired
    private IDeptzhuService deptzhuService;

    @Autowired
    private IDeptziService deptziService;
    /**

     - 查询成型方式分组列表
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deptzhu deptzhu)
    {
        startPage();
        List<Deptzhu> list = deptzhuService.selectDeptzhuList(deptzhu);
        return getDataTable(list);
    }

    *//**

     - 导出成型方式分组列表
     *//*
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:export')")
    @Log(title = "成型方式分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptzhu deptzhu)
    {
        List<Deptzhu> list = deptzhuService.selectDeptzhuList(deptzhu);
        ExcelUtil<Deptzhu> util = new ExcelUtil<Deptzhu>(Deptzhu.class);
        util.exportExcel(response, list, "成型方式分组数据");
    }

    *//**

     - 获取成型方式分组详细信息
     *//*
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(deptzhuService.selectDeptzhuById(id));
    }

    *//**

     - 新增成型方式分组
     *//*
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:add')")
    @Log(title = "成型方式分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptzhu deptzhu)
    {
        return toAjax(deptzhuService.insertDeptzhu(deptzhu));
    }

    *//**

     - 修改成型方式分组
     *//*
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:edit')")
    @Log(title = "成型方式分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptzhu deptzhu)
    {
        return toAjax(deptzhuService.updateDeptzhu(deptzhu));
    }

    *//**

     - 删除成型方式分组
     *//*
    @PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:remove')")
    @Log(title = "成型方式分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(deptzhuService.deleteDeptzhuByIds(ids));
    }*/

    /*
     - 新增产能模板接收
     */
    /*@PreAuthorize("@ss.hasPermi('capacity:template')")
    @Log(title = "产能模板接收", businessType = BusinessType.INSERT)*/
    @RequestMapping("/capacity/template")
    public AjaxResult template(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        System.out.println("newData = " + data);
        String rowData = data.getString("rowData");
        System.out.println("rowData = " + rowData);
        Deptzhu deptzhu = JSON.toJavaObject(rowData, Deptzhu.class);
        System.out.println("deptzhu = " + deptzhu);
        if (deptzhu.getType()!=null&&deptzhu.getClassification()!=null){
            int rows = deptzhuService.insertDeptzhu(deptzhu);
            Integer id = deptzhu.getId();
            return toAjax(rows,id);
        }
        return toAjax(0);
    }

    /**
     * - 修改成型方式分组
     * @param string 主表更新信息
     * @return 更新结果
     */
    /*@PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:edit')")*/
    /*@Log(title = "成型方式分组", businessType = BusinessType.UPDATE)*/
    @RequestMapping("/capacity/templateupdate")
    public AjaxResult edit(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        String rowData = jsonObject.getString("rowData");
        JSONObject jsonResult = JSON.parseObject(rowData);
        System.out.println("jsonArray = " + jsonResult.getJSONArray("children"));//获取到的子数据
        List<Deptzi> list = jsonResult.getList("children",Deptzi.class);
        System.out.println("list = " + list);
        /*DeptZhuAndZi deptZhuAndZi = JSON.toJavaObject(rowData, DeptZhuAndZi.class);*/
        Deptzi deptzi = JSON.toJavaObject(jsonResult, Deptzi.class);
        deptzi.setChildren(list);
        System.out.println("list2 = "+deptzi.getChildren());
        Deptzhu deptzhu = JSON.toJavaObject(jsonResult, Deptzhu.class);
        System.out.println("list2 = "+deptzhu);
        //主表id
        /*for (;;){
        }*/
        //对主表进行更新--因为目前更新一次只更新一张主表，所以主表不用循环
        /*Deptzhu deptzhu = new Deptzhu();*/
        Integer deptzhuId = deptzhu.getDeptzhuId();
        deptzhu.setId(deptzhuId);
        System.out.println("deptzhuId = " + deptzhu);
        int updateDeptzhu=0;
        if (deptzhuId==null){
            updateDeptzhu=0;
        }
        else {
            updateDeptzhu = deptzhuService.updateDeptzhu(deptzhu);
        }

        //子表id
        /*if ()
        //对产能子表进行更新
        Deptzi deptzi = new Deptzi();*/
        int updateDeptzi = 0;
        List children = deptzi.getChildren();

        for (int i =0;i<children.size();i++){
            Deptzi deptzii = JSON.toJavaObject(children.get(i), Deptzi.class);
            deptzii.setDeptzhuId(deptzhuId);//每次更新把对于的主表id加入
            System.out.println("children.get(i) = " + children.get(i));
            if (deptzii.getDeptzhuId()!=null){
                updateDeptzi = deptziService.updateDeptzi(deptzii);
            }else {
                return toAjax(0);
            }
        }
        if (updateDeptzhu!=updateDeptzi){
            return toAjax(0);
        }

        return toAjax(updateDeptzhu);
    }

    /**
     * - 导出成型方式分组列表
     * @param
     * @param selectDeptList
     */
    /*@PreAuthorize("@ss.hasPermi('deptzhu:deptzhu:export')")
    @Log(title = "成型方式分组", businessType = BusinessType.EXPORT)*/
    @RequestMapping("/capacity/template/selectDeptList")
    public Object list(SelectDeptList selectDeptList)
    {
        System.out.println("selectDeptList = " + selectDeptList);



        //所有的产能主表信息
        List<Deptzhu> responsed = deptzhuService.selectDeptzhuList(new Deptzhu());
        //所有的子表信息
        List<Deptzi> childrenlist = deptziService.selectDeptziList( new Deptzi());
        ArrayList<DeptZhuAnd> deptZhuAnds = new ArrayList<>();
        Integer id=null;
        for (int i =0;i<responsed.size();i++){
            ArrayList<Deptzi> list = new ArrayList<>();
            DeptZhuAnd deptZhuAnd = new DeptZhuAnd();
            id = responsed.get(i).getId();
            BigDecimal todayNumber = responsed.get(i).getTodayNumber();
            String type = responsed.get(i).getType();
            String classification = responsed.get(i).getClassification();
            Integer indexId = responsed.get(i).getIndexId();
            Integer level = responsed.get(i).getLevel();
            deptZhuAnd.setId(id);
            deptZhuAnd.setType(type);
            deptZhuAnd.setTodayNumber(todayNumber);
            deptZhuAnd.setIndexId(indexId);
            deptZhuAnd.setLevel(level);
            deptZhuAnd.setClassification(classification);
            for (int j=0;j<childrenlist.size();j++){
                Integer deptzhuId = childrenlist.get(j).getDeptzhuId();
                if (deptzhuId.equals(id)){
                        Deptzi deptzi = childrenlist.get(j);
                    System.out.println("deptzi = " + deptzi);
                        list.add(deptzi);
                    }
                deptZhuAnd.setChildren(list);
                ;//符合的数据逐条放入children的list
                }
            //将获取的数据放入list
            deptZhuAnds.add(deptZhuAnd);
        }
        return deptZhuAnds;
    }
}
