package com.mybatis.mybatisreadwrite.service;

import com.mybatis.mybatisreadwrite.mapper.ISysUserMapper;
import com.mybatis.mybatisreadwrite.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    ISysUserMapper sysUserMapper;

    public int insert(SysUser sysUser){
        return sysUserMapper.insert(sysUser);
    }

    public List<SysUser> getAll(){
        return sysUserMapper.getAll();
    }

    public int deleteByPrimarykey(Integer id){
        return sysUserMapper.deleteByPrimarykey(id);
    }
}
