package com.sharding.shardingsphere.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * 按年分库
 */
public class PreciseDBShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {

        //库的分片collection存放所有库的列表
        //配置的sharding-colunm值
        String years = preciseShardingValue.getValue();
        String year = preciseShardingValue.getColumnName();
        //需要分库的逻辑表
        String table = preciseShardingValue.getLogicTableName();
        if(StringUtils.isEmpty(years)){
            throw  new UnsupportedOperationException("years is null");
        }
        //按年路由
        for(String y:collection){
            if(y.endsWith(years)){
                return y;
            }
        }
        return null;
    }
}
