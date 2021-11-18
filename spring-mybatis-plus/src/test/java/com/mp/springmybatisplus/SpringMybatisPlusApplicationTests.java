package com.mp.springmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.springmybatisplus.domain.SysUser;
import com.mp.springmybatisplus.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 参考：https://www.cnblogs.com/l-y-h/p/12859477.html
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisPlusApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void list(){

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getId,1);
        List<SysUser> list = sysUserMapper.selectList(queryWrapper);
        System.out.println("size...."+list.size());
    }

    @Test
    public void delete(){
        int i = sysUserMapper.deleteById(1);
        System.out.println(i);
    }

    @Test
    public void page(){
        Page<SysUser> page = new Page<>(1,10);
        sysUserMapper.selectPage(page,null);
        System.out.println(page.getRecords().size());
        System.out.println(page.getPages());

    }

}
