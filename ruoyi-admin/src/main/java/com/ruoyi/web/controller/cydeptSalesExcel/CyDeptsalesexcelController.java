package com.ruoyi.web.controller.cydeptSalesExcel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
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
import com.alibaba.fastjson2.JSONArray;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.ICyDeptsalesexcelService;
import com.ruoyi.web.controller.test.test;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.beans.binding.When;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.ICyDeptwandaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 填报派单Controller
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/deptsalesexcel")*/
public class CyDeptsalesexcelController extends BaseController {
    @Autowired
    private  ICyDeptsalesexcelService cyDeptsalesexcelService;

    @Autowired
    private  ICyDeptwandaService cyDeptwandaService;

    @Autowired
    private  ICyDeptpoService cyDeptpoService;

    @Autowired
    private  IDeptzhuService deptzhuService;

    @Autowired
    private IDeptproductService deptproductService;

    private static Integer IssueNumber;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 查询填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:list')")*/
    @RequestMapping("/system/deptsalesexcel/list")//这里前端传入用户名,期数
    public  String list(CyDeptsalesexcel cyDeptsalesexcel) {
        startPage();
        Deptproduct deptproduct = new Deptproduct();
        /*deptproductService.selectDeptproductById();*/
        cyDeptsalesexcel.setIssueNumber(IssueNumber);
        List<CyDeptsalesexcel> lists = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        //将数据转成字段返回
        List<SheetOption> list = new ArrayList<>();
        Map keys = new HashMap();
        SheetOption stop = new SheetOption();
        //设置sheet页名
        stop.setName("options");
        //设置sheet页索引
        stop.setIndex("1");
        stop.setStatus(1);
        stop.setHide(0);
        for (int i = 0; i < lists.size(); i++) {//行
            String v = null;
            for (int j = 0; j < 20; j++) {//列
                if (i == 0) {
                    if (j == 0) {
                        v = "销售订单日期";
                    }
                    if (j == 1) {
                        v = "需求分类";
                    }
                    if (j == 2) {
                        v = "料号";
                    }
                    if (j == 3) {
                        v = "名称";
                    }
                    if (j == 4) {
                        v = "规格";
                    }
                    if (j == 5) {
                        v = "番号";
                    }
                    if (j == 6) {
                        v = "花纹";
                    }
                    if (j == 7) {
                        v = "商标";
                    }
                    if (j == 8) {
                        v = "工艺";
                    }
                    if (j == 9) {
                        v = "订单数量";
                    }
                    if (j == 10) {
                        v = "累计排产量";
                    }
                    if (j == 11) {
                        v = "可排产量";
                    }
                    if (j == 12) {
                        v = "销售需求";
                    }
                    if (j == 13) {
                        v = "备注";
                    }
                    if (j == 14) {
                        v = "夏季硫化定额";
                    }
                    if (j == 15) {
                        v = "模具总数量";
                    }
                    if (j == 16) {
                        v = "销售行ID";
                    }
                    if (j == 17) {
                        v = "本期最大产能";
                    }
                    if (j == 18) {
                        v = "个人需求";
                    }if (j == 19){
                        v = "期数";
                    }
                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                    continue;
                }
                if (j == 0) {
                    if (lists.get(i).getModifiedon() != null) {
                        Date modifiedon = lists.get(i).getModifiedon();
                        v=sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i).getDemandname() != null) {
                        String demandname = lists.get(i).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i).getCode() != null) {
                        String code = lists.get(i).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i).getName() != null) {
                        String name = lists.get(i).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i).getPlmname2() != null) {
                        String plmname2 = lists.get(i).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i).getSeibancode() != null) {
                        String seibancode = lists.get(i).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i).getPlmname5() != null) {
                        String plmname5 = lists.get(i).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i).getPlmname3() != null) {
                        String plmname3 = lists.get(i).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i).getShuliang() != null) {
                        Integer shuliang = lists.get(i).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i).getLjpc() != null) {
                        Integer ljpc = lists.get(i).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 11) {
                    if (lists.get(i).getT3() != null) {
                        String t3 = lists.get(i).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 12) {
                    if (lists.get(i).getXq() != null) {
                        Integer xq = lists.get(i).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 13) {
                    if (lists.get(i).getMark() != null) {
                        String mark = lists.get(i).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i).getSaleslineId() != null) {
                        String saleslineId = lists.get(i).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i).getTodayNumber() != null) {
                        BigDecimal todayNumber = lists.get(i).getTodayNumber();
                        v = todayNumber.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i).getIssueNumber() != null) {
                        Integer issueNumber = lists.get(i).getIssueNumber();
                        v = issueNumber.toString();
                    } else {
                        v = "0";
                    }
                }
                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                }
            }
            list.add(stop);
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
            return jsonArray.toString();
        }
    /**
     * 查询汇总表的销售不为空的值
     */
    @RequestMapping("/system/deptSummary/list")//期数
    public  String listSummary(CyDeptsalesexcel cyDeptsalesexcel) {
        startPage();
        Deptproduct deptproduct = new Deptproduct();
        /*deptproductService.selectDeptproductById();*/
        List<CyDeptsalesexcel> lists = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        //将数据转成字段返回
        List<SheetOption> list = new ArrayList<>();
        Map keys = new HashMap();
        SheetOption stop = new SheetOption();
        //设置sheet页名
        stop.setName("options");
        //设置sheet页索引
        stop.setIndex("1");
        stop.setStatus(1);
        stop.setHide(0);
        for (int i = 0; i < lists.size(); i++) {//行
            String v = null;
            for (int j = 0; j < 19; j++) {//列
                if (i == 0) {
                    if (j == 0) {
                        v = "销售订单日期";
                    }
                    if (j == 1) {
                        v = "需求分类";
                    }
                    if (j == 2) {
                        v = "料号";
                    }
                    if (j == 3) {
                        v = "名称";
                    }
                    if (j == 4) {
                        v = "规格";
                    }
                    if (j == 5) {
                        v = "番号";
                    }
                    if (j == 6) {
                        v = "花纹";
                    }
                    if (j == 7) {
                        v = "商标";
                    }
                    if (j == 8) {
                        v = "工艺";
                    }
                    if (j == 9) {
                        v = "订单数量";
                    }
                    if (j == 10) {
                        v = "累计排产量";
                    }
                    if (j == 11) {
                        v = "可排产量";
                    }
                    if (j == 12) {
                        v = "销售需求";
                    }
                    if (j == 13) {
                        v = "备注";
                    }
                    if (j == 14) {
                        v = "夏季硫化定额";
                    }
                    if (j == 15) {
                        v = "模具总数量";
                    }
                    if (j == 16) {
                        v = "销售行ID";
                    }
                    if (j == 17) {
                        v = "本期最大产能";
                    }
                    if (j == 18) {
                        v = "个人需求";
                    }
                    if (j == 19){
                        v = "期数";
                    }
                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                    continue;
                }
                if (j == 0) {
                    if (lists.get(i).getModifiedon() != null) {
                        Date modifiedon = lists.get(i).getModifiedon();
                        v=sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i).getDemandname() != null) {
                        String demandname = lists.get(i).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i).getCode() != null) {
                        String code = lists.get(i).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i).getName() != null) {
                        String name = lists.get(i).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i).getPlmname2() != null) {
                        String plmname2 = lists.get(i).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i).getSeibancode() != null) {
                        String seibancode = lists.get(i).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i).getPlmname5() != null) {
                        String plmname5 = lists.get(i).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i).getPlmname3() != null) {
                        String plmname3 = lists.get(i).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i).getShuliang() != null) {
                        Integer shuliang = lists.get(i).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i).getLjpc() != null) {
                        Integer ljpc = lists.get(i).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 11) {
                    if (lists.get(i).getT3() != null) {
                        String t3 = lists.get(i).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 12) {
                    if (lists.get(i).getXq() != null) {
                        Integer xq = lists.get(i).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 13) {
                    if (lists.get(i).getMark() != null) {
                        String mark = lists.get(i).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i).getSaleslineId() != null) {
                        String saleslineId = lists.get(i).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i).getTodayNumber() != null) {
                        BigDecimal sumZhu = lists.get(i).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i).getPersonalNeeds() != null) {
                        Integer issueNumber = lists.get(i).getIssueNumber();
                        v = issueNumber.toString();
                    } else {
                        v = "0";
                    }
                }
                //随机生成点数据
                Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                stop.getCelldata().add(celldata);
            }
        }
        list.add(stop);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonArray.toString();
    }

        /**
         * 导出填报派单列表
         */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:export')")
    @Log(title = "填报派单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptsalesexcel cyDeptsalesexcel)
    {
        List<CyDeptsalesexcel> list = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        ExcelUtil<CyDeptsalesexcel> util = new ExcelUtil<CyDeptsalesexcel>(CyDeptsalesexcel.class);
        util.exportExcel(response, list, "填报派单数据");
    }*/

        /**
         * 获取填报派单详细信息
         */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {

        return AjaxResult.success(cyDeptsalesexcelService.selectCyDeptsalesexcelById(id));
    }*/

        /**
         * 新增填报派单
         */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:add')")
    @Log(title = "填报派单", businessType = BusinessType.INSERT)*/
    @RequestMapping("/system/deptsalesexcel/NameAndIsser")
    public AjaxResult add(@RequestBody String string)//这里需要获取销售人员名字.期号
    {
        System.out.println("strings = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);
        //查询的时候调插入接口--将整张表wanda插入到--sales
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();//通过期号查询主表id---再通过id从主表中查询出最大日产能
        IssueNumber = issueNumber;
        CyDeptpo cyDeptpo = new CyDeptpo();
        cyDeptpo.setIssueNumber(issueNumber);
        List<CyDeptpo> cyDeptpos = cyDeptpoService.selectCyDeptpoList(cyDeptpo);
        //根据期号查询出第一行数据----这里应该查询对照表-对code进行整合
        BigDecimal sumProductive = cyDeptpos.get(0).getSumProductive();
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        List<CyDeptwanda> cyDeptwandas = cyDeptwandaService.selectBySaleslineIdList(cyDeptwanda);//查询本地wanda表
        int deptsalesexcel=0;
        //把wanda的数据添加到自建表中 salesexcel
        if (cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel).size() == 0) {
            for (int i = 0; i < cyDeptwandas.size(); i++) {
                cyDeptsalesexcel.setModifiedon(cyDeptwandas.get(i).getModifiedon());//16行基础数据
                cyDeptsalesexcel.setDemandname(cyDeptwandas.get(i).getDemandname());
                cyDeptsalesexcel.setCode(cyDeptwandas.get(i).getCode());
                cyDeptsalesexcel.setName(cyDeptwandas.get(i).getName());
                cyDeptsalesexcel.setPlmname2(cyDeptwandas.get(i).getPlmname2());
                cyDeptsalesexcel.setSeibancode(cyDeptwandas.get(i).getSeibancode());
                cyDeptsalesexcel.setPlmname5(cyDeptwandas.get(i).getPlmname5());
                cyDeptsalesexcel.setPlmname3(cyDeptwandas.get(i).getPlmname3());
                cyDeptsalesexcel.setDescflexfieldPubdescseg32(cyDeptwandas.get(i).getDescflexfieldPubdescseg32());
                cyDeptsalesexcel.setShuliang(cyDeptwandas.get(i).getShuliang());
                cyDeptsalesexcel.setLjpc(cyDeptwandas.get(i).getLjpc());
                cyDeptsalesexcel.setT3(cyDeptwandas.get(i).getT3());
                cyDeptsalesexcel.setXq(cyDeptwandas.get(i).getXq());
                cyDeptsalesexcel.setMark(cyDeptwandas.get(i).getMark());
                cyDeptsalesexcel.setDescflexfieldPrivatedescseg7(cyDeptwandas.get(i).getDescflexfieldPrivatedescseg7());
                cyDeptsalesexcel.setDescflexfieldPrivatedescseg9(cyDeptwandas.get(i).getDescflexfieldPrivatedescseg9());
                cyDeptsalesexcel.setSaleslineId(cyDeptwandas.get(i).getSaleslineId());
                cyDeptsalesexcel.setUserName(cyDeptsalesexcel.getUserName());
                cyDeptsalesexcel.setSumZhu(sumProductive);//一组中产能组表的最大产能
                cyDeptsalesexcel.setIssueNumber(issueNumber);
                //获取个人需求：
                cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);
            }
        }
        return toAjax(1);
    }

    /*
    * 修改填报派单 (将销售数据整张插入销售表)
    * */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:edit')")
    @Log(title = "填报派单", businessType = BusinessType.UPDATE)*/
    @PostMapping("/salesexcel/adds")
    public AjaxResult edit(@RequestBody String string)
    {
        /*System.out.println("string = " + string);*/
        /*SheetOption sheetOption = JSON.toJavaObject(string, SheetOption.class);
        System.out.println("configMergeModel = " + sheetOption);*/

        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(string).getJSONObject("data");
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(json, CyDeptsalesexcel.class);
        System.out.println("celldata = " + dataList);
        int size = dataList.size();//获取一共有多少个字段
        int r = 0;
        int rows = 0;
        ArrayList<Object> ids = new ArrayList<>();
        ConfigMergeModel configMergeModels = null;
        ConfigMergeModel configMergeModels1 = null;

        Integer id =null;
        /*int r2=0;
        for (int i = 0; i < dataList.size(); i++) {
            String s1 = dataList.get(i).toString();
            r2 = configMergeModels1.getR();
        }*/
        for (int j = 0; j < dataList.size(); j++) {//j，算出总计的单元格个数190--10行，19列
            String s = dataList.get(j).toString();
            /*SheetOption sheetOption = new SheetOption();
            sheetOption = dataList.get(j).toString();*/
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
            /*SheetOption sheetOption = JSON.toJavaObject(s, SheetOption.class);
            System.out.println("sheetOption = " + sheetOption);*/
            /*cyDeptsalesexcel.get*/
            int r1 = configMergeModels.getR();//行数
            if (r1==0){//说明是标题行直接跳过
                continue;
            }
            else {
            String s1 = dataList.get(j).toString();
                if (configMergeModels.getC() == 0 && configMergeModels.getV().getM() != null) {
                    String m = configMergeModels.getV().getM();
                        Date date = new Date();
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(m);
                    } catch (ParseException e) {
                        //LOGGER.error("时间转换错误, string = {}", s, e);
                    }
                    System.out.println("date = " + date);
                        cyDeptsalesexcel.setModifiedon(date);//设置时间
                        rows = cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);
                        id = cyDeptsalesexcel.getId();
                }
                //已存入id，时间
                if (configMergeModels.getC() == 1 && configMergeModels.getV().getM() != null) {
                    String v1 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDemandname(v1);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 2 && configMergeModels.getV().getM() != null) {
                    String v2 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setCode(v2);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 3 && configMergeModels.getV().getM() != null) {
                    String v3 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setName(v3);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 4 && configMergeModels.getV().getM() != null) {
                    String v4 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname2(v4);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 5 && configMergeModels.getV().getM() != null) {
                    String v5 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSeibancode(v5);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 6 && configMergeModels.getV().getM() != null) {
                    String v6 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname5(v6);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 7 && configMergeModels.getV().getM() != null) {
                    String v7 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname3(v7);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 8 && configMergeModels.getV().getM() != null) {
                    String v8 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPubdescseg32(v8);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 9 && configMergeModels.getV().getM() != null) {
                    String v9 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setShuliang(Integer.valueOf(v9));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 10 && configMergeModels.getV().getM() != null) {
                    String v10 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setLjpc(Integer.valueOf(v10));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 11 && configMergeModels.getV().getM() != null) {
                    String v11 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setT3(String.valueOf(v11));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (id!=0&&configMergeModels.getC() == 12 && configMergeModels.getV().getM() != null) {
                    String v12 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setXq(Integer.valueOf(v12));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 13 && configMergeModels.getV().getM() != null) {
                    String v13 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setMark(v13);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 14 && configMergeModels.getV().getM() != null) {
                    String v14 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg7(v14);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 15 && configMergeModels.getV().getM() != null) {
                    String v15 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg9(v15);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 16 && configMergeModels.getV().getM() != null) {
                    String v16 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSaleslineId(v16);
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 17 && configMergeModels.getV().getM() != null) {
                    String v17 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSumZhu(new BigDecimal(v17));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
                if (configMergeModels.getC() == 18 && configMergeModels.getV().getM() != null) {
                    String v18 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPersonalNeeds(Integer.valueOf(v18));
                    cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);
                }
            }
            }
        return toAjax(rows);
    }

    /**
     * 删除填报派单  当需要更新excel先进行删除再插入
     * @param
     * @return  返回删除结果
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:remove')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.DELETE)*/
	@PostMapping ("/salesexcel/delete")
    public AjaxResult remove(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("userInfo");
        AjaxResult ajaxResult = null;
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();
        String userName = cyDeptsalesexcel.getUserName();
        if (issueNumber!=null&&userName!=null){
            List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
            for (int i = 0; i < cyDeptsalesexcels.size(); i++) {
                Integer id = cyDeptsalesexcels.get(i).getId();
                ajaxResult = toAjax(cyDeptsalesexcelService.deleteCyDeptsalesexcelById(id));
            }
        }
        return ajaxResult;
    }
    }


