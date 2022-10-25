package com.ruoyi.web.controller.cydeptSalesExcel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.ICyDeptsalesexcelService;


import com.ruoyi.system.service.ICyDeptwandaService;


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

    //查询redis缓存
    @Autowired
    public RedisTemplate redisTemplate;

    //生成--根据期号
    private static Integer IssueNumber;
    //汇总对数据进行筛选---根据期号筛选
    private static Integer Issue;

    //对不同用户的 个人需求
    private static String userNames;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 查询填报派单列表 ---先存储到Redis中；当redis存储成功，返回成功值--开启另一个线程 --执行redis到sqlservice--填报派单点击查看的接口
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:list')")*/
    @RequestMapping("/system/deptsalesexcel/list")//这里前端传入用户名,期数;第一次生成excel表
    public  String list(CyDeptsalesexcel cyDeptsalesexcel) {
        cyDeptsalesexcel.setIssueNumber(IssueNumber);

        //查询的时候要更新对应的 个人需求  --List<Integer> integers计算出一共多少组的总的本期产能类型
        List<CyDeptsalesexcel> integers = cyDeptsalesexcelService.selectGroupsumList(new CyDeptsalesexcel());
        for (int i = 0; i < integers.size(); i++) {
            BigDecimal sumZhu = integers.get(i).getSumZhu();
            System.out.println("sumZhu = " + sumZhu + ",user=" + userNames + ",iss=" + IssueNumber);
            CyDeptsalesexcel deptsalesexcel1 = new CyDeptsalesexcel();
            deptsalesexcel1.setIssueNumber(IssueNumber);
            deptsalesexcel1.setUserName(userNames);
            deptsalesexcel1.setSumZhu(sumZhu);
            //获取他的本期产能，查询对应的产能数据--加入不同的规格的产能需求---,这里需要传入 用户名，期号，主产能；查询出非本人的需求和
            CyDeptsalesexcel cyDeptsalesexcel1 = cyDeptsalesexcelService.selectsumXqList(deptsalesexcel1);
            if (cyDeptsalesexcel1 != null){
                Integer sumXq = cyDeptsalesexcel1.getXq();
            System.out.println("sumXq = " + sumXq);
            //汇总出指定组的本期数据
            if (sumXq != null) {
                CyDeptsalesexcel deptsalesexcel = new CyDeptsalesexcel();
                deptsalesexcel.setSumZhu(sumZhu);
                List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(deptsalesexcel);
                for (int j = 0; j < cyDeptsalesexcels.size(); j++) {
                    deptsalesexcel.setPersonalNeeds(sumXq);//将 个人需求更具id 依次更新进去
                    deptsalesexcel.setId(cyDeptsalesexcels.get(j).getId());
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(deptsalesexcel);
                }
            }
        }
        }
        cyDeptsalesexcel.setIssueNumber(IssueNumber);
        cyDeptsalesexcel.setUserName(userNames);
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
        for (int i = 0; i < lists.size()+1; i++) {//行
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
                }//目录列表
                if (j == 0) {
                    if (lists.get(i-1).getModifiedon() != null) {
                        Date modifiedon = lists.get(i-1).getModifiedon();
                        v=sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i-1).getDemandname() != null) {
                        String demandname = lists.get(i-1).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i-1).getCode() != null) {
                        String code = lists.get(i-1).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i-1).getName() != null) {
                        String name = lists.get(i-1).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i-1).getPlmname2() != null) {
                        String plmname2 = lists.get(i-1).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i-1).getSeibancode() != null) {
                        String seibancode = lists.get(i-1).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i-1).getPlmname5() != null) {
                        String plmname5 = lists.get(i-1).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i-1).getPlmname3() != null) {
                        String plmname3 = lists.get(i-1).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i-1).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i-1).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i-1).getShuliang() != null) {
                        Integer shuliang = lists.get(i-1).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i-1).getLjpc() != null) {
                        Integer ljpc = lists.get(i-1).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 11) {
                    if (lists.get(i-1).getT3() != null) {
                        String t3 = lists.get(i-1).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 12) {
                    if (lists.get(i-1).getXq() != null) {
                        Integer xq = lists.get(i-1).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 13) {
                    if (lists.get(i-1).getMark() != null) {
                        String mark = lists.get(i-1).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i-1).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i-1).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i-1).getSaleslineId() != null) {
                        String saleslineId = lists.get(i-1).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i-1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i-1).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i-1).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i-1).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i-1).getIssueNumber() != null) {
                        Integer issueNumber = lists.get(i-1).getIssueNumber();
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
    //接收期号写入 -静态变量
    @PostMapping ("/system/deptSummary/Issue")//这里应该传入 期号和用户名 === 当汇总的时候；接收并且找寻数据，这里计算出对应的个人需求
    public Object list(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();
        String userName = cyDeptsalesexcel.getUserName();
        Issue = issueNumber;
        if (issueNumber!=null){
            return toAjax(1);
        }
        return null;
    }
    @PostMapping ("/system/deptSummary/list")//期数--这里可能需要名字
    public  String listSummary(CyDeptsalesexcel cyDeptsalesexcel) {
        System.out.println("cyDeptsalesexcel = " + cyDeptsalesexcel);
        cyDeptsalesexcel.setIssueNumber(Issue);
        List<CyDeptsalesexcel> lists = cyDeptsalesexcelService.selectCyDeptSummaryList(cyDeptsalesexcel);
        /*Integer integer = cyDeptsalesexcelService.selectsumXqList(Issue);//获取他总的销售需求*/
        Integer zhuList = cyDeptsalesexcelService.selectsumZhuList();
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
            for (int i = 0; i < lists.size()+1; i++) {//行
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
                    if (lists.get(i-1).getModifiedon() != null) {
                        Date modifiedon = lists.get(i-1).getModifiedon();
                        v=sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i-1).getDemandname() != null) {
                        String demandname = lists.get(i-1).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i-1).getCode() != null) {
                        String code = lists.get(i-1).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i-1).getName() != null) {
                        String name = lists.get(i-1).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i-1).getPlmname2() != null) {
                        String plmname2 = lists.get(i-1).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i-1).getSeibancode() != null) {
                        String seibancode = lists.get(i-1).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i-1).getPlmname5() != null) {
                        String plmname5 = lists.get(i-1).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i-1).getPlmname3() != null) {
                        String plmname3 = lists.get(i-1).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i-1).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i-1).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i-1).getShuliang() != null) {
                        Integer shuliang = lists.get(i-1).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i-1).getLjpc() != null) {
                        Integer ljpc = lists.get(i-1).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 11) {
                    if (lists.get(i-1).getT3() != null) {
                        String t3 = lists.get(i-1).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 12) {
                    if (lists.get(i-1).getXq() != null) {
                        Integer xq = lists.get(i-1).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 13) {
                    if (lists.get(i-1).getMark() != null) {
                        String mark = lists.get(i-1).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i-1).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i-1).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i-1).getSaleslineId() != null) {
                        String saleslineId = lists.get(i-1).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i-1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i-1).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i-1).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i-1).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i-1).getIssueNumber() != null) {
                        Integer issueNumber = lists.get(i-1).getIssueNumber();
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
     * 查询合并表的销售不为空的值
     */
    //接收期号写入 -静态变量
    @PostMapping ("/system/deptSummary/IssuePost")
    public Object listPost(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();
        Issue = issueNumber;
        if (issueNumber!=null){
            return AjaxResult.success("传入的期数为null");
        }
        return null;
    }
    @PostMapping ("/system/deptSummary/listPost")//期数
    public  String listPost(CyDeptsalesexcel cyDeptsalesexcel) {

        System.out.println("cyDeptsalesexcel = " + cyDeptsalesexcel);
        cyDeptsalesexcel.setIssueNumber(Issue);
        List<CyDeptsalesexcel> lists = cyDeptsalesexcelService.selectCyDeptSummaryList(cyDeptsalesexcel);
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
        for (int i = 0; i < lists.size()+1; i++) {//行
            String v = null;
            for (int j = 0; j < 49; j++) {//列
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
                    if (j == 20){
                        v = "配方";
                    }
                    if (j == 21){
                        v = "静态订单差数";
                    }
                    if (j == 22){
                        v = "上期排产数";
                    }
                    if (j == 23){
                        v = "累计到上周的完工数";
                    }
                    if (j == 24){
                        v = "冬季硫化定额";
                    }
                    if (j == 25){
                        v = "平均时间";
                    }
                    if (j == 26){
                        v = "工艺代码";
                    }
                    if (j == 27){
                        v = "胎侧标识页码";
                    }
                    if (j == 28){
                        v = "排产要求";
                    }
                    if (j == 29){
                        v = "排产要求确认";
                    }
                    if (j == 30){
                        v = "模具总量";
                    }
                    if (j == 31){
                        v = "模具投产";
                    }
                    if (j == 32){
                        v = "模具号";
                    }
                    if (j == 33){
                        v = "零头库存";
                    }
                    if (j == 34){
                        v = "本周生产计划量";
                    }
                    if (j == 35){
                        v = "差异量";
                    }
                    if (j == 36){
                        v = "实际释放量";
                    }
                    if (j == 37){
                        v = "累计在制数量";
                    }
                    if (j == 38){
                        v = "新增排产";
                    }
                    if (j == 39){
                        v = "剩余排产";
                    }
                    if (j == 40){
                        v = "上周排产数";
                    }
                    if (j == 41){
                        v = "填报日期";
                    }
                    if (j == 42){
                        v = "零头库存";
                    }
                    if (j == 43){
                        v = "是否有BOM";
                    }
                    if (j == 44){
                        v = "客户编码";
                    }
                    if (j == 45){
                        v = "客户名称";
                    }
                    if (j == 46){
                        v = "错误信息";
                    }
                    if (j == 47){
                        v = "工艺标志";
                    }
                    if (j == 48){
                        v = "生成组织";
                    }

                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                    continue;
                }//所以的表头
                if (j == 0) {
                    if (lists.get(i-1).getModifiedon() != null) {
                        Date modifiedon = lists.get(i-1).getModifiedon();
                        v=sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i-1).getDemandname() != null) {
                        String demandname = lists.get(i-1).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i-1).getCode() != null) {
                        String code = lists.get(i-1).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i-1).getName() != null) {
                        String name = lists.get(i-1).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i-1).getPlmname2() != null) {
                        String plmname2 = lists.get(i-1).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i-1).getSeibancode() != null) {
                        String seibancode = lists.get(i-1).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i-1).getPlmname5() != null) {
                        String plmname5 = lists.get(i-1).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i-1).getPlmname3() != null) {
                        String plmname3 = lists.get(i-1).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i-1).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i-1).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i-1).getShuliang() != null) {
                        Integer shuliang = lists.get(i-1).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i-1).getLjpc() != null) {
                        Integer ljpc = lists.get(i-1).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 11) {
                    if (lists.get(i-1).getT3() != null) {
                        String t3 = lists.get(i-1).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 12) {
                    if (lists.get(i-1).getXq() != null) {
                        Integer xq = lists.get(i-1).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 13) {
                    if (lists.get(i-1).getMark() != null) {
                        String mark = lists.get(i-1).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i-1).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i-1).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i-1).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i-1).getSaleslineId() != null) {
                        String saleslineId = lists.get(i-1).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i-1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i-1).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i-1).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i-1).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i-1).getIssueNumber() != null) {
                        Integer issueNumber = lists.get(i-1).getIssueNumber();
                        v = issueNumber.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 20) {
                    if (lists.get(i-1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i - 1).getSumZhu();
                        v = sumZhu.toString();
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
    @RequestMapping("/system/deptsalesexcel/NameAndIsser")//--进行表的制作----第一次查看的时候传入用户名和期号进行表的绘制
    public AjaxResult add(@RequestBody String string)//这里需要获取销售人员名字.期号
    {
        System.out.println("strings = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);

        //查询的时候调插入接口--将整张表wanda插入到--sales
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();//通过期号查询主表id---再通过id从主表中查询出最大日产能
        String Name = cyDeptsalesexcel.getUserName();
        userNames = Name;
        //在此处计算出个人需求--总需求-他人需求
        IssueNumber = issueNumber;
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        List<CyDeptwanda> cyDeptwandas = cyDeptwandaService.selectBySaleslineIdList(cyDeptwanda);//查询本地wanda表
        BigDecimal sumProductive = null;
        List<CyDeptsalesexcel> list = new ArrayList<>();
        Integer size =null;
        String type =null;
        String code = null;
        //从po表中查取最大的产能 sum；

        List<Deptproduct> deptproducts = deptproductService.selectDeptproductList(new Deptproduct());//查询一次之后遍历
        List<CyDeptpo> cyDeptpos = cyDeptpoService.selectCyDeptpoList(new CyDeptpo());
        //把wanda的数据添加到自建表中 salesexcel  --从产能调整表中查询最大产能----这里传入的期号和名字，判断当期号和名字已存在不执行
        if (cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel).size()<1) {//判断当期号和名字不存在
            for (int i = 0; i < cyDeptwandas.size(); i++) {
             /*for (int i = 0; i < 3; i++) {*/
                cyDeptsalesexcel.setModifiedon(cyDeptwandas.get(i).getModifiedon());//16行基础数据
                cyDeptsalesexcel.setDemandname(cyDeptwandas.get(i).getDemandname());
                code = cyDeptwandas.get(i).getCode();
                //获取到code--通过code查询出product数据对应的size和type；对应的指定的po表
                //--通过code查询出product对应的数据size和type
                for (int j = 0; j < deptproducts.size(); j++) {
                    if (deptproducts.get(j).getCode().equals(code)){
                        type = deptproducts.get(j).getType();
                        size = deptproducts.get(j).getSize();
                        for (int k = 0; k < cyDeptpos.size(); k++) {
                            if (cyDeptpos.get(k).getType().equals(type)&&cyDeptpos.get(k).getSize()==size){
                                sumProductive = cyDeptpos.get(k).getSumProductive();//先要判断是否超出对应的sumProductive,在不超出的情况下计算其余之和
                                cyDeptsalesexcel.setSumZhu(sumProductive);
                            }
                        }
                    }
                }
                cyDeptsalesexcel.setCode(code);
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
                //这里通过读取每一条的code，找到对应的寸别和成型方式所对应的组--将最大产能填入
                cyDeptsalesexcel.setIssueNumber(issueNumber);
                //先将数据构建完毕，将数据存储到linklist里， 然后写个方法传 list参数进行批量新增，（批量insert需要查找jdbc有没有方法）
                //获取个人需求：
                cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);//按条插入
                //这里插入，每次插入的时候进行一次更新

            }
        }
        return AjaxResult.success("数据存储成功",200);
    }

    /*
    * 修改填报派单 (将销售数据整张插入销售表)
    * */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:edit')") ---第二次的插入接口
    @Log(title = "填报派单", businessType = BusinessType.UPDATE)*/
    @RequestMapping("/salesexcel/adds")
    public AjaxResult edit(@RequestBody(required=false) String string)
    {
        /*//列数
        int rownum=0;
        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(string).getJSONObject("data");
        //一行
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(json, CyDeptsalesexcel.class);
        String userName = cyDeptsalesexcel.getUserName();
        int size = dataList.size();//获取一共有多少个字段

        //装将excel转化为行的数据
        List<CyDeptsalesexcel> list1 = new ArrayList<>();
        List<CyDeptsalesexcel> list2 = new ArrayList<>();
        //获取最后一个格的信息
        String s2 = dataList.get(size).toString();
        ConfigMergeModel configMergeModel_last = JSON.toJavaObject(s2, ConfigMergeModel.class);
        //总列数
        int i1 = configMergeModel_last.getC() + 1;
        //总行数
        int i2 = configMergeModel_last.getR() + 1;
        //根据行数创建出行数个excel行
        *//*List<CyDeptsalesexcel> extracted1 = extracted(list1, i2);*//*
        ConfigMergeModel configMergeModels = null;
        ArrayList<CyDeptsalesexcel> list = new ArrayList<>();
        //获取json字段

        for (int j = 0; j < dataList.size(); j++) {//j，算出总计的单元格个数190--10行，19列
            String s = dataList.get(j).toString();
            *//*SheetOption sheetOption = new SheetOption();
            sheetOption = dataList.get(j).toString();*//*
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
            *//*SheetOption sheetOption = JSON.toJavaObject(s, SheetOption.class);
            System.out.println("sheetOption = " + sheetOption);*//*
            *//*cyDeptsalesexcel.get*//*
            int r1 = configMergeModels.getR();//行数
            if (r1==0){//说明是标题行直接跳过
                continue;
            }*/
        /*System.out.println("string = " + string);*/
        /*SheetOption sheetOption = JSON.toJavaObject(string, SheetOption.class);
        System.out.println("configMergeModel = " + sheetOption);*/

        /*//列数
        int rownum=0;
        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(string).getJSONObject("data");
        //一行
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(json, CyDeptsalesexcel.class);
        String userName = cyDeptsalesexcel.getUserName();
        int size = dataList.size();//获取一共有多少个字段
        //装将excel转化为行的数据
        List<CyDeptsalesexcel> list1 = new ArrayList<>();
        List<CyDeptsalesexcel> list2 = new ArrayList<>();
        //获取最后一个格的信息
        String s2 = dataList.get(size).toString();
        ConfigMergeModel configMergeModel_last = JSON.toJavaObject(s2, ConfigMergeModel.class);
        //总列数
        int i1 = configMergeModel_last.getC() + 1;
        //总行数
        int i2 = configMergeModel_last.getR() + 1;
        //根据行数创建出行数个excel行
        *//*List<CyDeptsalesexcel> extracted1 = extracted(list1, i2);*//*
        ConfigMergeModel configMergeModels = null;
        ArrayList<CyDeptsalesexcel> list = new ArrayList<>();
        //获取json字段
        for (int j = 0; j < dataList.size(); j++) {//j，算出总计的单元格个数190--10行，19列
            String s = dataList.get(j).toString();
            *//*SheetOption sheetOption = new SheetOption();
            sheetOption = dataList.get(j).toString();*//*
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
            *//*SheetOption sheetOption = JSON.toJavaObject(s, SheetOption.class);
            System.out.println("sheetOption = " + sheetOption);*//*
     *//*cyDeptsalesexcel.get*//*
            int r1 = configMergeModels.getR();//行数
            if (r1==0){//说明是标题行直接跳过
                continue;
            }*/
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

        ArrayList<CyDeptsalesexcel> list = new ArrayList<>();
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
                    /*rows = cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);
                    id = cyDeptsalesexcel.getId();*/
                }
                //已存入id，时间
                if (configMergeModels.getC() == 1 && configMergeModels.getV().getM() != null) {
                    String v1 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDemandname(v1);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 2 && configMergeModels.getV().getM() != null) {
                    String v2 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setCode(v2);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 3 && configMergeModels.getV().getM() != null) {
                    String v3 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setName(v3);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 4 && configMergeModels.getV().getM() != null) {
                    String v4 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname2(v4);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 5 && configMergeModels.getV().getM() != null) {
                    String v5 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSeibancode(v5);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 6 && configMergeModels.getV().getM() != null) {
                    String v6 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname5(v6);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 7 && configMergeModels.getV().getM() != null) {
                    String v7 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname3(v7);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 8 && configMergeModels.getV().getM() != null) {
                    String v8 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPubdescseg32(v8);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 9 && configMergeModels.getV().getM() != null) {
                    String v9 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setShuliang(Integer.valueOf(v9));
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 10 && configMergeModels.getV().getM() != null) {
                    String v10 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setLjpc(Integer.valueOf(v10));
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 11 && configMergeModels.getV().getM() != null) {
                    String v11 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setT3(String.valueOf(v11));
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 12 && configMergeModels.getV().getM() != null) {
                    String v12 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setXq(Integer.valueOf(v12));
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 13 && configMergeModels.getV().getM() != null) {
                    String v13 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setMark(v13);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 14 && configMergeModels.getV().getM() != null) {
                    String v14 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg7(v14);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 15 && configMergeModels.getV().getM() != null) {
                    String v15 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg9(v15);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 16 && configMergeModels.getV().getM() != null) {
                    String v16 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSaleslineId(v16);
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
                if (configMergeModels.getC() == 17 && configMergeModels.getV().getM() != null) {
                    String v17 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSumZhu(new BigDecimal(v17));
                    /*cyDeptsalesexcel.setId(id);
                    cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel);*/
                }
//                if (configMergeModels.getC() == 18 && configMergeModels.getV().getM() != null) {
                if (configMergeModels.getC() == 18 ) {
                    String v18 = configMergeModels.getV().getM();
                    Integer integer = new Integer(0);
                    if(v18!=null){
                        integer=Integer.valueOf(v18);
                    }
                    cyDeptsalesexcel.setPersonalNeeds(integer);
                    /*cyDeptsalesexcel.setId(id);*/
                    cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);
                    //list.add(cyDeptsalesexcel);
                }
                /*list.add(cyDeptsalesexcel);*/
            }
        }
        /*cyDeptsalesexcelService.insertBatch(list);*/
        return AjaxResult.success("操作成功",200);

        //测试使用缓存
        //测试使用缓存
        /*redisTemplate.opsForValue().set("cyDeptsalesexcel",string);
        System.out.println("string = " + redisTemplate.opsForValue().get("cyDeptsalesexcel"));
        if (redisTemplate.opsForValue().get("cyDeptsalesexcel")!=null){
            ThreadDemo threadDemo = new ThreadDemo();
            threadDemo.start();//启动多线程，执行字段解析插入操做
            return AjaxResult.success("缓存成功"); //此时可以进行派单确认工作，后台继续执行插入工作
        }
        return AjaxResult.error("无缓存内容存储");*/


    }

    /*private List<CyDeptsalesexcel> extracted(List<CyDeptsalesexcel> list1, int i2) {
        for (int j = 0; j < i2; j++) {
            CyDeptsalesexcel cyDeptsalesexcel1 = new CyDeptsalesexcel(IssueNumber, );
            list1.add(cyDeptsalesexcel1);
        }
        return list1;*/
    //1-19取值赋值  cyDeptsalesexcel每行新的数据，configMergeModels
    /**
     * 删除填报派单  当需要更新excel先进行删除再插入
     * @param
     * @return  返回删除结果
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptsalesexcel:remove')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.DELETE)*/
	@PostMapping ("/salesexcel/delete")
    public Object remove(@RequestBody String string)
    {
        System.out.println("string = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("userInfo");
        Integer ajaxResult = null;
        CyDeptsalesexcel cyDeptsalesexcel = JSON.toJavaObject(jsonObject, CyDeptsalesexcel.class);
        Integer issueNumber = cyDeptsalesexcel.getIssueNumber();
        String userName = cyDeptsalesexcel.getUserName();
        Integer[] array2=null;
        if (issueNumber!=null&&userName!=null){
            ArrayList<Integer> objects = new ArrayList<>();
            List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
            for (int i = 0; i < cyDeptsalesexcels.size(); i++) {
                Integer id = cyDeptsalesexcels.get(i).getId();
                objects.add(id);
            }
            //将查询出来的填报派单的模板数据的id 存放到list中
            //调用批量删除（百度）
            array2 = objects.toArray(new Integer[objects.size()]);//将arrays转成list
        }
        if (array2.length!=0){
            ajaxResult = cyDeptsalesexcelService.deleteCyDeptsalesexcelByIds(array2);
        }if (ajaxResult==null){
        return toAjax(0);
    }
        return toAjax(ajaxResult);
    }
    }