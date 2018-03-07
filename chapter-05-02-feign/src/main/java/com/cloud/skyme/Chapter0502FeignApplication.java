package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ClassName Chapter0502FeignApplication
 * @Description feign客户端调用 测试
 * @author zhangfeng
 * @Date 2017年11月21日 下午4:05:52
 * @version 1.0.0
 */
@EnableDiscoveryClient //用于启动服务发现功能
@EnableFeignClients //用于启动Fegin功能
@SpringBootApplication
public class Chapter0502FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter0502FeignApplication.class, args);
	}
}
