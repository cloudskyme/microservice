package com.cloud.skyme;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName Chapter0503Application
 * @Description 熔断器测试
 * @author zhangfeng
 * @Date 2017年11月28日 下午4:02:10
 * @version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class Chapter050303Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Chapter050303Application.class).web(true).run(args);
	}
	
}
