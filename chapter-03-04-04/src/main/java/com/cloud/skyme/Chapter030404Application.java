package com.cloud.skyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Chapter030404Application
 * @Description 事务回滚测试
 * @author zhangfeng
 * @Date 2017年11月2日 上午11:10:19
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.cloud.skyme.mapper")
public class Chapter030404Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030404Application.class, args);
	}
}
