package com.mybatis.mybatisreadwrite.mapper;

import com.mybatis.mybatisreadwrite.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISysUserMapper {

    int insert(SysUser sysUser);

    List<SysUser> getAll();

    int deleteByPrimarykey(int id);
}
