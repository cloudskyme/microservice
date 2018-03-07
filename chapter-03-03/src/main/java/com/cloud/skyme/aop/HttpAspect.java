/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.aop
 *
 *    Filename:    HttpAspect.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月24日 下午5:33:24
 *
 *    Revision:
 *
 *    2017年10月24日 下午5:33:24
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
/**
 * @ClassName HttpAspect
 * @Description http请求aop
 * @author zhangfeng
 * @Date 2017年10月24日 下午5:33:24
 * @version 1.0.0
 */
@Aspect
@Component
public class HttpAspect {
	
	//使用org.slf4j.Logger,这是Spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
    @Pointcut("execution(public * com.cloud.skyme.controller..*())")
    public void log(){}

    /**
     * 记录HTTP请求开始时的日志
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class={} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //参数
        logger.info("参数={}",joinPoint.getArgs());
    }

    /**
     * 记录HTTP请求结束时的日志
     */
    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution", request.getRequestURL());
    }

    /**
     * 获取返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }

}
