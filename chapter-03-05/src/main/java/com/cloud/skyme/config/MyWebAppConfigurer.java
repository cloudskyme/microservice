/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.config
 *
 *    Filename:    MyWebAppConfigurer.java
 *
 *    Description: 添加自定义拦截器
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 上午10:44:12
 *
 *    Revision:
 *
 *    2017年11月8日 上午10:44:12
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cloud.skyme.interceptor.MyInterceptorPermissions;
import com.cloud.skyme.interceptor.MyInterceptorVerification;

/**
 * @ClassName MyWebAppConfigurer
 * @Description 添加自定义拦截器
 * @author zhangfeng
 * @Date 2017年11月8日 上午10:44:12
 * @version 1.0.0
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptorVerification()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptorPermissions()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
