package com.sharding.shardingsphere.controller;

import com.sharding.shardingsphere.domain.T;
import com.sharding.shardingsphere.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class TController {

    @Autowired
    TService tService;

    @PostMapping("/insert")
    public int insert(T t){
        return tService.insertSelective(t);
    }

    @GetMapping("/select")
    public T select(Integer id){
        return tService.selectByPrimaryKey(id);
    }
}
