package com.ruoyi.web.controller.deptqi;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
  //刻入静态变量，对本年进行记忆
  public static Integer IssueNumber = 0;
  //刻入静态变量，对次年进行记忆
  public static Integer Number = 0;
  //记录第一次请求的系统时间
  public static Integer sysYear = 0;


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
    int rows = deptqiService.insertDeptqi(deptqi);//调一次插入，其余都是更新
    Integer deptqiId = deptqi.getId();//期数表的id--自动生成
    Date startTime = deptqi.getStartTime();
    String userName = deptqi.getUsername();
    //填入日期的时间,年份
    int year = startTime.getYear() + 1900;
    //这里是返回期表id--将主键id传给期表（需要一年开始以1期开始）
    Calendar instance = Calendar.getInstance();//获取系统当前年份
    System.out.println("instance = " + instance.get(Calendar.YEAR));//2022

    /**
     * 1,当服务重启后，防止期号不连续
     * 2当服务重启后，防止期号不连续
     * 2,当输入年号和本年不符合；
     * 3,当重启后初始化年号；
     *
     */

    //默认初始值1


    List<Deptqi> deptqis = deptqiService.selectDeptqiList(deptqi);
    if (deptqis.get(deptqis.size()-1).getIssueNumber()==null){
      deptqi.setYearCode(year);
      if (deptqiService.selectDeptqiList(deptqi).size()==0){
        ++IssueNumber;
        deptqi.setYearCode(year);
        deptqi.setIssueNumber(IssueNumber);
        int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
        if (row != rows) {
          rows = 0;
        }
        return toAjax(rows, deptqiId, IssueNumber);//当数据库无信息时
      }
      if (deptqis.get(deptqis.size()-1).getIssueNumber()!=null){
        Deptform deptform = new Deptform();
        deptform.setDeptqiId(deptqiId);
        deptform.setStartTime(deptqi.getStartTime());
        deptform.setEndTime(deptqi.getEndTime());
        deptform.setUserName(userName);
        deptform.setConfirmedBy(userName);
        deptform.setCreateBy(userName);
        deptform.setIssueNumber(IssueNumber);
        rows = deptformService.insertDeptform(deptform);//将数据更新到派单填报表

        Integer issueNumber = deptqis.get(deptqis.size() - 1).getIssueNumber();

        //对远程表进行查询将结果更新到本地表---（帆软-万达）
        List<SheetOption> list = new ArrayList<>();
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        List<CyDeptwanda> listw = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
        for (int i = 0; i < listw.size(); i++) {//获取他的行数id--i--r
          Date modifiedon = listw.get(i).getModifiedon();
          String demandname = listw.get(i).getDemandname();
          String code = listw.get(i).getCode();
          String name = listw.get(i).getName();
          String plmname2 = listw.get(i).getPlmname2();
          String seibancode = listw.get(i).getSeibancode();
          String descflexfieldPubdescseg32 = listw.get(i).getDescflexfieldPubdescseg32();
          Integer shuliang = listw.get(i).getShuliang();
          Integer ljpc = listw.get(i).getLjpc();
          String t3 = listw.get(i).getT3();
          String descflexfieldPrivatedescseg7 = listw.get(i).getDescflexfieldPrivatedescseg7();
          String descflexfieldPrivatedescseg9 = listw.get(i).getDescflexfieldPrivatedescseg9();
          String saleslineId = listw.get(i).getSaleslineId();
          //将从虚表中查询出来==插入到实表
          CyDeptwanda deptwanda1 = new CyDeptwanda();
          deptwanda1.setSaleslineId(saleslineId);//saleslineId通过这个判断当前缓存表中是否有重复
          if (cyDeptwandaService.selectBySaleslineIdList(deptwanda1).size() == 0) {
            cyDeptwanda.setModifiedon(modifiedon);
            cyDeptwanda.setDemandname(demandname);
            cyDeptwanda.setCode(code);
            cyDeptwanda.setName(name);
            cyDeptwanda.setPlmname2(plmname2);
            cyDeptwanda.setSeibancode(seibancode);
            cyDeptwanda.setDescflexfieldPubdescseg32(descflexfieldPubdescseg32);
            cyDeptwanda.setShuliang(shuliang);
            cyDeptwanda.setLjpc(ljpc);
            cyDeptwanda.setT3(t3);
            cyDeptwanda.setDescflexfieldPrivatedescseg7(descflexfieldPrivatedescseg7);
            cyDeptwanda.setDescflexfieldPrivatedescseg9(descflexfieldPrivatedescseg9);
            cyDeptwanda.setSaleslineId(saleslineId);
            cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
          }
          if (list.size()==0){
            rows=1;
            break;
          }
        }
        return toAjax(rows,deptqiId,issueNumber);
      }
    }
    /*if (Number_of_rounds==IssueNumber||Number==Number_of_rounds) {*/
    //第一次启动发送 Number = 0
    if (Number == 0) {
      sysYear= instance.get(Calendar.YEAR);//获取一次系统当前年 2022
    }
    //之后的话就用不赋值用一开始的年号，永远不动
    //判断第一次系统时间和最新系统时间是否一致
    Integer issueNumber =0;
    if (sysYear == instance.get(Calendar.YEAR) && sysYear == year) {//防止因为重启出现期数不连续

      Deptqi byId = deptqiService.selectDeptqiById(deptqiId - 1);
      if ((byId.getStartTime().getYear()+ 1900) ==sysYear&&Number==0){//Number=0说明重启了
        issueNumber = byId.getIssueNumber();
        Number=++issueNumber;
        System.out.println(" = " + Number);
      }else {//没有重启
        Number++;
      }
      deptqi.setYearCode(year);
      deptqi.setIssueNumber(Number);
      int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
      if (row != rows) {
        rows = 0;
      }
      //对远程表进行查询将结果更新到本地表---（帆软-万达）
      List<SheetOption> list = new ArrayList<>();
      CyDeptwanda cyDeptwanda = new CyDeptwanda();
      List<CyDeptwanda> listw = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
      for (int i = 0; i < listw.size(); i++) {//获取他的行数id--i--r
        Date modifiedon = listw.get(i).getModifiedon();
        String demandname = listw.get(i).getDemandname();
        String code = listw.get(i).getCode();
        String name = listw.get(i).getName();
        String plmname2 = listw.get(i).getPlmname2();
        String seibancode = listw.get(i).getSeibancode();
        String descflexfieldPubdescseg32 = listw.get(i).getDescflexfieldPubdescseg32();
        Integer shuliang = listw.get(i).getShuliang();
        Integer ljpc = listw.get(i).getLjpc();
        String t3 = listw.get(i).getT3();
        String descflexfieldPrivatedescseg7 = listw.get(i).getDescflexfieldPrivatedescseg7();
        String descflexfieldPrivatedescseg9 = listw.get(i).getDescflexfieldPrivatedescseg9();
        String saleslineId = listw.get(i).getSaleslineId();
        //将从虚表中查询出来==插入到实表
        CyDeptwanda deptwanda1 = new CyDeptwanda();
        deptwanda1.setSaleslineId(saleslineId);//saleslineId通过这个判断当前缓存表中是否有重复
        if (cyDeptwandaService.selectBySaleslineIdList(deptwanda1).size() == 0) {
          cyDeptwanda.setModifiedon(modifiedon);
          cyDeptwanda.setDemandname(demandname);
          cyDeptwanda.setCode(code);
          cyDeptwanda.setName(name);
          cyDeptwanda.setPlmname2(plmname2);
          cyDeptwanda.setSeibancode(seibancode);
          cyDeptwanda.setDescflexfieldPubdescseg32(descflexfieldPubdescseg32);
          cyDeptwanda.setShuliang(shuliang);
          cyDeptwanda.setLjpc(ljpc);
          cyDeptwanda.setT3(t3);
          cyDeptwanda.setDescflexfieldPrivatedescseg7(descflexfieldPrivatedescseg7);
          cyDeptwanda.setDescflexfieldPrivatedescseg9(descflexfieldPrivatedescseg9);
          cyDeptwanda.setSaleslineId(saleslineId);
          cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
        }
        if (list.size()==0){
          rows=1;
          break;
        }
      }


      return toAjax(rows, deptqiId, Number);
    } else {
      IssueNumber++;
      deptqi.setYearCode(year);
      deptqi.setIssueNumber(IssueNumber);
      int row = deptqiService.updateDeptqi(deptqi);//当前的指定下的id数据进行更新---期号
      if (row != rows) {
        rows = 0;
      }

      //对远程表进行查询将结果更新到本地表---（帆软-万达）
      List<SheetOption> list = new ArrayList<>();
      CyDeptwanda cyDeptwanda = new CyDeptwanda();
      List<CyDeptwanda> listw = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
      for (int i = 0; i < listw.size(); i++) {//获取他的行数id--i--r
        Date modifiedon = listw.get(i).getModifiedon();
        String demandname = listw.get(i).getDemandname();
        String code = listw.get(i).getCode();
        String name = listw.get(i).getName();
        String plmname2 = listw.get(i).getPlmname2();
        String seibancode = listw.get(i).getSeibancode();
        String descflexfieldPubdescseg32 = listw.get(i).getDescflexfieldPubdescseg32();
        Integer shuliang = listw.get(i).getShuliang();
        Integer ljpc = listw.get(i).getLjpc();
        String t3 = listw.get(i).getT3();
        String descflexfieldPrivatedescseg7 = listw.get(i).getDescflexfieldPrivatedescseg7();
        String descflexfieldPrivatedescseg9 = listw.get(i).getDescflexfieldPrivatedescseg9();
        String saleslineId = listw.get(i).getSaleslineId();
        //将从虚表中查询出来==插入到实表
        CyDeptwanda deptwanda1 = new CyDeptwanda();
        deptwanda1.setSaleslineId(saleslineId);//saleslineId通过这个判断当前缓存表中是否有重复
        if (cyDeptwandaService.selectBySaleslineIdList(deptwanda1).size() == 0) {
          cyDeptwanda.setModifiedon(modifiedon);
          cyDeptwanda.setDemandname(demandname);
          cyDeptwanda.setCode(code);
          cyDeptwanda.setName(name);
          cyDeptwanda.setPlmname2(plmname2);
          cyDeptwanda.setSeibancode(seibancode);
          cyDeptwanda.setDescflexfieldPubdescseg32(descflexfieldPubdescseg32);
          cyDeptwanda.setShuliang(shuliang);
          cyDeptwanda.setLjpc(ljpc);
          cyDeptwanda.setT3(t3);
          cyDeptwanda.setDescflexfieldPrivatedescseg7(descflexfieldPrivatedescseg7);
          cyDeptwanda.setDescflexfieldPrivatedescseg9(descflexfieldPrivatedescseg9);
          cyDeptwanda.setSaleslineId(saleslineId);
          cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
        }
        if (list.size()==0){
          rows=1;
          break;
        }
      }
      return toAjax(rows, deptqiId, IssueNumber);
    }
    //说明当前服务重启
  }

  /**
   * - 删除期数
   * /*@PreAuthorize("@ss.hasPermi('deptqi:deptqi:remove')")
   *
   * @Log(title = "期数", businessType = BusinessType.DELETE)
   * @DeleteMapping("/{ids}")
   */
  @DeleteMapping("/capacity/templatedelete/delete/{id}")
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

  }

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
