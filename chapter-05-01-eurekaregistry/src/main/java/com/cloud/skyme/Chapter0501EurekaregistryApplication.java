package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName Chapter0501EurekaregistryApplication
 * @Description 服务注册与发现
 * @author zhangfeng
 * @Date 2017年11月21日 上午10:06:50
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Chapter0501EurekaregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0501EurekaregistryApplication.class, args);
	}
}
