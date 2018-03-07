package com.cloud.skyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Chapter030401Application
 * @Description 单数据源应用启动类
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:27:23
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.cloud.skyme.mapper")
public class Chapter030401Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030401Application.class, args);
	}
}
