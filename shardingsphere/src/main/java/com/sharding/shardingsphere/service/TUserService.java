package com.sharding.shardingsphere.service;

import com.sharding.shardingsphere.domain.TUser;
import com.sharding.shardingsphere.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserService {

    @Autowired
    TUserMapper tUserMapper;

    public int insert(TUser tUser){
        return tUserMapper.insertSelective(tUser);
    }

    public TUser selectByUserid(Integer userid){
        return tUserMapper.selectiveByUserid(userid);
    }

    public List<TUser> selectByAge(Integer age){
        return tUserMapper.selectByAge(age);
    }

    public List<TUser> getList(){
        return tUserMapper.getList();
    }
}
