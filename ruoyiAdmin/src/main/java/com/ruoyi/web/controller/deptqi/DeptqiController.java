package com.ruoyi.web.controller.deptqi;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 - 期数Controller
 -
 - @author ruoyi
 - @date 2022-08-17
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
public class DeptqiController extends BaseController {
    @Autowired
    private IDeptqiService deptqiService;
    @Autowired
    private IDeptsumService deptsumService;
    @Autowired
    private IDeptzhuService deptzhuService;
    @Autowired
    private IDeptformService deptformService;
    @Autowired
    private ICyDeptpoService deptpoService;
    @Autowired
    private ICyDeptwandaService cyDeptwandaService;
    @Autowired
    private ICySkewService cySkewService;
    @Autowired
    private ICyCompleterptrcvxService completerptrcvxService;

    /**
     - 查询期数列表
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deptqi deptqi)
    {
    startPage();
    List<Deptqi> list = deptqiService.selectDeptqiList(deptqi);
    return getDataTable(list);
    }
  *//**
     - 导出期数列表
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:export')")
    @Log(title = "期数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deptqi deptqi)
    {
    List<Deptqi> list = deptqiService.selectDeptqiList(deptqi);
    ExcelUtil<Deptqi> util = new ExcelUtil<Deptqi>(Deptqi.class);
    util.exportExcel(response, list, "期数数据");
    }
  *//**
     - 获取期数详细信息
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
    return AjaxResult.success(deptqiService.selectDeptqiById(id));
    }
  *//**
     - 新增期数
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:add')")
    @Log(title = "期数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deptqi deptqi)
    {
    return toAjax(deptqiService.insertDeptqi(deptqi));
    }
  *//**
     - 修改期数
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:edit')")
    @Log(title = "期数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deptqi deptqi)
    {
    return toAjax(deptqiService.updateDeptqi(deptqi));
    }
  *//**
     - 删除期数
     *//*
    @PreAuthorize("@ss.hasPermi('deptqi:deptqi:remove')")
    @Log(title = "期数", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
    return toAjax(deptqiService.deleteDeptqiByIds(ids));
    }
*/

    /**
     * - 新增产能模板日期详细信息子接口
     */
    /*@PreAuthorize("@ss.hasPermi('capacity:template')")
    @Log(title = "产能模板数据详细信息子接口", businessType = BusinessType.INSERT)*/
    @RequestMapping("/capacity/templatedate")
    public AjaxResult template(@RequestBody String string) {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("Data");
        Deptqi deptqi = JSON.toJavaObject(jsonObject, Deptqi.class);
        System.out.println("deptqi = " + deptqi);
        Date startTime = deptqi.getStartTime();
        String userName = deptqi.getUsername();
        if (startTime==null||userName==null){
            return AjaxResult.error(500,"数据没有填写");
        }
        //填入日期的时间,年份
        int year = startTime.getYear() + 1900;
        deptqi.setYearCode(year);//将年号插入，将开始时间，结束时间插入
        int rows = deptqiService.insertDeptqi(deptqi);//调一次插入，其余都是更新
        Integer deptqiId = deptqi.getId();//期数表的id--自动生成
        //这里是返回期表id--将主键id传给期表（需要一年开始以1期开始）
        Calendar instance = Calendar.getInstance();//获取系统当前年份
        int SystemYear = instance.get(Calendar.YEAR);
        System.out.println("instance = " + instance.get(Calendar.YEAR));//2022
        /**
         * 从期比表中查询 年号所对应的期号最大值 +1
         *
         */
        Integer issueNumber = null;
        Deptqi Issue = deptqiService.MaxIssueNumber(year);
        if (Issue!=null){
            Integer IssueNum = Issue.getIssueNumber();
            issueNumber = IssueNum+1;
        }
        else {
            issueNumber = 1;
        }
        deptqi.setIssueNumber(issueNumber);
        rows = deptqiService.updateDeptqi(deptqi);
        if (rows!=0){
            return toAjax(rows, deptqiId, issueNumber);
        }else {
            return AjaxResult.error("操作失败");
        }
        /*//默认初始值1
        List<Deptqi> deptqis = deptqiService.selectDeptqiList(new Deptqi());
        if (deptqis.size() == 1) {//说明没有数据 为1期===这里先插入后更新
            IssueNumber=1;
            deptqi.setIssueNumber(IssueNumber);
            int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
            if (row != rows) {
                rows = 0;
            }
            return toAjax(rows, deptqiId, IssueNumber);//当数据库无信息时
        }
        if (deptqis.size() > 1 && year == SystemYear) {
            Integer issueNumber = deptqis.get(deptqis.size() - 2).getIssueNumber();//获取他的最近一条的期数 +1
            IssueNumber = issueNumber += 1;//当有数据时；查找最近一期加1
            deptqi.setIssueNumber(IssueNumber);
            int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
            if (row != rows) {
                rows = 0;
            }
            return toAjax(rows, deptqiId, IssueNumber);
        }
        if (deptqis.size() > 1 && year != SystemYear) {//输入不同年份
            ++Number ;//将期号置为1
            deptqi.setIssueNumber(Number);
            int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
            if (row != rows) {
                rows = 0;
            }
            return toAjax(rows, deptqiId, Number);
        }
        return null;*/
    }

    /**
     * - 删除期数
     * /*@PreAuthorize("@ss.hasPermi('deptqi:deptqi:remove')")
     *
     * @Log(title = "期数", businessType = BusinessType.DELETE)
     * @DeleteMapping("/{ids}")
     */
    @PostMapping("/capacity/templatedelete/delete")
    public AjaxResult remove(@RequestBody String string) {
        System.out.println("cyDeptpo = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        Deptqi deptqi = JSON.toJavaObject(jsonObject, Deptqi.class);
        Integer id = deptqi.getId();
        Deptform deptform = new Deptform();
        deptform.setDeptqiId(id);
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        if (deptforms.size()!=0){//说明不可以删除
            return AjaxResult.error("操作失败",500);
        }
        else {
            CyDeptpo cyDeptpo = new CyDeptpo();
            cyDeptpo.setDeptqiId(id);
            Integer[] array2=null;
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<CyDeptpo> cyDeptpos = deptpoService.selectCyDeptpoList(cyDeptpo);
            if (cyDeptpos.size()!=0){
                for (int i = 0; i < cyDeptpos.size(); i++) {
                    Integer deptpoId = cyDeptpos.get(i).getDeptpoId();
                    arrayList.add(deptpoId);
                }
                array2 = arrayList.toArray(new Integer[arrayList.size()]);//将arrays转成list
                int ids = deptpoService.deleteCyDeptpoByDeptpoIds(array2);
            }
            cyDeptwandaService.deleteCyDeptwanda();
            return toAjax(deptqiService.deleteDeptqiById(id));
        }
    }
    /*单独 传入时间进行--执行存储过程 ==测试*/
    @PostMapping("/capacity/templatedelete/GetTime")
    public AjaxResult GetTime(@RequestBody String string) {
        System.out.println("cyDeptpo = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        Deptqi deptqi = JSON.toJavaObject(jsonObject, Deptqi.class);
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
                /*设置上期排产量，设置完工数量*/
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
        return AjaxResult.success("时间获取成功", 200);
    }


    /*@DeleteMapping("/capacity/templatedelete/delete/{id}")
    public AjaxResult remove(@PathVariable Integer id) {
        Deptform deptform = new Deptform();
        deptform.setDeptqiId(id);
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        if (deptforms.size()!=0){//说明不可以删除
            return AjaxResult.error("操作失败",500);
        }
        else {
            CyDeptpo cyDeptpo = new CyDeptpo();
            cyDeptpo.setDeptqiId(id);
            Integer[] array2=null;
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<CyDeptpo> cyDeptpos = deptpoService.selectCyDeptpoList(cyDeptpo);
            if (cyDeptpos.size()!=0){
                for (int i = 0; i < cyDeptpos.size(); i++) {
                    Integer deptpoId = cyDeptpos.get(i).getDeptpoId();
                    arrayList.add(deptpoId);
                }
                array2 = arrayList.toArray(new Integer[arrayList.size()]);//将arrays转成list
                int ids = deptpoService.deleteCyDeptpoByDeptpoIds(array2);
            }
            return toAjax(deptqiService.deleteDeptqiById(id));
        }

    }*/

    /**
     * - 修改期数 -编辑
     *
     * @param deptqi
     * @return
     */
    /*@PreAuthorize("@ss.hasPermi('deptqi:deptqi:edit')")
   @Log(title = "期数", businessType = BusinessType.UPDATE)*/
    @RequestMapping("/capacity/templatedelete/update")
    public AjaxResult edit(@RequestBody Deptqi deptqi) {
        CyDeptpo cyDeptpo = new CyDeptpo();
        cyDeptpo.setDeptqiId(deptqi.getId());
        List<CyDeptpo> cyDeptpos = deptpoService.selectCyDeptpoList(cyDeptpo);
        if (cyDeptpos != null){
            return toAjax(0);
        }
        return toAjax(deptqiService.updateDeptqi(deptqi));
    }

    /**
     * - 查询期数列表
     * @param deptqi
     * @return
     */
    /*@PreAuthorize("@ss.hasPermi('deptqi:deptqi:list')")*/
    @RequestMapping("/capacity/templatedelete/select")
    public TableDataInfo list(Deptqi deptqi)
    {
        List<Deptqi> list = deptqiService.selectDeptqiList(deptqi);

        return getDataTable(list);
    }

}