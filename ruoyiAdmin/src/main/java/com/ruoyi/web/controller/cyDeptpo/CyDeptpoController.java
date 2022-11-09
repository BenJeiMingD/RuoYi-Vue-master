package com.ruoyi.web.controller.cyDeptpo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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

    @Autowired
    private ICySkewService cySkewService;
    @Autowired
    private ICyCompleterptrcvxService completerptrcvxService;

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

        System.out.println("cyDeptpo = " + string);
        JSONObject jsonObjects = JSON.parseObject(string).getJSONObject("data");
        Deptqi deptqi = JSON.toJavaObject(jsonObjects, Deptqi.class);
        Date startTime = deptqi.getStartTime();
        if (startTime != null) {//执行完存储过程
            cyDeptwandaService.deleteCyDeptwanda();
            deptqiService.AsyncService(startTime);
            //查询出·cyCompleterptrcvxes表的所有数据，进行遍历比对
            List<CyCompleterptrcvx> cyCompleterptrcvxes = completerptrcvxService.selectCyCompleterptrcvxList(new CyCompleterptrcvx());
            Integer issueNumber = deptqi.getIssueNumber();//期号
            Deptqi deptqi1 = new Deptqi();
            deptqi1.setIssueNumber(issueNumber);
            List<Deptqi> deptqis = deptqiService.selectDeptqiList(deptqi1);
            Integer yearCode = deptqis.get(0).getYearCode();//年号
            CySkew cySkew = new CySkew();
            if (deptqis.size()==1){//说明只有一期
                cySkew.setImportno(issueNumber.longValue());//期号
                cySkew.setImportyear(yearCode.toString());//年号
            }
            if (issueNumber-1==0&&deptqis.size()>1){//说明有多期,是一年的一期，需要查询上一年的最后一期
                yearCode = yearCode -1;
                Deptqi deptQI = deptqiService.MaxIssueNumber(yearCode);//查询出上一年的最大一期
                issueNumber = deptQI.getIssueNumber();
                cySkew.setImportno(issueNumber.longValue());//期号
                cySkew.setImportyear(yearCode.toString());//年号
            }
            List<CySkew> cySkews = cySkewService.CySkewView(cySkew);//这里传入期号和对应的年号 --这里使用的视图
            String t3 = null;
            BigDecimal qty = null;
            Integer nightShift =null;
            Integer dayShift = null;
            Integer noonShift = null;
            Integer sum = 0;
            //对远程表进行查询将结果更新到本地表---（帆软-万达）
            List<SheetOption> list = new ArrayList<>();
            CyDeptwanda cyDeptwanda = new CyDeptwanda();
            List<CyDeptwanda> listw = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
            List<String> tempIdList = listw.stream().map(CyDeptwanda::getSaleslineId).collect(Collectors.toList());
            List<CySkew> tempList = cySkews.stream().filter(item->tempIdList.contains(item.getSalesLineId())).collect(Collectors.toList());
            HashMap<String, Integer> dayMap = new HashMap<>();
            HashMap<String, Integer> nightMap = new HashMap<>();
            HashMap<String, Integer> noonMap = new HashMap<>();
            for (int j = 0; j < tempList.size(); j++) {//每次遍历销售行，对工时进行累加
                if (!dayMap.containsKey(tempList.get(j).getSalesLineId())) {
                    dayMap.put(tempList.get(j).getSalesLineId(), 0);
                }
                Integer dayCount = dayMap.get(tempList.get(j).getSalesLineId()) + (tempList.get(j).getDayShift() != null ? tempList.get(j).getDayShift() : 0);
                dayMap.put(tempList.get(j).getSalesLineId(), dayCount);

                if (!nightMap.containsKey(tempList.get(j).getSalesLineId())) {
                    nightMap.put(tempList.get(j).getSalesLineId(), 0);
                }
                Integer nightCount = nightMap.get(tempList.get(j).getSalesLineId()) + (tempList.get(j).getNightShift() != null ? tempList.get(j).getNightShift() : 0);
                nightMap.put(tempList.get(j).getSalesLineId(), nightCount);

                if (!noonMap.containsKey(tempList.get(j).getSalesLineId())) {
                    noonMap.put(tempList.get(j).getSalesLineId(), 0);
                }
                Integer noonCount = noonMap.get(tempList.get(j).getSalesLineId()) + (tempList.get(j).getNoonShift() != null ? tempList.get(j).getNoonShift() : 0);
                noonMap.put(tempList.get(j).getSalesLineId(), noonCount);
            }
            for (int i = 0; i < listw.size(); i++) {//获取他的行数id--i--r
                Date modifiedon = listw.get(i).getModifiedon();
                String demandname = listw.get(i).getDemandname();//需求分类
                String code = listw.get(i).getCode();//料号
                String name = listw.get(i).getName();
                String plmname2 = listw.get(i).getPlmname2();
                String seibancode = listw.get(i).getSeibancode();//番号
                String descflexfieldPubdescseg32 = listw.get(i).getDescflexfieldPubdescseg32();
                Integer shuliang = listw.get(i).getShuliang();
                String descflexfieldPrivatedescseg7 = listw.get(i).getDescflexfieldPrivatedescseg7();
                String descflexfieldPrivatedescseg9 = listw.get(i).getDescflexfieldPrivatedescseg9();
                String saleslineId = listw.get(i).getSaleslineId();
                t3 = listw.get(i).getT3();
                Integer day = dayMap.get(saleslineId);
                Integer night = nightMap.get(saleslineId);
                Integer noon = noonMap.get(saleslineId);
                if (day==null){day=0;}
                if (night==null){night=0;}
                if (noon==null){noon=0;}
                sum = day+night+noon;//上期排产量
                //*设置上期排产量，设置完工数量*//*
                //完工数量 --获取code，demandname，seibancode -找到 唯一的完工数量 qty
                for (int r = 0; r < cyCompleterptrcvxes.size(); r++) {
                    if (code.equals(cyCompleterptrcvxes.get(r).getCode()) && demandname.equals(cyCompleterptrcvxes.get(r).getRcvlotno()) && seibancode.equals(cyCompleterptrcvxes.get(r).getSeibancode())) {
                        qty = cyCompleterptrcvxes.get(r).getQty();}}
                //将从虚表中查询出来==插入到实表
                //执行到此处 sqpc和 t3 均已赋值完毕
                Integer ljpc = sum ;
                cyDeptwanda.setModifiedon(modifiedon);
                cyDeptwanda.setDemandname(demandname);
                cyDeptwanda.setCode(code);
                cyDeptwanda.setName(name);
                cyDeptwanda.setPlmname2(plmname2);
                cyDeptwanda.setSeibancode(seibancode);
                cyDeptwanda.setDescflexfieldPubdescseg32(descflexfieldPubdescseg32);
                cyDeptwanda.setShuliang(shuliang);
                cyDeptwanda.setLjpc(ljpc);//可排产量
                cyDeptwanda.setT3(t3);//上期排产量
                cyDeptwanda.setQty(qty);
                cyDeptwanda.setDescflexfieldPrivatedescseg7(descflexfieldPrivatedescseg7);
                cyDeptwanda.setDescflexfieldPrivatedescseg9(descflexfieldPrivatedescseg9);
                cyDeptwanda.setSaleslineId(saleslineId);
                CyDeptwanda deptwanda1 = new CyDeptwanda();
                deptwanda1.setSaleslineId(saleslineId);//saleslineId通过这个判断当前缓存表中是否有重复
                if (cyDeptwandaService.selectBySaleslineIdList(deptwanda1).size() == 0) {
                    cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);}//插入listw次
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
