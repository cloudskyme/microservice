package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName Chapter0501EurekaserverApplication
 * @Description EurekaServer服务
 * @author zhangfeng
 * @Date 2017年11月20日 下午5:35:20
 * @version 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class Chapter0501EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0501EurekaserverApplication.class, args);
	}
	
}
