package com.sharding.shardingsphere.mapper;

import com.sharding.shardingsphere.domain.T;

public interface TMapper {

    int insertSelective(T t);

    T selectByPrimarykey(Integer id);
}
