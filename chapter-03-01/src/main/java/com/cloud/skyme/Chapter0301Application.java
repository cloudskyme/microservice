package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Chapter0301Application
 * @Description spring boot 启动类
 * @author zhangfeng
 * @Date 2017年10月23日 下午5:36:53
 * @version 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class Chapter0301Application {
	
	@RequestMapping("/")
	String home() {
		 return "欢迎使用Spring Boot!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter0301Application.class, args);
	}
}
