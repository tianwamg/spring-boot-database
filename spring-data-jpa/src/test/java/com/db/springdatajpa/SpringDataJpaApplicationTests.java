package com.db.springdatajpa;

import com.db.springdatajpa.domain.QSysUser;
import com.db.springdatajpa.domain.SysUser;
import com.db.springdatajpa.repository.SysUserRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    SysUserRepository sysUserRepository;

    @Test
    public void findSysUser(){
        SysUser sysUser = new SysUser();
        sysUser.setId(1);
        Example<SysUser> example = Example.of(sysUser);
        Optional<SysUser> optional = sysUserRepository.findOne(example);
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"id");
        Page<SysUser> page = sysUserRepository.findAll(pageable);
        optional.ifPresent(n -> System.out.println(n.getUserName()));

    }

    @Test
    public void predicateTest(){
        QSysUser qSysUser = QSysUser.sysUser;
        Predicate predicate =qSysUser.id.intValue().eq(1);
        Page<SysUser> page1 = sysUserRepository.findAll(predicate,PageRequest.of(0,10));
    }

    @Autowired
    EntityManager entityManager;

    private JPAQueryFactory queryFactory;


    @PostConstruct
    public void inint(){
        queryFactory = new JPAQueryFactory(entityManager);
    }
    @Test
    public void queryFactoryTest(){
        QSysUser qSysUser = QSysUser.sysUser;

        SysUser sysUser = queryFactory.selectFrom(qSysUser)
                .where(qSysUser.id.eq(1))
                .fetchOne();
        System.out.println(sysUser.getUserName());

    }

}
