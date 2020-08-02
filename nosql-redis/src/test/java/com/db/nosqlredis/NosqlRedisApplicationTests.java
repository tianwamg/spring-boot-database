package com.db.nosqlredis;

import com.db.nosqlredis.filter.MyBloomFilter;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NosqlRedisApplicationTests {

    @Test
    public void contextLoads() {
        String s1 = "bloom";
        String s2 = "nosql-redis";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(s1));
        System.out.println(filter.contains(s2));
        filter.add(s1);
        filter.add(s2);
        System.out.println(filter.contains(s1));
        System.out.println(filter.contains(s2));

    }

}
