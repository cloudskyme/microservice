package com.cloud.skyme.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/")// base，最终调用接口后会和paths拼接在一起
				.select().paths(or(regex("/api/.*|/redis/.*")))// 过滤的接口
				.build().apiInfo(testApiInfo());
	}

	private ApiInfo testApiInfo() {
		return new ApiInfoBuilder().title("缓存测试")// 大标题
				.description("缓存测试")// 详细描述
				.version("1.0版")// 版本
				.termsOfServiceUrl("NO terms of service").contact("cloudskyme@163.com ")// 作者
				.license("The Apache License, Version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build();
	}

}