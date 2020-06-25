package com.sharding.shardingsphere.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 按月分表
 */
public class RangeTableShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        Range<Long> range = rangeShardingValue.getValueRange();
        long lower = range.lowerEndpoint();
        long upper = range.upperEndpoint();
        Date d1 = new Date(lower);
        Date d2 = new Date(upper);
        Collection<String>  routeTables = getRouteTable(rangeShardingValue.getLogicTableName(),d1,d2);
        return routeTables;
    }

    public Collection<String> getRouteTable(String logicName,Date lower,Date upper){
        Set<String> set = new HashSet<>();
        if(lower !=null && upper != null){
            List<String> rangeList = getRangerList(lower,upper);
            for(String s : rangeList){
                set.add(logicName+s);
            }
        }
        return set;
    }

    public List<String> getRangerList(Date startTime,Date endTime){
        List<String> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        while (calendar.before(endTime)){
            SimpleDateFormat sdf = new SimpleDateFormat("_YYYY_MM");
            String str = sdf.format(calendar.getTime());
            result.add(str);
            calendar.add(Calendar.MONTH,1);
        }
        return result;
    }
}
