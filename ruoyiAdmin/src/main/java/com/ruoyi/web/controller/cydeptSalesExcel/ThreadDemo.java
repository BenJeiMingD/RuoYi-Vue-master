package com.ruoyi.web.controller.cydeptSalesExcel;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.MybatisBatchUtils;
import com.ruoyi.system.domain.ConfigMergeModel;
import com.ruoyi.system.domain.CyDeptsalesexcel;
import com.ruoyi.system.service.ICyDeptsalesexcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ThreadDemo extends Thread{

    //查询redis缓存
    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public ICyDeptsalesexcelService cyDeptsalesexcelService;

    @Override
    public void run() {

        String deptsalesexcel = redisTemplate.opsForValue().get("cyDeptsalesexcel").toString();
        System.out.println("cyDeptsalesexcel = " + deptsalesexcel);
        JSONObject jsonObject = JSON.parseObject(deptsalesexcel);
        JSONArray dataList = jsonObject.getJSONObject("data").getJSONArray("dataList");//将json格式转换成数组
        JSONObject json = JSON.parseObject(deptsalesexcel).getJSONObject("data");
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
                        //LOGGER.error("时间转换错误, string = {}", s, e);
                    }
                    System.out.println("date = " + date);
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
                if (configMergeModels.getC() == 4 && configMergeModels.getV().getM() != null) {
                    String v4 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setPlmname2(v4);

                }
                if (configMergeModels.getC() == 5 && configMergeModels.getV().getM() != null) {
                    String v5 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSeibancode(v5);

                }
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
                    String v16 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSaleslineId(v16);

                }
                if (configMergeModels.getC() == 17 && configMergeModels.getV().getM() != null) {
                    String v17 = configMergeModels.getV().getM();
                    cyDeptsalesexcel.setSumZhu(new BigDecimal(v17));

                }
                if (configMergeModels.getC() == 18 ) {
                    String v18 = configMergeModels.getV().getM();
                    Integer integer = new Integer(0);
                    if(v18!=null){
                        integer=Integer.valueOf(v18);
                    }
                    cyDeptsalesexcel.setPersonalNeeds(integer);
                    cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel);
                }
                /*MybatisBatchUtils mybatisBatchUtils = new MybatisBatchUtils();//批量插入----测试
                mybatisBatchUtils.batchUpdateOrInsert(list, CyDeptsalesexcel.class,
                        (userMst, CyDeptsalesexcelm) -> cyDeptsalesexcelService.insertCyDeptsalesexcel(cyDeptsalesexcel));*/
            }
        }

    }

}
