/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.datasource
 *
 *    Filename:    MybatisDbAConfig.java
 *
 *    Description: ds1数据源配置
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月26日 下午3:15:07
 *
 *    Revision:
 *
 *    2017年10月26日 下午3:15:07
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisDbAConfig
 * @Description ds1数据源配置
 * @author zhangfeng
 * @Date 2017年10月26日 下午3:15:07
 * @version 1.0.0
 */
@Configuration
@MapperScan(basePackages = {"com.cloud.skyme.mapper.d1"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisDbAConfig {

    @Autowired
    @Qualifier("db1")
    private DataSource db1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(db1); // db1数据源
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }
}
