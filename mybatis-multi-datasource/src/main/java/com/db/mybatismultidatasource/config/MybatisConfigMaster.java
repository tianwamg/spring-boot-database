package com.db.mybatismultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.db.mybatismultidatasource.mapper.master",sqlSessionFactoryRef = "masterSqlSessionFactory",sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MybatisConfigMaster {

    @Resource(name = "dsMaster")
    DataSource dsMaster;

    @Bean
    SqlSessionFactory masterSqlSessionFactory(){
        SqlSessionFactory sqlSessionFactory = null;
        try{
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dsMaster);
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/db/mybatismultidatasource/mapper/master/mapping/*.xml"));
            sqlSessionFactory = bean.getObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    SqlSessionTemplate masterSqlSessionTemplate(){
        return new SqlSessionTemplate(masterSqlSessionFactory());
    }
}
