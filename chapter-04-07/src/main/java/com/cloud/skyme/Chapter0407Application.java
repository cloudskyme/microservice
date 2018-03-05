package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Chapter0407Application
 * @Description spring boot整合docker
 * @author zhangfeng
 * @Date 2017年11月16日 上午11:18:02
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
public class Chapter0407Application {
	
    /**
     * @Description 请求应用时直接返回相就的输出
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot And Docker World";
    }

	public static void main(String[] args) {
		SpringApplication.run(Chapter0407Application.class, args);
	}
}
