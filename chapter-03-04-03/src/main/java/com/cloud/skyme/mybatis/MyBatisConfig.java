package com.cloud.skyme.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cloud.skyme.datasource.DynamicDataSource;

/**
 * @ClassName MyBatisConfig
 * @Description mybatis基础配置
 * @author zhangfeng
 * @Date 2017年10月31日 下午2:22:05
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.cloud.skyme.mapper"})
public class MyBatisConfig {

	@Autowired
	DynamicDataSource dataSource;//注入动态数据源

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryBean()); // 使用上面配置的Factory
        return template;
    }
}
