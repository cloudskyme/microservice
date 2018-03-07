package com.cloud.skyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching; 

/**
 * @ClassName Chapter030405Application
 * @Description redis缓存
 * @author zhangfeng
 * @Date 2018年3月7日 上午10:45:43
 * @version 1.0.0
 */
@MapperScan("com.cloud.skyme.mapper")
@EnableCaching  
@SpringBootApplication
public class Chapter030405Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030405Application.class, args);
	}
}
