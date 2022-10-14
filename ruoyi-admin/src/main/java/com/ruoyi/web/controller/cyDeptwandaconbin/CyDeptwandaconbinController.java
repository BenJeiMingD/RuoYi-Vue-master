package com.ruoyi.web.controller.cyDeptwandaconbin;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.Celldata;
import com.ruoyi.system.domain.CyDeptwanda;
import com.ruoyi.system.domain.SheetOption;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CyDeptwandaconbin;
import com.ruoyi.system.service.ICyDeptwandaconbinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 万达jsonController
 *
 * @author ruoyi
 * @date 2022-10-13
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
/*@RequestMapping("/system/deptwandaconbin")*/
public class CyDeptwandaconbinController extends BaseController
{
    @Autowired
    private ICyDeptwandaconbinService cyDeptwandaconbinService;

    /**
     * 查询万达json列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:list')")
    @GetMapping("/list")
    public TableDataInfo list(CyDeptwandaconbin cyDeptwandaconbin)
    {
        startPage();
        List<CyDeptwandaconbin> list = cyDeptwandaconbinService.selectCyDeptwandaconbinList(cyDeptwandaconbin);
        return getDataTable(list);
    }*/

    /**
     * 导出万达json列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:export')")
    @Log(title = "万达json", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptwandaconbin cyDeptwandaconbin)
    {
        List<CyDeptwandaconbin> list = cyDeptwandaconbinService.selectCyDeptwandaconbinList(cyDeptwandaconbin);
        ExcelUtil<CyDeptwandaconbin> util = new ExcelUtil<CyDeptwandaconbin>(CyDeptwandaconbin.class);
        util.exportExcel(response, list, "万达json数据");
    }*/

    @PostMapping("/deptwandaconbin/list")
    public String loadurl (CyDeptwandaconbin cyDeptwanda) {
        List<SheetOption> list = new ArrayList<>();
        Map keys = new HashMap();
        SheetOption stop = new SheetOption();
        //设置sheet页名
        stop.setName("options");
        //设置sheet页索引
        stop.setIndex("1");
        stop.setStatus(1);
        stop.setHide(0);


        List<CyDeptwandaconbin> Deptwandalist = cyDeptwandaconbinService.selectCyDeptwandaconbinList(new CyDeptwandaconbin());
        for (int i = 0; i < Deptwandalist.size(); i++) {//行
            String v=null;

            for (int j = 0; j < 17; j++) {//列
                if(i==0){
                    if (j==0){
                        v="销售订单日期";
                    }
                    if (j==1){
                        v="需求分类";
                    }if (j==2){
                        v="料号";
                    }if (j==3){
                        v="名称";
                    }if (j==4){
                        v="规格";
                    }if (j==5){
                        v="番号";
                    }if (j==6){
                        v="花纹";
                    }if (j==7){
                        v="商标";
                    }if (j==8){
                        v="工艺";
                    }if (j==9){
                        v="订单数量";
                    }if (j==10){
                        v="累计排产量";
                    }if (j==11){
                        v="可排产量";
                    }if (j==12){
                        v="销售需求";
                    }if (j==13){
                        v="备注";
                    }if (j==14){
                        v="夏季硫化定额";
                    }if (j==15){
                        v="模具总数量";
                    }if (j==16){
                        v="销售行ID";
                    }
                    //随机生成点数据
                    Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                    stop.getCelldata().add(celldata);
                    continue;
                }
                //获取所有字段
                    /*if (j==0){
                        if (Deptwandalist.get(i).getId()!=null){
                            Integer id = Deptwandalist.get(i).getId();
                            v=id.toString();
                        }else {
                            v="0";
                        }

                    }*/
                if (j==0){
                    if (Deptwandalist.get(i).getModifiedon()!=null){
                        Date modifiedon = Deptwandalist.get(i).getModifiedon();
                        v=modifiedon.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==1){
                    if (Deptwandalist.get(i).getDemandname()!=null){
                        String demandname = Deptwandalist.get(i).getDemandname();
                        v=demandname.toString();
                    }else {
                        v="0";
                    }
                }
                if (j==2){
                    if (Deptwandalist.get(i).getCode()!=null){
                        String code = Deptwandalist.get(i).getCode();
                        v=code.toString();
                    }else {
                        v="0";
                    }
                }
                if (j==3){
                    if (Deptwandalist.get(i).getName()!=null){
                        String name = Deptwandalist.get(i).getName();
                        v=name.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==4){
                    if (Deptwandalist.get(i).getPlmname2()!=null){
                        String plmname2 = Deptwandalist.get(i).getPlmname2();
                        v=plmname2.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==5){
                    if (Deptwandalist.get(i).getSeibancode()!=null){
                        String seibancode = Deptwandalist.get(i).getSeibancode();
                        v=seibancode.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==6){
                    if (Deptwandalist.get(i).getPlmname5()!=null){
                        String plmname5 = Deptwandalist.get(i).getPlmname5();
                        v=plmname5.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==7){
                    if (Deptwandalist.get(i).getPlmname3()!=null){
                        String plmname3 = Deptwandalist.get(i).getPlmname3();
                        v=plmname3.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==8){
                    if (Deptwandalist.get(i).getDescflexfieldPubdescseg32()!=null){
                        String descflexfieldPubdescseg32 = Deptwandalist.get(i).getDescflexfieldPubdescseg32();
                        v=descflexfieldPubdescseg32.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==9){
                    if (Deptwandalist.get(i).getShuliang()!=null){
                        Integer shuliang = Deptwandalist.get(i).getShuliang();
                        v=shuliang.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==10){
                    if (Deptwandalist.get(i).getLjpc()!=null){
                        Integer ljpc = Deptwandalist.get(i).getLjpc();
                        v=ljpc.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==11){
                    if (Deptwandalist.get(i).getT3()!=null){
                        String t3 = Deptwandalist.get(i).getT3();
                        v=t3.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==12){
                    if (Deptwandalist.get(i).getXq()!=null){
                        Integer xq = Deptwandalist.get(i).getXq();
                        v=xq.toString();
                    }else {
                        v="0";
                    }

                }
                if (j==13){
                    if (Deptwandalist.get(i).getMark()!=null){
                        String mark = Deptwandalist.get(i).getMark();
                        v=mark.toString();
                    }else {
                        v="0";
                    }
                }
                if (j==14){
                    if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg7()!=null){
                        String descflexfieldPrivatedescseg7 = Deptwandalist.get(i).getDescflexfieldPrivatedescseg7();
                        v=descflexfieldPrivatedescseg7.toString();
                    }else {
                        v="0";
                    }
                }
                if (j==15){
                    if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg9()!=null){
                        String descflexfieldPrivatedescseg9 = Deptwandalist.get(i).getDescflexfieldPrivatedescseg9();
                        v=descflexfieldPrivatedescseg9.toString();
                    }else {
                        v="0";
                    }
                }
                if (j==16){
                    if (Deptwandalist.get(i).getSaleslineId()!=null){
                        String saleslineId = Deptwandalist.get(i).getSaleslineId();
                        v=saleslineId.toString();
                    }else {
                        v="0";
                    }
                        /*if (j==17){
                            if (Deptwandalist.get(i).getSaleslineId()!=null){
                                String saleslineId = Deptwandalist.get(i).getSaleslineId();
                                v=saleslineId.toString();
                            }else {
                                v="0";
                            }*/
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
     * 获取万达json详细信息
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cyDeptwandaconbinService.selectCyDeptwandaconbinById(id));
    }*/

    /**
     * 新增万达json
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:add')")
    @Log(title = "万达json", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyDeptwandaconbin cyDeptwandaconbin)
    {
        return toAjax(cyDeptwandaconbinService.insertCyDeptwandaconbin(cyDeptwandaconbin));
    }*/

    /**
     * 修改万达json
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:edit')")
    @Log(title = "万达json", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptwandaconbin cyDeptwandaconbin)
    {
        return toAjax(cyDeptwandaconbinService.updateCyDeptwandaconbin(cyDeptwandaconbin));
    }*/

    /**
     * 删除万达json
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwandaconbin:remove')")
    @Log(title = "万达json", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(cyDeptwandaconbinService.deleteCyDeptwandaconbinByIds(ids));
    }*/
}
