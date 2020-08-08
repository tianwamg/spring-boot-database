package com.db.mybatismultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.db.mybatismultidatasource.mapper.slave",sqlSessionFactoryRef = "slaveSqlSessionFactory",sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class MybatisConfigSlave {

    @Resource(name = "dsSlave")
    DataSource dsSlave;

    @Bean
    SqlSessionFactory slaveSqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = null;
        try{
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dsSlave);
            sqlSessionFactory = bean.getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    SqlSessionTemplate slaveSqlSessionTemplate(){
        return new SqlSessionTemplate(slaveSqlSessionFactory());
    }
}
