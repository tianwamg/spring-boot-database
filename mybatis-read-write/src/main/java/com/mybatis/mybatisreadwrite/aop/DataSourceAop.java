package com.mybatis.mybatisreadwrite.aop;

import com.mybatis.mybatisreadwrite.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(-1)
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.mybatis.mybatisreadwrite.annotation.Master) " +
            "&& (execution(* com.mybatis.mybatisreadwrite.service..*.select*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.get*(..)))")
    public void readPointcut(){

    }

    @Pointcut("@annotation(com.mybatis.mybatisreadwrite.annotation.Master) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.insert*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.add*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.update*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.edit*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.delete*(..)) " +
            "|| execution(* com.mybatis.mybatisreadwrite.service..*.remove*(..))")
    public void writePointcut(){

    }

    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }

    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.mybatis.mybatisreadwrite.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }

}
