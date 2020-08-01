package com.mybatis.mybatisreadwrite.bean;

import com.mybatis.mybatisreadwrite.enums.DBTypeEnum;
import org.springframework.core.annotation.Order;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static AtomicInteger count = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbTypeEnum){
        contextHolder.set(dbTypeEnum);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTER);
        System.out.println("master");
    }

    public static void slave(){
        set(DBTypeEnum.SLAVE);
        System.out.println("slave");
    }
}
