package com.mybatis.mybatisreadwrite.bean;

import com.mybatis.mybatisreadwrite.enums.DBTypeEnum;
import org.springframework.core.annotation.Order;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static AtomicInteger count = new AtomicInteger(-1);

    public static void set(String dbTypeEnum){
        contextHolder.set(dbTypeEnum);
    }

    public static String get(){
        return contextHolder.get();
    }

    public static void master(){
        set("master");
        System.out.println("master");
    }

    public static void slave(){
        set("slave");
        System.out.println("slave");
    }
}
