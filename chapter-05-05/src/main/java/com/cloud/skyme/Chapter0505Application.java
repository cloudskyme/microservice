package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cloud.skyme.filter.PreRequestLogFilter;

/**
 * @ClassName Chapter0505Application
 * @Description zuul网关配置
 * @author zhangfeng
 * @Date 2017年12月1日 上午9:36:12
 * @version 1.0.0
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Chapter0505Application {

	/**
	 * @Description 请求日志过滤器
	 * @return
	 */
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter0505Application.class, args);
	}
}
