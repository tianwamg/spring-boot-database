package com.sharding.shardingsphere.service;

import com.sharding.shardingsphere.domain.User;
import com.sharding.shardingsphere.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TService {

    @Autowired
    UserMapper userMapper;


    public int insertSelective(User user){
        return userMapper.insertSelective(user);
    }

    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimarykey(id);
    }
}
