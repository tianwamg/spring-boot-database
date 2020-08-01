package com.mybatis.mybatisreadwrite.bean;

import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Order
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
