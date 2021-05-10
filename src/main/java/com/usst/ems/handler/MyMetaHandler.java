package com.usst.ems.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

//自动填充
@Component
public class MyMetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("birth",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
