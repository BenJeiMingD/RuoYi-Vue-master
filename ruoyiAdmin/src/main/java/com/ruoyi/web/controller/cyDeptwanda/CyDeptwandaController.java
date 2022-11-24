package com.ruoyi.web.controller.cyDeptwanda;
import com.alibaba.fastjson2.JSONArray;

import java.math.BigDecimal;
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
 * 插单Controller
 *
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
public class CyDeptwandaController extends BaseController {
    @Autowired
    private ICyDeptsalesexcelService cyDeptsalesexcelService;

    @Autowired
    private ICyDeptwandaService cyDeptwandaService;

    /**
     * 查询插单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwanda:list')")*/
    @RequestMapping("/deptwanda/listxxx")
    public String list(CyDeptwanda cyDeptwanda) {
        startPage();
        int c = 0;
        //这里先查询虚拟表中的数据
        List<CyDeptwanda> list = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);


        //把响应的数据添加到自建表中

        for (int i = 0; i < list.size(); i++) {//获取他的行数id--i--r
            Integer r = list.get(i).getId();
            Date modifiedon = list.get(i).getModifiedon();
            String demandname = list.get(i).getDemandname();
            String code = list.get(i).getCode();
            String name = list.get(i).getName();
            String plmname2 = list.get(i).getPlmname2();
            String seibancode = list.get(i).getSeibancode();
            String plmname5 = list.get(i).getPlmname5();
            String plmname3 = list.get(i).getPlmname3();
            String descflexfieldPubdescseg32 = list.get(i).getDescflexfieldPubdescseg32();
            Integer shuliang = list.get(i).getShuliang();
            Integer ljpc = list.get(i).getLjpc();
            String t3 = list.get(i).getT3();
            Integer xq = list.get(i).getXq();
            String mark = list.get(i).getMark();
            String descflexfieldPrivatedescseg7 = list.get(i).getDescflexfieldPrivatedescseg7();
            String descflexfieldPrivatedescseg9 = list.get(i).getDescflexfieldPrivatedescseg9();
            String saleslineId = list.get(i).getSaleslineId();
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
                cyDeptwanda.setPlmname5(plmname5);
                cyDeptwanda.setPlmname3(plmname3);
                cyDeptwanda.setDescflexfieldPubdescseg32(descflexfieldPubdescseg32);
                cyDeptwanda.setShuliang(shuliang);
                cyDeptwanda.setLjpc(ljpc);
                cyDeptwanda.setT3(t3);
                cyDeptwanda.setXq(xq);
                cyDeptwanda.setMark(mark);
                cyDeptwanda.setDescflexfieldPrivatedescseg7(descflexfieldPrivatedescseg7);
                cyDeptwanda.setDescflexfieldPrivatedescseg9(descflexfieldPrivatedescseg9);
                cyDeptwanda.setSaleslineId(saleslineId);
                int deptwanda = cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
            }
        }

        ArrayList<ConfigMergeModel> lsits = new ArrayList<>();
        List<CyDeptwanda> Deptwandalist = cyDeptwandaService.selectBySaleslineIdList(cyDeptwanda);
        for (int i = 0; i < Deptwandalist.size(); i++) {//获取他的行数id--i--r
            Integer r = Deptwandalist.get(i).getId();
            System.out.println("Deptwandalist = " + Deptwandalist);
            Date modifiedon = Deptwandalist.get(i).getModifiedon();
            String demandname = Deptwandalist.get(i).getDemandname();
            String code = Deptwandalist.get(i).getCode();
            String name = Deptwandalist.get(i).getName();
            String plmname2 = Deptwandalist.get(i).getPlmname2();
            String seibancode = Deptwandalist.get(i).getSeibancode();
            String plmname5 = Deptwandalist.get(i).getPlmname5();
            String plmname3 = Deptwandalist.get(i).getPlmname3();
            String descflexfieldPubdescseg32 = Deptwandalist.get(i).getDescflexfieldPubdescseg32();
            Integer shuliang = Deptwandalist.get(i).getShuliang();
            Integer ljpc = Deptwandalist.get(i).getLjpc();
            String t3 = Deptwandalist.get(i).getT3();
            Integer xq = Deptwandalist.get(i).getXq();
            String mark = Deptwandalist.get(i).getMark();
            String descflexfieldPrivatedescseg7 = Deptwandalist.get(i).getDescflexfieldPrivatedescseg7();
            String descflexfieldPrivatedescseg9 = Deptwandalist.get(i).getDescflexfieldPrivatedescseg9();
            String saleslineId = Deptwandalist.get(i).getSaleslineId();
           /* ConfigMergeModel configMergeModel = new ConfigMergeModel();
            configMergeModel.setR(r);//给r赋值*/
            if (Deptwandalist.get(i).getModifiedon() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(modifiedon.toString());
                configMergeModelv.setV(modifiedon.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 0;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/

                //c=0;--构造函数
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(modifiedon.toString(), modifiedon.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);

            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getDemandname() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(demandname.toString());
                configMergeModelv.setV(demandname.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 1;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(demandname, demandname, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getCode() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(code);
                configMergeModelv.setV(code);
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 2;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(code, code, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);

            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getName() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(name.toString());
                configMergeModelv.setV(name.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 3;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(name, name, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getPlmname2() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(plmname2.toString());
                configMergeModelv.setV(plmname2.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 4;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname2, plmname2, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getSeibancode() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(seibancode.toString());
                configMergeModelv.setV(seibancode.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 5;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(seibancode, seibancode, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getPlmname5() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(plmname5.toString());
                configMergeModelv.setV(plmname5.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 6;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname5, plmname5, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getPlmname3() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(plmname3.toString());
                configMergeModelv.setV(plmname3.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 7;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname3, plmname3, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPubdescseg32() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(descflexfieldPubdescseg32.toString());
                configMergeModelv.setV(descflexfieldPubdescseg32.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 8;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPubdescseg32, descflexfieldPubdescseg32, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getShuliang() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(shuliang.toString());
                configMergeModelv.setV(shuliang.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 9;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(shuliang.toString(), shuliang.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getLjpc() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(ljpc.toString());
                configMergeModelv.setV(ljpc.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 10;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(ljpc.toString(), ljpc.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getT3() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(t3.toString());
                configMergeModelv.setV(t3.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 11;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(t3.toString(), t3.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getXq() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(xq.toString());
                configMergeModelv.setV(xq.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 12;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(xq.toString(), xq.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getMark() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(mark.toString());
                configMergeModelv.setV(mark.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 13;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(mark, mark, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg7() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(descflexfieldPrivatedescseg7.toString());
                configMergeModelv.setV(descflexfieldPrivatedescseg7.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 14;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPrivatedescseg7, descflexfieldPrivatedescseg7, configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg9() != null) {
                /*ConfigMergeModelS configMergeModelS = new ConfigMergeModelS();
                configMergeModelS.setFa("General");
                configMergeModelS.setT("g");
                ConfigMergeModel configMergeModel = new ConfigMergeModel();
                configMergeModel.setR(r);//给r赋值
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv();
                configMergeModelv.setM(descflexfieldPrivatedescseg9.toString());
                configMergeModelv.setV(descflexfieldPrivatedescseg9.toString());
                configMergeModel.setV(configMergeModelv);
                configMergeModelv.setCt(configMergeModelS);*/
                c = 15;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General", "g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPrivatedescseg9.toString(), descflexfieldPrivatedescseg9.toString(), configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r, c, configMergeModelv);
                lsits.add(configMergeModel);
            }
        }
        System.out.println(" lsits= " + Deptwandalist.size());
        /*JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(lsits));*/
        return null;

        /*list.add(stop);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonArray.toString();*/
    }

    /**
     * 导出插单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwanda:export')")
    @Log(title = "插单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyDeptwanda cyDeptwanda)
    {
        List<CyDeptwanda> list = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
        ExcelUtil<CyDeptwanda> util = new ExcelUtil<CyDeptwanda>(CyDeptwanda.class);
        util.exportExcel(response, list, "插单数据");
    }*/

    /**
     * 获取插单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:deptwanda:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(cyDeptwandaService.selectCyDeptwandaById(id));
    }

    /**
     * 修改万达数据
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwanda:add')")*/
    /*@Log(title = "插单", businessType = BusinessType.INSERT)*/
    @RequestMapping("/deptwanda/adds")
    public AjaxResult addDeptwanda(@RequestBody String string) {
        //删除 万达原始数据 - 重新写入新数据 ：
        int row = cyDeptwandaService.deleteCyDeptwanda();
        if (row==0){
            return AjaxResult.error("操作失败",500);
        }
        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(string).getJSONObject("data");
        CyDeptwanda cyDeptsalesexcel = JSON.toJavaObject(json, CyDeptwanda.class);
        int size = dataList.size();//获取一共有多少个字段
        int r = 0;
        int rows = 0;
        ArrayList<Object> ids = new ArrayList<>();
        ConfigMergeModel configMergeModels = null;
        ConfigMergeModel configMergeModels1 = null;
        ArrayList<CyDeptsalesexcel> list = new ArrayList<>();
        for (int j = 0; j < dataList.size(); j++) {//j，算出总计的单元格个数190--10行，19列
            String s = dataList.get(j).toString();
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
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

                    }
                    cyDeptsalesexcel.setModifiedon(date);//设置时间

                }
                //已存入id，时间
                if (configMergeModels.getC() == 1 && configMergeModels.getV().getM() != null) {
                    String v1 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDemandname(v1);

                }
                if (configMergeModels.getC() == 2 && configMergeModels.getV().getM() != null) {
                    String v2 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setCode(v2);

                }
                if (configMergeModels.getC() == 3 && configMergeModels.getV().getM() != null) {
                    String v3 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setName(v3);

                }
                //Plmname2
                if (configMergeModels.getC() == 4 && configMergeModels.getV().getM() != null) {
                    String v2 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname2(v2);

                }
                //Plmname5
                if (configMergeModels.getC() == 5 && configMergeModels.getV().getM() != null) {
                    String v5 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSeibancode(v5);

                }
                //Plmname3
                if (configMergeModels.getC() == 6 && configMergeModels.getV().getM() != null) {
                    String v6 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname5(v6);

                }
                if (configMergeModels.getC() == 7 && configMergeModels.getV().getM() != null) {
                    String v7 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname3(v7);

                }
                if (configMergeModels.getC() == 8 && configMergeModels.getV().getM() != null) {
                    String v8 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPubdescseg32(v8);

                }
                if (configMergeModels.getC() == 9 && configMergeModels.getV().getM() != null) {
                    String v9 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setShuliang(Integer.valueOf(v9));

                }
                if (configMergeModels.getC() == 10 && configMergeModels.getV().getM() != null) {
                    String v10 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setLjpc(Integer.valueOf(v10));

                }
                if (configMergeModels.getC() == 11 && configMergeModels.getV().getM() != null) {
                    String v11 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setT3(String.valueOf(v11));

                }
                if (configMergeModels.getC() == 12 && configMergeModels.getV().getM() != null) {
                    String v12 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setXq(Integer.valueOf(v12));

                }
                if (configMergeModels.getC() == 13 && configMergeModels.getV().getM() != null) {
                    String v13 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setMark(v13);

                }
                if (configMergeModels.getC() == 14 && configMergeModels.getV().getM() != null) {
                    String v14 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg7(v14);

                }
                if (configMergeModels.getC() == 15 && configMergeModels.getV().getM() != null) {
                    String v15 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setDescflexfieldPrivatedescseg9(v15);

                }
                if (configMergeModels.getC() == 16 && configMergeModels.getV().getM() != null) {
                    String v15 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSaleslineId(v15);
                    rows = cyDeptwandaService.insertCyDeptwanda(cyDeptsalesexcel);
                }

            }
        }

        if (rows==0){
            return AjaxResult.error("操作失败",500);
        }
        return AjaxResult.success("操作成功",200);
    }

    /**
     * 修改插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptwanda:edit')")
    @Log(title = "插单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptwanda cyDeptwanda) {
        return toAjax(cyDeptwandaService.updateCyDeptwanda(cyDeptwanda));
    }

    /**
     * 删除插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptwanda:remove')")
    @Log(title = "插单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(cyDeptwandaService.deleteCyDeptwandaByIds(ids));
    }
    /*查看数据源*/
    @PostMapping("/deptwanda/list")
    @ResponseBody
    public String loadurl (CyDeptwanda cyDeptwanda) {
        List<SheetOption> list = new ArrayList<>();
        Map keys = new HashMap();
        SheetOption stop = new SheetOption();
        //设置sheet页名
        stop.setName("options");
        //设置sheet页索引
        stop.setIndex("1");
        stop.setStatus(1);
        stop.setHide(0);
        //把响应的数据添加到自建表中
        List<CyDeptwanda> Deptwandalist = cyDeptwandaService.selectBySaleslineIdList(new CyDeptwanda());
            for (int i = 0; i < Deptwandalist.size()+1; i++) {//行
                String v=null;
                for (int j = 0; j < 18; j++) {//列
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
                            v="上期排产量";
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
                        }if (j==17){
                            v="完工数量";
                        }
                        //随机生成点数据
                        Celldata celldata = new Celldata(i + "", j + "", i + j + "", v + "");
                        stop.getCelldata().add(celldata);
                        continue;
                    }
                        if (j==0){
                            if (Deptwandalist.get(i-1).getModifiedon()!=null){
                                Date modifiedon = Deptwandalist.get(i-1).getModifiedon();
                                v=modifiedon.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==1){
                            if (Deptwandalist.get(i-1).getDemandname()!=null){
                                String demandname = Deptwandalist.get(i-1).getDemandname();
                                v=demandname.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==2){
                            if (Deptwandalist.get(i-1).getCode()!=null){
                                String code = Deptwandalist.get(i-1).getCode();
                                v=code.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==3){
                            if (Deptwandalist.get(i-1).getName()!=null){
                                String name = Deptwandalist.get(i-1).getName();
                                v=name.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==4){
                            if (Deptwandalist.get(i-1).getPlmname2()!=null){
                                String plmname2 = Deptwandalist.get(i-1).getPlmname2();
                                v=plmname2.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==5){
                            if (Deptwandalist.get(i-1).getSeibancode()!=null){
                                String seibancode = Deptwandalist.get(i-1).getSeibancode();
                                v=seibancode.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==6){
                            if (Deptwandalist.get(i-1).getPlmname5()!=null){
                                String plmname5 = Deptwandalist.get(i-1).getPlmname5();
                                v=plmname5.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==7){
                            if (Deptwandalist.get(i-1).getPlmname3()!=null){
                                String plmname3 = Deptwandalist.get(i-1).getPlmname3();
                                v=plmname3.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==8){
                            if (Deptwandalist.get(i-1).getDescflexfieldPubdescseg32()!=null){
                                String descflexfieldPubdescseg32 = Deptwandalist.get(i-1).getDescflexfieldPubdescseg32();
                                v=descflexfieldPubdescseg32.toString();
                            }else {
                                v="0";
                            }

                        }
                        if (j==9){
                            if (Deptwandalist.get(i-1).getShuliang()!=null){
                                Integer shuliang = Deptwandalist.get(i-1).getShuliang();
                                v=shuliang.toString();

                            }else {
                                v="0";
                            }

                        }
                        if (j==10){
                            if (Deptwandalist.get(i-1).getLjpc()!=null){
                                Integer ljpc = Deptwandalist.get(i-1).getLjpc();
                                v=ljpc.toString();
                            }else {
                                v="0";

                            }

                        }
                        if (j==11){
                            if (Deptwandalist.get(i-1).getT3()!=null){
                                String t3 = Deptwandalist.get(i-1).getT3();
                                v=t3.toString();

                            }else {
                                v = "0";

                            }

                        }
                        if (j==12){
                            if (Deptwandalist.get(i-1).getXq()!=null){
                                Integer xq = Deptwandalist.get(i-1).getXq();
                                v=xq.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==13){
                            if (Deptwandalist.get(i-1).getMark()!=null){
                                String mark = Deptwandalist.get(i-1).getMark();
                                v=mark.toString();
                            }else {
                                v="";
                            }
                        }
                        if (j==14){
                            if (Deptwandalist.get(i-1).getDescflexfieldPrivatedescseg7()!=null){
                                String descflexfieldPrivatedescseg7 = Deptwandalist.get(i-1).getDescflexfieldPrivatedescseg7();
                                v=descflexfieldPrivatedescseg7.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==15){
                            if (Deptwandalist.get(i-1).getDescflexfieldPrivatedescseg9()!=null){
                                String descflexfieldPrivatedescseg9 = Deptwandalist.get(i-1).getDescflexfieldPrivatedescseg9();
                                v=descflexfieldPrivatedescseg9.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==16){
                            if (Deptwandalist.get(i-1).getSaleslineId()!=null){
                                String saleslineId = Deptwandalist.get(i-1).getSaleslineId();
                                v=saleslineId.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j==17){
                            if (Deptwandalist.get(i-1).getQty()!=null){
                                BigDecimal qty = Deptwandalist.get(i-1).getQty();
                                v=qty.toString();
                            }else {
                                v="0";
                            }
                        }
                        if (j == 11){
                            int line = i+1;
                            //2用（j+1）表示---根据不同的行数进行
                            /*//String f = "=if (J2-K2-R2<0,0,J2-K2-R2)";*/
                            String t3 = "0";
                            String f = "=if (J"+line+"-K"+line+"-R"+line+"<0,0,J"+line+"-K"+line+"-R"+line+")";
                            String m = "500";
                            //随机生成点数据
                            Celldata celldata = new Celldata(i + "", j + "",m +"",v + "",f+"");
                            stop.getCelldata().add(celldata);
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


    @PostMapping("/deptwanda/listss")
    @ResponseBody
    public String loadurl() {

        String s = "[\n" +
                "  {\n" +
                "    \"name\": \"Sheet1\",\n" +
                "    \"config\": {},\n" +
                "    \"index\": \"1\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"order\": \"0\",\n" +
                "    \"luckysheet_select_save\": [\n" +
                "      { \"row\": [0, 0], \"column\": [4, 4], \"sheetIndex\": 1 }\n" +
                "    ],\n" +
                "    \"zoomRatio\": 1,\n" +
                "    \"showGridLines\": \"1\",\n" +
                "    \"defaultColWidth\": 80,\n" +
                "    \"defaultRowHeight\": 20,\n" +
                "    \"celldata\": [\n" +
                "      {\n" +
                "        \"r\": 0,\n" +
                "        \"c\": 0,\n" +
                "        \"v\": {\n" +
                "          \"v\": \"Luckysheet\",\n" +
                "          \"ct\": { \"fa\": \"General\", \"t\": \"g\" },\n" +
                "          \"bg\": null,\n" +
                "          \"bl\": 0,\n" +
                "          \"it\": 0,\n" +
                "          \"ff\": 1,\n" +
                "          \"fs\": \"11\",\n" +
                "          \"ht\": 1,\n" +
                "          \"vt\": 1,\n" +
                "          \"m\": \"Luckysheet\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"calcChain\": []\n" +
                "  }\n" +
                "]\n";
        return s;
    }


}

