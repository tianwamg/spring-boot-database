package com.db.mybatismultidatasource;

import com.db.mybatismultidatasource.mapper.master.IMasterSysUserMapper;
import com.db.mybatismultidatasource.mapper.slave.ISlaveSysUserMapper;
import com.db.mybatismultidatasource.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMultiDatasourceApplicationTests {

    @Autowired
    ISlaveSysUserMapper slaveSysUserMapper;

    @Autowired
    IMasterSysUserMapper masterSysUserMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void master(){
        List<SysUser> list = masterSysUserMapper.getAll();
        System.out.println(list.size());
    }

    @Test
    public void slave(){
        List<SysUser> list = slaveSysUserMapper.getsAll();
        System.out.println(list.size());
    }

}
