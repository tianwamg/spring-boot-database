package com.db.mybatismultidatasource.mapper.master;

import com.db.mybatismultidatasource.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface IMasterSysUserMapper {

    int insert(SysUser sysUser);

    List<SysUser> getAll();

    int deleteByPrimarykey(int id);
}
