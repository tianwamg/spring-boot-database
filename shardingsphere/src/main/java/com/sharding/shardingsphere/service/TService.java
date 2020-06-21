package com.sharding.shardingsphere.service;

import com.sharding.shardingsphere.domain.T;
import com.sharding.shardingsphere.mapper.TMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TService {

    @Autowired
    TMapper tMapper;


    public int insertSelective(T t){
        return tMapper.insertSelective(t);
    }

    public T selectByPrimaryKey(Integer id){
        return tMapper.selectByPrimarykey(id);
    }
}
