package com.cloud.skyme;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @ClassName Chapter050304Application
 * @Description turbine集中收集
 * @author zhangfeng
 * @Date 2017年11月29日 下午3:47:27
 * @version 1.0.0
 */
@SpringBootApplication
@EnableTurbine
public class Chapter050304Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Chapter050304Application.class).web(true).run(args);
	}
}
