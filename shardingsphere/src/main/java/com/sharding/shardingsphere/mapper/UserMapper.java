package com.sharding.shardingsphere.mapper;

import com.sharding.shardingsphere.domain.User;

public interface UserMapper {

    int insertSelective(User user);

    User selectByPrimarykey(Integer id);
}
