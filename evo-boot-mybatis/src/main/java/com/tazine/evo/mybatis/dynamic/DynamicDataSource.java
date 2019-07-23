package com.tazine.evo.mybatis.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * DynamicDataSource
 *
 * @author frank
 * @date 2019/07/23
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return (Object) dataBaseType;
    }
}
