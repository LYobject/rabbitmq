package com.li.mp.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @ClassName MyMetaObjectHandler
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/26 13:25
 * @Version 1.0
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("updateTime")){
            metaObject.setValue("updateTime", LocalDateTime.now());
        }
        if (metaObject.hasGetter("createTime")){
            metaObject.setValue("createTime", LocalDateTime.now());
        }


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("updateTime")){
            metaObject.setValue("updateTime", LocalDateTime.now());
        }
    }
}
