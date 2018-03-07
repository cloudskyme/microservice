package com.cloud.skyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching; 

@MapperScan("com.cloud.skyme.mapper")
@EnableCaching  
@SpringBootApplication
public class Chapter030405Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030405Application.class, args);
	}
}
