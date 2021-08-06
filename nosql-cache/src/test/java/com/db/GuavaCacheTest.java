package com.db;

import com.db.guava.GuavaCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuavaCacheTest {

    @Autowired
    GuavaCache guavaCache;

    @Test
    public void guava(){
        String k = guavaCache.get("k");
        System.out.println(k);
    }
}
