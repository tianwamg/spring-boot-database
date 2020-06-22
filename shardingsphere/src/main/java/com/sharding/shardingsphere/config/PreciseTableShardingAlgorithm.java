package com.sharding.shardingsphere.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * 按月分表
 */
public class PreciseTableShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String years = preciseShardingValue.getValue();

        String time = preciseShardingValue.getColumnName();
        String table = preciseShardingValue.getLogicTableName();
        if(StringUtils.isEmpty(years)){
            throw  new UnsupportedOperationException("years is null");
        }
        //按年路由
        for(String y:collection){
            String value = years.substring(4,6);
            if(y.endsWith(value)){
                return y;
            }
        }
        return null;
    }
}
