package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName Chapter0502RibbonApplication
 * @Description ribbon实现负载均衡
 * @author zhangfeng
 * @Date 2017年11月21日 上午11:39:39
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Chapter0502RibbonApplication {

	@Bean // 定义REST客户端，RestTemplate实例
	@LoadBalanced // 开启负债均衡的能力
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter0502RibbonApplication.class, args);
	}

}
