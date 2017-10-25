/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    HelloController.java
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
 *    Create at:   2017年10月23日 下午5:33:07
 *
 *    Revision:
 *
 *    2017年10月23日 下午5:33:07
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HelloController
 * @Description spring boot aop测试
 * @author zhangfeng
 * @Date 2017年10月23日 下午5:33:07
 * @version 1.0.0
 */
@RestController
@RequestMapping("/aop")
public class AopTestController {

	private final static Logger logger = LoggerFactory.getLogger(AopTestController.class);

	/**
	 * @Description 测试前置通知
	 * @return
	 */
	@RequestMapping("/testBeforeService.do")
	public String testBeforeService() {
		return "前四通知测试";
	}

	/**
	 * @Description 后置通知测试
	 * @param key
	 * @return
	 */
	@RequestMapping("/testAfterReturning.do")
	public String testAfterReturning() {
		return "后置通知测试";
	}

    /**
     * @Description 异常通知测试
     * @param key
     * @return
     */
    @RequestMapping("/testAfterThrowing.do")  
    public String testAfterThrowing(){  
        throw new NullPointerException();  
    }  
    
    /**
     * @Description 后置最终通知测试
     * @param key
     * @return
     */
    @RequestMapping("/testAfter.do")  
    public String testAfter(){  
    	return "后置最终通知测试"; 
    }  
    
    /**
     * @Description 环绕通知
     * @param key
     * @return
     */
    @RequestMapping("/testAroundService.do")  
    public String testAroundService(){  
        return "环绕通知";  
    }  


}
