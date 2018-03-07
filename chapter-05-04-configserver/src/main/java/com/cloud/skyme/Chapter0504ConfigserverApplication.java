package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName Chapter0504ConfigserverApplication
 * @Description config server配置
 * @author zhangfeng
 * @Date 2017年11月30日 下午3:12:00
 * @version 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class Chapter0504ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0504ConfigserverApplication.class, args);
	}
}
