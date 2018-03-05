/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.datasource
 *
 *    Filename:    DataSourceConfig.java
 *
 *    Description: 数据源配置
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月26日 上午11:16:52
 *
 *    Revision:
 *
 *    2017年10月26日 上午11:16:52
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.datasource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DataSourceConfig
 * @Description 数据源配置
 * @author zhangfeng
 * @Date 2017年10月26日 上午11:16:52
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfig {
	
	@Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}
