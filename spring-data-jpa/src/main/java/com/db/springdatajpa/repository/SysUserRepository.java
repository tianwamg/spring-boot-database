package com.db.springdatajpa.repository;

import com.db.springdatajpa.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SysUserRepository extends JpaRepository<SysUser,Integer>, QuerydslPredicateExecutor<SysUser> {
}
