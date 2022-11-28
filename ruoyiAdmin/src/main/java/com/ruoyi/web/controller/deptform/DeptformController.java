package com.ruoyi.web.controller.deptform;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.system.service.impl.CyDeptsalesexcelServiceImpl;
import com.ruoyi.web.controller.cydeptSalesExcel.CyDeptsalesexcelController;
import io.lettuce.core.RedisClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
 * 填报派单Controller
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/deptform")*/
public class DeptformController extends BaseController {
    @Autowired
    private IDeptformService deptformService;
    @Autowired
    private ICyDeptorderinsertService cyDeptorderinsertService;
    @Autowired
    private ICyDeptsalesexcelService cyDeptsalesexcelService;
    @Autowired
    private IDeptqiService deptqiService;

    public static Integer issnumbeR;
    public static Integer cyFromId;
    public static String  usernamE;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 查询填报派单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:list')")*/
    @RequestMapping("/system/deptform/list")
    public TableDataInfo list(@RequestBody String string) {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(jsonObject, Deptform.class);
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        return getDataTable(list);
    }

    /**
     * 取消确认，更新状态为0
     *
     * @param
     * @return
     */
    @RequestMapping("/system/deptform/ack") //传入期号
    public AjaxResult listack(@RequestBody String string) {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(jsonObject, Deptform.class);
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        Integer id = list.get(0).getId();
        deptform.setId(id);
        deptform.setState(0);
        deptformService.updateDeptform(deptform);
        Deptform deptform1 = deptformService.selectDeptformById(id);
        return AjaxResult.success(deptform1);
    }

    /**
     * 查询填报派单列表
     */
    @RequestMapping("/system/deptform/listAdd")
    public Object listAdd(@RequestBody String string) {
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        List<Deptqi> deptqis = deptqiService.selectDeptqiList(new Deptqi());
        Integer id = deptqis.get(deptqis.size() - 1).getId();
        char deptOrder = deptqis.get(deptqis.size() - 1).getDeptOrder();
        deptform.setDeptqiId(id);
        List<Deptform> deptforms = deptformService.selectDeptformList(deptform);
        if (deptOrder != '1') {//说明重复添加--没有生成
            return 0;
        } else {
            deptform.setDeptqiId(id);
            deptform.setStartTime(deptqis.get(deptqis.size() - 1).getStartTime());
            deptform.setEndTime(deptqis.get(deptqis.size() - 1).getEndTime());
            Integer issueNumber = deptqis.get(deptqis.size() - 1).getIssueNumber();
            deptform.setIssueNumber(issueNumber);
            List<Deptform> listFirst = deptformService.selectDeptformList(deptform);
            if (listFirst.size() == 0) {
                deptformService.insertDeptform(deptform);//将数据更新到派单填报表
                List<Deptform> list = deptformService.selectDeptformList(deptform);
                return getDataTable(list);
            }
            if (listFirst != null) {
                if (issueNumber == listFirst.get(listFirst.size() - 1).getIssueNumber()) {
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
    public void export(HttpServletResponse response, Deptform deptform) {
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
     * 新增填报派单 --更新状态
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:add')")
    @Log(title = "填报派单", businessType = BusinessType.INSERT)*/
    @PostMapping("/system/deptform/updateState")
    public AjaxResult updateState(@RequestBody String string) {
        //派单表和派单信息表
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        int rows = deptformService.updateDeptform(deptform);
        if (rows > 0) {
            return AjaxResult.success("更新状态成功", 200);
        }
        return AjaxResult.error("状态更新失败", 500);
    }

    /**
     * 修改填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:edit')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.UPDATE)*/
    @PutMapping("/system/deptform/listUpdate")
    public AjaxResult edit(@RequestBody String string) {
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        return toAjax(deptformService.updateDeptform(deptform));
    }

    /**
     * 删除填报派单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptform:remove')")*/
    /*@Log(title = "填报派单", businessType = BusinessType.DELETE)*/
    @PostMapping("/system/deptform/id")
    public AjaxResult remove(@RequestBody String string) {
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptfor = JSON.toJavaObject(data, Deptform.class);
        Integer id = deptfor.getId();//填报派单的id 以及是否是插单 判断要不要去查询 插单表--通过id查询插单表的 番号 ，料号 ，需求分类 ==>进行删除
        String userName = deptfor.getUserName();
        Deptform deptform = deptformService.selectDeptformById(id);
        Integer insertOrder = deptform.getInsertOrder();//通过传入的id反查是否插单的标识
        Integer issueNumber = deptform.getIssueNumber();
        CyDeptsalesexcel cyDeptsalesexcel = new CyDeptsalesexcel();
        cyDeptsalesexcel.setIssueNumber(issueNumber);
        cyDeptsalesexcel.setUserName(userName);
        //填报派单的id 以及是否是插单 判断要不要去查询 插单表
        if (insertOrder!=0) { //满足 1 ；此条数据为插单数据
            CyDeptorderinsert cyDeptorderinsert = new CyDeptorderinsert();//创建插单表对象
            CyDeptsalesexcel cyDeptsalesexcel1 = new CyDeptsalesexcel();//销售单
            cyDeptorderinsert.setCyFromId(id);//将传入的id 给到插单表进行反查
            List<CyDeptorderinsert> cyDeptorderinserts = cyDeptorderinsertService.selectCyDeptorderinsertList(cyDeptorderinsert);
            //通过id进行反查 销售表单 对应数据
            if (cyDeptorderinserts.size()!=0){
            Integer id3 = cyDeptorderinserts.get(0).getId();
            cyDeptsalesexcel1.setDemandname(cyDeptorderinserts.get(0).getDemandname());//需求分类
            cyDeptsalesexcel1.setIssueNumber(issueNumber);//期号
            cyDeptsalesexcel1.setUserName(userName);//用户名
            cyDeptsalesexcel1.setSeibancode(cyDeptorderinserts.get(0).getSeibancode());//番号
            cyDeptsalesexcel1.setCode(cyDeptorderinserts.get(0).getCode());//料号
            List<CyDeptsalesexcel> cyDeptsalesexcels1 = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel1);//通过条件查询对应的一条数据
            if (cyDeptsalesexcels1.size()!=0){//当销售表中没有此数据，不对销售表进行操作
            Integer id2 = cyDeptsalesexcels1.get(0).getId();//获取销售派单表单id
                CyDeptsalesexcel cyDeptsalesexcel2 = cyDeptsalesexcelService.selectCyDeptsalesexcelById(id2);
                Integer xq = cyDeptsalesexcel2.getXq();
                if (xq!=0||xq!=null){  //else 当需求是 0 ，不做操作
                    cyDeptsalesexcel2.setXq(0);
                    cyDeptsalesexcel2.setId(id2);
            cyDeptsalesexcelService.updateCyDeptsalesexcel(cyDeptsalesexcel2);}}//更新对应 插单 的对应销售派单表数据 需求为 0；
            cyDeptorderinsertService.deleteCyDeptorderinsertById(id3);}//删除插单表数据
        }
        else {
        //批量删除
        Integer[] array2 = null;
        ArrayList<Integer> objects = new ArrayList<>();
        List<CyDeptsalesexcel> cyDeptsalesexcels = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel);
        if (cyDeptsalesexcels.size() != 0) {
            for (int i = 0; i < cyDeptsalesexcels.size(); i++) {
                Integer id1 = cyDeptsalesexcels.get(i).getId();
                objects.add(id1);
                if (cyDeptsalesexcels.size() > 2000 && i > 2000) {
                    array2 = objects.toArray(new Integer[objects.size()]);//将arrays转成list
                    cyDeptsalesexcelService.deleteCyDeptsalesexcelByIds(array2);
                    objects.clear();
                }
            }
            if (cyDeptsalesexcels.size() <= 2000) {
                array2 = objects.toArray(new Integer[objects.size()]);//将arrays转成list
                cyDeptsalesexcelService.deleteCyDeptsalesexcelByIds(array2);
            }
        }}
        int row1 = deptformService.deleteDeptformById(id);
        return toAjax(row1);
    }

    //插单 接口 --传入期号 ；如果期号在 合并汇总中有，则返回提示 --无需进行汇总直接合并
    @PostMapping("/system/deptform/orderInsert")
    public Object orderInsert(@RequestBody String string) {
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        List<Deptform> deptforms = deptformService.selectDeptformList(new Deptform());
        Deptform deptformlist = deptforms.get(deptforms.size() - 1);
        Deptform deptform1 = new Deptform();
        deptform1.setStartTime(deptformlist.getStartTime());
        deptform1.setEndTime(deptformlist.getEndTime());
        deptform1.setIssueNumber(deptformlist.getIssueNumber());
        deptform1.setUserName(deptform.getUserName());
        deptform1.setInsertOrder(deptform.getInsertOrder());
        deptform1.setState(0);
        int rows = deptformService.insertDeptform(deptform1);
        if (rows == 1) {
            deptform1 = deptformService.selectDeptformById(deptform1.getId());
        } else {
            deptform1 = null;
        }
        List<Object> list = new ArrayList<>();
        list.add(deptform1);
        return getDataTable(list);
    }
    @PostMapping("/system/deptsalesexcel/NAndIr")//--进行表的制作----第一次查看的时候传入用户名和期号进行表的绘制
    public AjaxResult add(@RequestBody String string)//这里需要获取销售人员名字.期号
    {
        JSONObject data = JSON.parseObject(string).getJSONObject("data");
        Deptform deptform = JSON.toJavaObject(data, Deptform.class);
        Integer issueNumber = deptform.getIssueNumber();
        String userName = deptform.getUserName();
        Integer id = deptform.getId();
        issnumbeR = issueNumber;
        usernamE = userName;
        cyFromId = id;
        if (issueNumber!=null&&userName!=null){
            return AjaxResult.success("操作成功",200);
        }
        return AjaxResult.error("获取参数不全");
    }
    //对 插单表进行查询
    //获取单行 的标题
    @PostMapping("/system/deptform/ordInsert")
    public String selectInsert(Deptform deptform) {
        CyDeptorderinsert cyDeptsalesexcel = new CyDeptorderinsert();
        cyDeptsalesexcel.setUserName(usernamE);
        cyDeptsalesexcel.setIssueNumber(issnumbeR);
        cyDeptsalesexcel.setCyFromId(cyFromId);//通过用户名，期号，id，去查询 插单表中的数据
        List<CyDeptorderinsert> lists = cyDeptorderinsertService.selectCyDeptorderinsertList(cyDeptsalesexcel);
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
            for (int j = 0; j < 21; j++) {//列
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
                        v = "上期排产量";
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
                    if (j == 19) {
                        v = "期数";
                    }
                    if (j == 20) {
                        v = "完工数量";
                    }
                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                    continue;
                }
                //所以的表头
                if (j == 0) {
                    if (lists.get(i - 1).getModifiedon() != null) {
                        Date modifiedon = lists.get(i - 1).getModifiedon();
                        v = sdf.format(modifiedon);
                        //v = modifiedon.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 1) {
                    if (lists.get(i - 1).getDemandname() != null) {
                        String demandname = lists.get(i - 1).getDemandname();
                        v = demandname.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 2) {
                    if (lists.get(i - 1).getCode() != null) {
                        String code = lists.get(i - 1).getCode();
                        v = code.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 3) {
                    if (lists.get(i - 1).getName() != null) {
                        String name = lists.get(i - 1).getName();
                        v = name.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 4) {
                    if (lists.get(i - 1).getPlmname2() != null) {
                        String plmname2 = lists.get(i - 1).getPlmname2();
                        v = plmname2.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 5) {
                    if (lists.get(i - 1).getSeibancode() != null) {
                        String seibancode = lists.get(i - 1).getSeibancode();
                        v = seibancode.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 6) {
                    if (lists.get(i - 1).getPlmname5() != null) {
                        String plmname5 = lists.get(i - 1).getPlmname5();
                        v = plmname5.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 7) {
                    if (lists.get(i - 1).getPlmname3() != null) {
                        String plmname3 = lists.get(i - 1).getPlmname3();
                        v = plmname3.toString();
                    } else {
                        v = "0";
                    }

                }
                if (j == 8) {
                    if (lists.get(i - 1).getDescflexfieldPubdescseg32() != null) {
                        String descflexfieldPubdescseg32 = lists.get(i - 1).getDescflexfieldPubdescseg32();
                        v = descflexfieldPubdescseg32.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 9) {
                    if (lists.get(i - 1).getShuliang() != null) {
                        Integer shuliang = lists.get(i - 1).getShuliang();
                        v = shuliang.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 10) {
                    if (lists.get(i - 1).getLjpc() != null) {
                        Integer ljpc = lists.get(i - 1).getLjpc();
                        v = ljpc.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 11) {
                    if (lists.get(i - 1).getT3() != null) {
                        String t3 = lists.get(i - 1).getT3();
                        v = t3.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 12) {
                    if (lists.get(i - 1).getXq() != null) {
                        Integer xq = lists.get(i - 1).getXq();
                        v = xq.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 13) {
                    if (lists.get(i - 1).getMark() != null) {
                        String mark = lists.get(i - 1).getMark();
                        v = mark.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 14) {
                    if (lists.get(i - 1).getDescflexfieldPrivatedescseg7() != null) {
                        String descflexfieldPrivatedescseg7 = lists.get(i - 1).getDescflexfieldPrivatedescseg7();
                        v = descflexfieldPrivatedescseg7.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 15) {
                    if (lists.get(i - 1).getDescflexfieldPrivatedescseg9() != null) {
                        String descflexfieldPrivatedescseg9 = lists.get(i - 1).getDescflexfieldPrivatedescseg9();
                        v = descflexfieldPrivatedescseg9.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 16) {
                    if (lists.get(i - 1).getSaleslineId() != null) {
                        String saleslineId = lists.get(i - 1).getSaleslineId();
                        v = saleslineId;
                    } else {
                        v = "0";
                    }
                }
                if (j == 17) {
                    if (lists.get(i - 1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i - 1).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 18) {
                    if (lists.get(i - 1).getPersonalNeeds() != null) {
                        Integer personalNeeds = lists.get(i - 1).getPersonalNeeds();
                        v = personalNeeds.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 19) {
                    if (lists.get(i - 1).getIssueNumber() != null) {
                        Integer issueNumber = lists.get(i - 1).getIssueNumber();
                        v = issueNumber.toString();
                    } else {
                        v = "0";
                    }
                }
                if (j == 20) {
                    if (lists.get(i - 1).getSumZhu() != null) {
                        BigDecimal sumZhu = lists.get(i - 1).getSumZhu();
                        v = sumZhu.toString();
                    } else {
                        v = "0";
                    }
                }

                //随机生成点数据
                Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                stop.getCelldata().add(celldata);
                continue;
            }//所以的表头
        }

        list.add(stop);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonArray.toString();
    }

    // 对查单表进行保存 -- 每次插入的时候判断 数据库中是否有，如果有 对销售需求进行 sum 并且更新销售需求
    @RequestMapping("/order/insterSave/save")
    public AjaxResult orderInsterSave(@RequestBody(required = false) String string) {
        //每次插入前先执行 通过 id直接删除
        CyDeptorderinsert deptorderinsert = new CyDeptorderinsert();
        deptorderinsert.setCyFromId(cyFromId);
        List<CyDeptorderinsert> list = cyDeptorderinsertService.selectCyDeptorderinsertList(deptorderinsert);
        for (int i = 0; i < list.size(); i++) {
            Integer id = list.get(i).getId();
            cyDeptorderinsertService.deleteCyDeptorderinsertById(id);
        }
        //先删除
        //再保存  每次插入的时候判断 数据库中是否有，如果有 对销售需求进行 sum 并且更新销售需求
        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(string).getJSONObject("data");
        CyDeptorderinsert cyDeptsalesexcel = JSON.toJavaObject(json, CyDeptorderinsert.class);
        /*System.out.println("celldata = " + dataList);*/
        int r = 0;
        int rows = 0;
        CyDeptsalesexcel cyDeptsal = new CyDeptsalesexcel();
        ConfigMergeModel configMergeModels = null;
        for (int j = 0; j < dataList.size(); j++) {//j，算出总计的单元格个数190--10行，19列
            String s = dataList.get(j).toString();
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
            int r1 = configMergeModels.getR();//行数
            if (r1 == 0) {//说明是标题行直接跳过
                continue;
            } else {

                CyDeptorderinsert cyDeptorderinsert = new CyDeptorderinsert();
                //当为ture时说明关键字段都满足
                int c = configMergeModels.getC();
                if (configMergeModels.getC() == 1 && configMergeModels.getV().getM() != null) {
                        String v1 = configMergeModels.getV().getM();
                        cyDeptsal.setDemandname(v1);
                    }
                    if (configMergeModels.getC() == 2 && configMergeModels.getV().getM() != null)//料号
                    {
                        String v2 = configMergeModels.getV().getM();
                        cyDeptsal.setCode(v2);
                    }
                    if (configMergeModels.getC() == 5 && configMergeModels.getV().getM() != null)//番号
                    {
                        String v5 = configMergeModels.getV().getM();
                        cyDeptsal.setSeibancode(v5);
                    }
                    if (configMergeModels.getC() == 12 && configMergeModels.getV().getM() != null)//销售需求
                    {
                        String v12 = configMergeModels.getV().getM();
                        cyDeptsal.setXq(Integer.valueOf(v12));
                        cyDeptsal.setIssueNumber(issnumbeR);
                        cyDeptsal.setUserName(usernamE);//这里获取到对应的数据需求分类，料号，番号，销售需求---到 cyDeptsal
                        //去销售表中查询  对应的数据，填充数据
                        CyDeptsalesexcel cyDeptsalesexcel1 = new CyDeptsalesexcel();
                        cyDeptsalesexcel1.setUserName(cyDeptsal.getUserName());//用户名
                        cyDeptsalesexcel1.setIssueNumber(cyDeptsal.getIssueNumber());//期号
                        cyDeptsalesexcel1.setSeibancode(cyDeptsal.getSeibancode());//番号
                        cyDeptsalesexcel1.setCode(cyDeptsal.getCode());//料号  没有进行销售需求判断
                        cyDeptsalesexcel1.setDemandname(cyDeptsal.getDemandname());//需求分类
                        List<CyDeptsalesexcel> cyDeptorderinserts = cyDeptsalesexcelService.selectCyDeptsalesexcelList(cyDeptsalesexcel1);
                        if (cyDeptorderinserts.size() != 0) {//这里只获取第一行
                            cyDeptorderinsert.setModifiedon(cyDeptorderinserts.get(0).getModifiedon());
                            cyDeptorderinsert.setDemandname(cyDeptsal.getDemandname());
                            cyDeptorderinsert.setCode(cyDeptsal.getCode());
                            cyDeptorderinsert.setName(cyDeptsal.getName());
                            cyDeptorderinsert.setPlmname2(cyDeptorderinserts.get(0).getPlmname2());
                            cyDeptorderinsert.setSeibancode(cyDeptorderinserts.get(0).getSeibancode());
                            cyDeptorderinsert.setPlmname5(cyDeptorderinserts.get(0).getPlmname5());
                            cyDeptorderinsert.setPlmname3(cyDeptorderinserts.get(0).getPlmname3());
                            cyDeptorderinsert.setDescflexfieldPubdescseg32(cyDeptorderinserts.get(0).getDescflexfieldPubdescseg32());
                            cyDeptorderinsert.setShuliang(cyDeptorderinserts.get(0).getShuliang());
                            cyDeptorderinsert.setLjpc(cyDeptorderinserts.get(0).getLjpc());
                            cyDeptorderinsert.setT3(cyDeptorderinserts.get(0).getT3());
                            Integer xq1 = cyDeptsal.getXq();
                            cyDeptorderinsert.setMark(cyDeptorderinserts.get(0).getMark());
                            cyDeptorderinsert.setDescflexfieldPrivatedescseg7(cyDeptorderinserts.get(0).getDescflexfieldPrivatedescseg7());
                            cyDeptorderinsert.setDescflexfieldPrivatedescseg9(cyDeptorderinserts.get(0).getDescflexfieldPrivatedescseg9());
                            cyDeptorderinsert.setSaleslineId(cyDeptorderinserts.get(0).getSaleslineId());
                            cyDeptorderinsert.setUserName(cyDeptsal.getUserName());
                            //这里通过读取每一条的code，找到对应的寸别和成型方式所对应的组--将最大产能填入
                            cyDeptorderinsert.setIssueNumber(cyDeptsal.getIssueNumber());
                            cyDeptorderinsert.setCyFromId(cyFromId);
                            // 每次插入的时候判断 数据库中是否有，如果有 对销售需求进行 sum 并且更新销售需求
                            CyDeptorderinsert cyDeptorderinsert1 = new CyDeptorderinsert();
                            cyDeptorderinsert1.setModifiedon(cyDeptorderinserts.get(0).getModifiedon());
                            cyDeptorderinsert1.setDemandname(cyDeptsal.getDemandname());
                            cyDeptorderinsert1.setCode(cyDeptsal.getCode());
                            cyDeptorderinsert1.setName(cyDeptsal.getName());
                            cyDeptorderinsert1.setPlmname2(cyDeptorderinserts.get(0).getPlmname2());
                            cyDeptorderinsert1.setSeibancode(cyDeptorderinserts.get(0).getSeibancode());
                            cyDeptorderinsert1.setPlmname5(cyDeptorderinserts.get(0).getPlmname5());
                            cyDeptorderinsert1.setPlmname3(cyDeptorderinserts.get(0).getPlmname3());
                            cyDeptorderinsert1.setDescflexfieldPubdescseg32(cyDeptorderinserts.get(0).getDescflexfieldPubdescseg32());
                            cyDeptorderinsert1.setShuliang(cyDeptorderinserts.get(0).getShuliang());
                            cyDeptorderinsert1.setLjpc(cyDeptorderinserts.get(0).getLjpc());
                            cyDeptorderinsert1.setT3(cyDeptorderinserts.get(0).getT3());
                            cyDeptorderinsert1.setMark(cyDeptorderinserts.get(0).getMark());
                            cyDeptorderinsert1.setDescflexfieldPrivatedescseg7(cyDeptorderinserts.get(0).getDescflexfieldPrivatedescseg7());
                            cyDeptorderinsert1.setDescflexfieldPrivatedescseg9(cyDeptorderinserts.get(0).getDescflexfieldPrivatedescseg9());
                            cyDeptorderinsert1.setSaleslineId(cyDeptorderinserts.get(0).getSaleslineId());
                            cyDeptorderinsert1.setUserName(cyDeptsal.getUserName());
                            List<CyDeptorderinsert> cyDeptorderinserts1 = cyDeptorderinsertService.selectCyDeptorderinsertList(cyDeptorderinsert1);
                            if (cyDeptorderinserts1.size()!=0){//说明插单表中有存在数据
                                for (int i = 0; i < cyDeptorderinserts1.size(); i++) {
                                    Integer xq = cyDeptorderinserts1.get(i).getXq();
                                    xq1 = xq1 + xq;
                                }
                            }
                            cyDeptorderinsert.setXq(xq1);//需求从插单表中获取
                            rows = cyDeptorderinsertService.insertCyDeptorderinsert(cyDeptorderinsert);//保存到插单表
                            if (rows==1){
                                return toAjax(rows);
                            }

                        }

                    }
            }
        }
        return toAjax(0);
    }
}











