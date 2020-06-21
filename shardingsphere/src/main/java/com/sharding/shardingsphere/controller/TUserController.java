package com.sharding.shardingsphere.controller;

import com.sharding.shardingsphere.domain.TUser;
import com.sharding.shardingsphere.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    TUserService tUserService;

    @PostMapping("/insert")
    public int insert(TUser tUser){
        return tUserService.insert(tUser);
    }

    @GetMapping("/userid")
    public TUser selectByUserid(int userid){
        return tUserService.selectByUserid(userid);
    }

    @GetMapping("/age")
    public List<TUser> selectByAge(int age){
        return tUserService.selectByAge(age);
    }

    @GetMapping("/list")
    public List<TUser> list(){
        return tUserService.getList();
    }
}
