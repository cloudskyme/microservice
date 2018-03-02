package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cloud.skyme.datasource.DynamicDataSourceRegister;

/**
 * @ClassName Chapter030403Application
 * @Description 应用启动类
 * @author zhangfeng
 * @Date 2017年10月28日 下午6:48:31
 * @version 1.0.0
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
public class Chapter030403Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030403Application.class, args);
	}
	
}
