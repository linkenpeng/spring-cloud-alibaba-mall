package com.intecsec.mall.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-11-16 21:45
 **/
@Component
public class MyMateObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleteMark", 0, metaObject);
        this.setFieldValByName("gmtCreated", new Date(), metaObject);
        this.setFieldValByName("gmtUpdated", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtUpdated", new Date(), metaObject);
    }
}
