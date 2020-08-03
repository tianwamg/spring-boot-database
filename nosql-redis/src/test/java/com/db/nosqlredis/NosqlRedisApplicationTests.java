package com.db.nosqlredis;

import com.db.nosqlredis.filter.MyBloomFilter;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
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

    /**
     * 单机下使用guava bloom过滤器
     */
    @Test
    public void guavaBloomFilter(){
        /**
         * 创建1500大小的布隆过滤器,容错率0.01
         */
        BloomFilter<Integer> filter = BloomFilter.
                create(Funnels.integerFunnel(),1500,0.01);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }

}
