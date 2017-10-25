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

/**
 * @ClassName HelloController
 * @Description spring boot web测试
 * @author zhangfeng
 * @Date 2017年10月23日 下午5:33:07
 * @version 1.0.0
 */
@RestController
public class HelloController {

	@RequestMapping("/")
    public String index() {
        return "欢迎使用Spring Boot!";
    }
	
}
