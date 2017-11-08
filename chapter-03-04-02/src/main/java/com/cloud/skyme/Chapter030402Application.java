package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName Chapter030402Application
 * @Description spring boot配置多数据源
 * @author zhangfeng
 * @Date 2017年10月26日 上午11:06:51
 * @version 1.0.0
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class Chapter030402Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030402Application.class, args);
	}
}
