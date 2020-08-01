package com.mybatis.mybatisreadwrite;

import com.mybatis.mybatisreadwrite.model.SysUser;
import com.mybatis.mybatisreadwrite.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisReadWriteApplicationTests {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void contextLoads() {
        List<SysUser> list = sysUserService.getAll();
        System.out.println(list.size());
    }

}
