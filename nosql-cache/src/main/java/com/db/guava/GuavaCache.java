package com.db.guava;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class GuavaCache {


    private LoadingCache<String,String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(2,TimeUnit.DAYS)
            .maximumSize(200)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    //FIXME 此处应该请求数据库相关
                    return s + new Random().nextGaussian();
                }
            });

    public String get(String key){
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getIfPresent(String key){
        return cache.getIfPresent(key);
    }

    public void reload(String k){
        JSONPObject object = null;
        cache.put(k,object.toString());
    }

}
