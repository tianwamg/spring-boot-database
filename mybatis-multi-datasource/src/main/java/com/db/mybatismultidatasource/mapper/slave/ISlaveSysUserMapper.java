package com.db.mybatismultidatasource.mapper.slave;

import com.db.mybatismultidatasource.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
public interface ISlaveSysUserMapper {

    int insert(SysUser sysUser);

    List<SysUser> getsAll();

    int deleteByPrimarykey(int id);
}
