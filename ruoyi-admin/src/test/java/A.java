/*package com.ruoyi.web.controller.cyDeptwanda;*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class A extends BaseController
{
    @Autowired
    private ICyDeptwandaService cyDeptwandaService;

    /**
     * 查询插单列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwanda:list')")*/
    @GetMapping("/deptwanda/list")
    public List<ConfigMergeModel> list(CyDeptwanda cyDeptwanda)
    {
        startPage();
        int c = 0;
        //把响应的数据添加到自建表中
        List<CyDeptwanda> list = cyDeptwandaService.selectCyDeptwandaList(cyDeptwanda);
        for (int i = 0; i < list.size(); i++) {//获取他的行数id--i--r
            Integer r = list.get(i).getId();
            System.out.println("list = " + list);
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
            deptwanda1.setSaleslineId(saleslineId);

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
            if (Deptwandalist.get(i).getModifiedon()!=null){
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
                c=0;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/

                //c=0;--构造函数
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(modifiedon.toString(),modifiedon.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);

            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getDemandname()!=null){
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
                c=1;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(demandname,demandname,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getCode()!=null){
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
                c=2;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(code,code,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);

            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getName()!=null){
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
                c=3;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(name,name,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getPlmname2()!=null){
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
                c=4;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname2,plmname2,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getSeibancode()!=null){
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
                c=5;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(seibancode,seibancode,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            System.out.println(" lsits= " + lsits.toString());
            if (Deptwandalist.get(i).getPlmname5()!=null){
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
                c=6;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname5,plmname5,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getPlmname3()!=null){
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
                c=7;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(plmname3,plmname3,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPubdescseg32()!=null){
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
                c=8;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPubdescseg32,descflexfieldPubdescseg32,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getShuliang()!=null){
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
                c=9;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(shuliang.toString(),shuliang.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getLjpc()!=null){
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
                c=10;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(ljpc.toString(),ljpc.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getT3()!=null){
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
                c=11;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(t3.toString(),t3.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getXq()!=null){
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
                c=12;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(xq.toString(),xq.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getMark()!=null){
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
                c=13;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(mark,mark,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg7()!=null){
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
                c=14;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPrivatedescseg7,descflexfieldPrivatedescseg7,configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
            if (Deptwandalist.get(i).getDescflexfieldPrivatedescseg9()!=null){
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
                c=15;
                /*configMergeModel.setC(c);
                lsits.add(configMergeModel) ;*/
                ConfigMergeModelS configMergeModelS = new ConfigMergeModelS("General","g");
                ConfigMergeModelv configMergeModelv = new ConfigMergeModelv(descflexfieldPrivatedescseg9.toString(),descflexfieldPrivatedescseg9.toString(),configMergeModelS);
                ConfigMergeModel configMergeModel = new ConfigMergeModel(r,c,configMergeModelv);
                lsits.add(configMergeModel);
            }
        }
        System.out.println(" lsits= " + Deptwandalist.size());
        return lsits;
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
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(cyDeptwandaService.selectCyDeptwandaById(id));
    }

    /**
     * 新增插单
     */
    /*@PreAuthorize("@ss.hasPermi('system:deptwanda:add')")*/
    /*@Log(title = "插单", businessType = BusinessType.INSERT)*/
    @RequestMapping("/deptwanda/adds")
    public AjaxResult add(@RequestBody String string)
    {
        System.out.println("string = " + string);
        ConfigMergeModel configMergeModel = JSON.toJavaObject(string, ConfigMergeModel.class);
        System.out.println("configMergeModel = " + configMergeModel);
        CyDeptwanda cyDeptwanda = new CyDeptwanda();
        JSONObject jsonObject = JSON.parseObject(string);
        JSONArray dataList = jsonObject.getJSONArray("data");//将json格式转换成数组
        System.out.println("dataList = " + dataList);
        int size = dataList.size();//获取一共有多少个字段
        int r = 0;
        int rows = 0;
        ArrayList<Object> ids = new ArrayList<>();
        ConfigMergeModel configMergeModels=null;
        ConfigMergeModel configMergeModels1=null;
        /*int r2=0;
        for (int i = 0; i < dataList.size(); i++) {
            String s1 = dataList.get(i).toString();
            configMergeModels1 = JSON.toJavaObject(s1, ConfigMergeModel.class);
            r2 = configMergeModels1.getR();
        }*/
        for (int j = 0; j < dataList.size(); j++) {
            String s = dataList.get(j).toString();
            configMergeModels = JSON.toJavaObject(s, ConfigMergeModel.class);
            int r1 = configMergeModels.getR();
            String s1 = dataList.get(j).toString();
            configMergeModels1 = JSON.toJavaObject(s1, ConfigMergeModel.class);
            int r2 = configMergeModels1.getR();
            if (r1==r2){//确保是同一个id的数据
                if (cyDeptwandaService.selectCyDeptwandaById(configMergeModels.getR())==null){
                    cyDeptwanda.setId(r1);//设置id
                    rows = cyDeptwandaService.insertCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==0&&configMergeModels.getV().getM()!=null){
                    String m = configMergeModels.getV().getM();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    try {
                        Date parse = dateFormat.parse(m);
                        cyDeptwanda.setId(r1);
                        cyDeptwanda.setModifiedon(parse);//设置时间
                        cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                //已存入id，时间
                if (configMergeModels.getC()==1&&configMergeModels.getV().getM()!=null){
                    String v1 = configMergeModels.getV().getM();
                    cyDeptwanda.setDemandname(v1);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==2&&configMergeModels.getV().getM()!=null){
                    String v2 = configMergeModels.getV().getM();
                    cyDeptwanda.setCode(v2);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==3&&configMergeModels.getV().getM()!=null){
                    String v3 = configMergeModels.getV().getM();
                    cyDeptwanda.setName(v3);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==4&&configMergeModels.getV().getM()!=null){
                    String v4 = configMergeModels.getV().getM();
                    cyDeptwanda.setPlmname2(v4);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==5&&configMergeModels.getV().getM()!=null){
                    String v5 = configMergeModels.getV().getM();
                    cyDeptwanda.setSeibancode(v5);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==6&&configMergeModels.getV().getM()!=null){
                    String v6 = configMergeModels.getV().getM();
                    cyDeptwanda.setPlmname5(v6);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==7&&configMergeModels.getV().getM()!=null){
                    String v7 = configMergeModels.getV().getM();
                    cyDeptwanda.setPlmname3(v7);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==8&&configMergeModels.getV().getM()!=null){
                    String v8 = configMergeModels.getV().getM();
                    cyDeptwanda.setDescflexfieldPubdescseg32(v8);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if(configMergeModels.getC()==9&&configMergeModels.getV().getM()!=null){
                    String v9 = configMergeModels.getV().getM();
                    cyDeptwanda.setShuliang(Integer.valueOf(v9));
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==10&&configMergeModels.getV().getM()!=null){
                    String v10 = configMergeModels.getV().getM();
                    cyDeptwanda.setLjpc(Integer.valueOf(v10));
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==11&&configMergeModels.getV().getM()!=null){
                    String v11 = configMergeModels.getV().getM();
                    cyDeptwanda.setT3(String.valueOf(v11));
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==12&&configMergeModels.getV().getM()!=null){
                    String v12 = configMergeModels.getV().getM();
                    cyDeptwanda.setXq(Integer.valueOf(v12));
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==13&&configMergeModels.getV().getM()!=null){
                    String v13 = configMergeModels.getV().getM();
                    cyDeptwanda.setMark(v13);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==14&&configMergeModels.getV().getM()!=null){
                    String v14 = configMergeModels.getV().getM();
                    cyDeptwanda.setDescflexfieldPrivatedescseg7(v14);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
                if (configMergeModels.getC()==15&&configMergeModels.getV().getM()!=null){
                    String v15 = configMergeModels.getV().getM();
                    cyDeptwanda.setDescflexfieldPrivatedescseg9(v15);
                    cyDeptwanda.setId(r1);
                    cyDeptwandaService.updateCyDeptwanda(cyDeptwanda);
                }
            }
        }

        return toAjax(rows);
    }

    /**
     * 修改插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptwanda:edit')")
    @Log(title = "插单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyDeptwanda cyDeptwanda)
    {
        return toAjax(cyDeptwandaService.updateCyDeptwanda(cyDeptwanda));
    }

    /**
     * 删除插单
     */
    @PreAuthorize("@ss.hasPermi('system:deptwanda:remove')")
    @Log(title = "插单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(cyDeptwandaService.deleteCyDeptwandaByIds(ids));
    }
}
