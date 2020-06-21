package com.sharding.shardingsphere.mapper;

import com.sharding.shardingsphere.domain.TUser;

import java.util.List;

public interface TUserMapper {

    int insertSelective(TUser tUser);

    TUser selectiveByUserid(Integer userid);

    List<TUser> selectByAge(Integer age);

    List<TUser> getList();
}
