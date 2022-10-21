package com.ruoyi.web.core.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandleInfo;

 /*
 元数据处理器，处理自动填充问题
 时间管理依赖
  */
/*@Component
@Slf4j*/
/*public class MyMetaObjectHandler implements MetaObjectHandler {
   *//* @Override
    public void insertFill(MetaObject metaObject) {
      log.info("插入时间");
      *//**//*this.setFieldValByName("creatTime", DateUtil.date(),metaObject);
      this.setFieldValByName("updateTime",DateUtil.date(),metaObject);*//**//*
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时间");
        *//**//*this.setFieldValByName("updateTime",DateUtil.date(),metaObject);*//**//*
    }*//*
}*/
