/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.config
 *
 *    Filename:    Swagger2Config.java
 *
 *    Description: Swagger2配置
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午2:32:58
 *
 *    Revision:
 *
 *    2017年11月8日 下午2:32:58
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2Config
 * @Description Swagger2配置
 * @author zhangfeng
 * @Date 2017年11月8日 下午2:32:58
 * @version 1.0.0
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.skyme"))
				.paths(PathSelectors.any())
                .build();
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://www.cnblogs.com/skyme/")
                .termsOfServiceUrl("http://www.cnblogs.com/skyme/")
                .version("1.0")
                .build();
    }

}
