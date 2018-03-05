package com.cloud.skyme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Chapter0504ConfigclientApplication
 * @Description configclient客户端配置
 * @author zhangfeng
 * @Date 2017年11月30日 下午4:33:43
 * @version 1.0.0
 */
@SpringBootApplication
@RestController
@RefreshScope
public class Chapter0504ConfigclientApplication {
	
	@Value("${configvalue}")
    String configvalue;
    /**
     * @Description 取得配置中心的值
     * @return
     */
    @RequestMapping(value = "/getvalue")
    public String getConfigvalue(){
        return this.configvalue;
    }

	public static void main(String[] args) {
		SpringApplication.run(Chapter0504ConfigclientApplication.class, args);
	}
	
	
}
