package com.cloud.skyme.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName DynamicDataSource
 * @Description 动态数据源配置
 * @author zhangfeng
 * @Date 2017年10月28日 下午6:41:10
 * @version 1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceType();
	}

}
