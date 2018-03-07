package com.cloud.skyme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ClassName Chapter0301ApplicationTests
 * @Description 接口单元测试
 * @author zhangfeng
 * @Date 2017年10月24日 上午9:27:09
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Chapter0301Application.class,webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter0301ApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHome() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).isEqualTo("欢迎使用Spring Boot!");
	}

}
