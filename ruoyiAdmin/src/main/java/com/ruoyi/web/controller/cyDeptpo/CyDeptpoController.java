package com.ruoyi.web.controller.cyDeptpo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.DeptziMapper;
import com.ruoyi.system.service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产能调整Controller
 *
 * @author ruoyi
 * @date 2022-09-08
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/deptpo")*/
public class CyDeptpoController extends BaseController
{
    @Autowired
    private ICyDeptpoService cyDeptpoService;

    @Autowired
    private IDeptziService deptziService;

    @Autowired
    private IDeptzhuService deptzhuService;

    @Autowired
    private IDeptqiService deptqiService;

    @Autowired
    private ICyDeptwandaService cyDeptwandaService;


    /**
     * 查询产能调整列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptpo:list')")*/
    /*@GetMapping("/deptpo/ids")
    public TableDataInfo ids(CyDeptpo cyDeptpo)
    {
        startPage();
        List<CyDeptpo> list = cyDeptpoService.selectCyDeptpoByDeptpoId(cyDeptpo);
        return getDataTable(list);
    }*/

    /**
     * 查询产能调整列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptpo:list')")*/
    @RequestMapping("/deptpo/list")
    public Object list(@RequestBody String string) //这里会传入期号：通过期号反查id
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data").getJSONObject("CyDeptpo");
        CyDeptpo cyDeptpo = JSON.toJavaObject(jsonObject, CyDeptpo.class);
        List<Deptzhu> responsed = deptzhuService.selectDeptzhuList(new Deptzhu());//查询的是组表
        List<CyDeptpo> childrenlist = cyDeptpoService.selectCyDeptpoList(cyDeptpo);
        Deptqi deptqi = new Deptqi();
        Integer issueNumber = cyDeptpo.getIssueNumber();
        deptqi.setIssueNumber(issueNumber);
        List<Deptqi> deptqis = deptqiService.selectDeptqiList(deptqi);//通过期号查询出他的天数
        BigDecimal duration = deptqis.get(0).getDuration();//查询出本期的首条数据的天数
        ArrayList<DeptQiAndZi> deptQiAndZis = new ArrayList<>();
        Integer id=null;

        for (int i =0;i<responsed.size();i++){
            ArrayList<CyDeptpo> list = new ArrayList<>();
            DeptQiAndZi deptQiAndZi = new DeptQiAndZi();
            id = responsed.get(i).getId();//查询出主表的id
            BigDecimal todayNumber = responsed.get(i).getTodayNumber();//主表的最大日产能
            String type = responsed.get(i).getType();
            String classification = responsed.get(i).getClassification();
            Integer indexId = responsed.get(i).getIndexId();
            Integer level = responsed.get(i).getLevel();
            deptQiAndZi.setId(id);
            deptQiAndZi.setType(type);
            deptQiAndZi.setSumProductive(responsed.get(i).getSumProductive());
            deptQiAndZi.setIssueNumber(cyDeptpo.getIssueNumber());//主表 的期号
            deptQiAndZi.setDuration(duration);
            deptQiAndZi.setTodayNumber(todayNumber);
            deptQiAndZi.setIndexId(indexId);
            deptQiAndZi.setLevel(level);
            deptQiAndZi.setClassification(classification);
            for (int j=0;j<childrenlist.size();j++){
                Integer deptzhuId = childrenlist.get(j).getDeptzhuId();
                if (deptzhuId.equals(id)){
                    CyDeptpo cyDeptpo1 = childrenlist.get(j);
                    list.add(cyDeptpo1);
                }
                deptQiAndZi.setChildren(list);
                ;//符合的数据逐条放入children的list
            }
            //将获取的数据放入list
            deptQiAndZis.add(deptQiAndZi);
        }
        return deptQiAndZis;
    }

    /**
     * 导出产能调整列表
     */
    @PreAuthorize("@ss.hasPermi('deptpo:export')")
    @Log(title = "产能调整", businessType = BusinessType.EXPORT)
    @RequestMapping("/deptpo/select")
    public void export(HttpServletResponse response, CyDeptpo cyDeptpo)
    {
        List<CyDeptpo> list = cyDeptpoService.selectCyDeptpoList(cyDeptpo);
        ExcelUtil<CyDeptpo> util = new ExcelUtil<CyDeptpo>(CyDeptpo.class);
        util.exportExcel(response, list, "产能调整数据");
    }

    /**
     * 获取产能调整详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptpo:query')")
    /*@GetMapping(value = "/{issueNumber}")*/
    public AjaxResult getInfo(@PathVariable("issueNumber") Integer issueNumber)
    {
        return AjaxResult.success(cyDeptpoService.selectCyDeptpoByDeptpoId(issueNumber));
    }

    /**
     * 新增产能调整 --确认生成接口
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptpo:add')")
    @Log(title = "产能调整", businessType = BusinessType.INSERT)*/
    @RequestMapping("/deptpo/insert")//新增的时候会传入期表表id---生成一期节点
    public AjaxResult add(@RequestBody String string)
    {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptpo cyDeptpo = JSON.toJavaObject(jsonObject, CyDeptpo.class);
        Integer deptqiId = cyDeptpo.getDeptqiId();
        Deptzi deptzi = new Deptzi();
        BigDecimal todayNumber=null;
        BigDecimal duration = null;
        List<Deptzi> deptzis = deptziService.selectDeptziList(deptzi);
        //点击确认生成，将期表是否生成产能表的状态置为 1；标记成有效
        Deptqi deptQi = new Deptqi();
        deptQi.setId(deptqiId);
        deptQi.setDeptOrder('1');
        deptqiService.updateDeptqi(deptQi);
            //汇制产能调整po表，产能主表
            for (int i = 0; i < deptzis.size(); i++) {//把所有的子表数据存入cyDeptpo
                CyDeptpo deptpo = new CyDeptpo();
                Deptproduct deptproduct = new Deptproduct();
                Integer size = deptzis.get(i).getSize();
                String type = deptzis.get(i).getType();
                Integer deptzhuId = deptzis.get(i).getDeptzhuId();//获取他的主表id
                Integer deptId = deptzis.get(i).getDeptId();
                Integer indexId = deptzis.get(i).getIndexId();
                Integer level = deptzis.get(i).getLevel();
                Deptzhu deptzhu = deptzhuService.selectDeptzhuById(deptzhuId);
                todayNumber = deptzis.get(i).getTodayNumber();//子表的最大日产能
                /*BigDecimal sumNumber = deptzis.get(i).getSumNumber();*/
                String classification = deptzis.get(i).getClassification();
                deptpo.setSize(size);
                deptpo.setType(type);
                deptpo.setDeptzhuId(deptzhuId);
                deptpo.setClassification(classification);
                deptpo.setTodayNumber(todayNumber);//主表的日产能
                deptpo.setDeptziId(deptId);
                deptpo.setLevel(level);
                deptpo.setIndexId(indexId);
                int insertCyDeptpo = cyDeptpoService.insertCyDeptpo(deptpo);//依次把产能子表插入返回对应的id --完成
                Integer integer = cyDeptpo.getDeptpoId();
                System.out.println("integer = " + integer);
                List<CyDeptpo> cyDeptpos = cyDeptpoService.selectCyDeptpoList(deptpo);
                for (int j = 0; j < cyDeptpos.size(); j++) {
                    if (cyDeptpos.get(j).getDeptqiId() == null) {//判断当前行的期id是否为null --最后填充期号
                        Deptqi deptqi = deptqiService.selectDeptqiById(deptqiId);//是的话反查 --前端请求会传入期id
                        Integer deptpoId = cyDeptpos.get(j).getDeptpoId();
                        if (deptqi == null) {
                            return toAjax(0);
                        }
                        duration = deptqi.getDuration();//插入天数
                        Integer issueNumber = deptqi.getIssueNumber();//插入期号
                        BigDecimal sumProductive = duration.multiply(deptzhu.getTodayNumber());//本期最大产能
                        BigDecimal sumtodayNumber = duration.multiply(todayNumber);//各子产能子表的最大期产能
                        cyDeptpo.setDeptqiId(deptqiId);
                        cyDeptpo.setDuration(duration);
                        cyDeptpo.setIssueNumber(issueNumber);
                        cyDeptpo.setSumProductive(sumProductive);
                        cyDeptpo.setSumZhu(sumtodayNumber);
                        cyDeptpo.setDeptpoId(deptpoId);
                        cyDeptpoService.updateCyDeptpo(cyDeptpo);
                        deptzhu.setId(deptzhuId);//将主表，id，更新入期最大产能，期表id，
                        deptzhu.setSumProductive(sumProductive);
                        deptzhu.setDeptqiId(deptqiId);
                        deptzhu.setIssueNumber(issueNumber);
                        deptzhuService.updateDeptzhu(deptzhu);
                    }
                }
            }
            return AjaxResult.success("操作成功",200);
    }
    /**
     * 修改产能调整
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptpo:edit')")
    @Log(title = "产能调整", businessType = BusinessType.UPDATE)*/
    @PostMapping("/system/deptpo/edit") //-- 这里会传入产能主表的id--对应产能主表的本期最大产能
    public AjaxResult edit(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptpo cyDeptpo = JSON.toJavaObject(jsonObject, CyDeptpo.class);

        BigDecimal sumProductive = cyDeptpo.getSumProductive();
        CyDeptpo deptpo = new CyDeptpo();
        Integer id = cyDeptpo.getId();
        deptpo.setDeptzhuId(id);//转换

        int rows = 0;
        List<CyDeptpo> cyDeptpos = cyDeptpoService.selectCyDeptpoList(deptpo);//这里查询出多个
        if (cyDeptpos.size()!=0){
            for (int i = 0; i < cyDeptpos.size(); i++) {
                Integer deptpoId = cyDeptpos.get(i).getDeptpoId();
                cyDeptpo.setDeptpoId(deptpoId);//--- 这里更新的内容有 : 产能调整表的id，主表id，最大的本组产能
                cyDeptpo.setSumProductive(sumProductive);
                Deptzhu deptzhu = new Deptzhu();
                deptzhu.setId(id);
                deptzhu.setSumProductive(sumProductive);
                deptzhuService.updateDeptzhu(deptzhu);
                cyDeptpoService.updateCyDeptpo(cyDeptpo);
            }
            return AjaxResult.success("操作成功",200);
        }else {
            return AjaxResult.error("操作失败");
        }
    }
    /**
     * 删除产能调整
     */
    @PreAuthorize("@ss.hasPermi('system:deptpo:remove')")
    @Log(title = "产能调整", businessType = BusinessType.DELETE)
	/*@DeleteMapping("/{issueNumbers}")*/
    public AjaxResult remove(@PathVariable Integer[] issueNumbers)
    {
        return toAjax(cyDeptpoService.deleteCyDeptpoByDeptpoIds(issueNumbers));
    }
}
