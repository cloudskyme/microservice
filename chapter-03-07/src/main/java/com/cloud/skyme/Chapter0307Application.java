package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName Chapter0307Application
 * @Description 调度整合
 * @author zhangfeng
 * @Date 2017年11月8日 下午4:16:00
 * @version 1.0.0
 */
@SpringBootApplication
@EnableScheduling
public class Chapter0307Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0307Application.class, args);
	}
}
