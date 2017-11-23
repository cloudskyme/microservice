/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    WebController.java
 *
 *    Description: 测试thymeleaf
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 上午9:42:06
 *
 *    Revision:
 *
 *    2017年11月8日 上午9:42:06
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName WebController
 * @Description 测试thymeleaf
 * @author zhangfeng
 * @Date 2017年11月8日 上午9:42:06
 * @version 1.0.0
 */
@Controller  
public class WebController {
	
	/**
	 * @Description 模板显示
	 * @param map
	 * @return
	 */
	@RequestMapping("/thymeleaf")  
    public String helloThymeleaf(Map<String,Object> map){  
       map.put("hello","从模板后台传入并显示");  
       return"/helloSpringBoot";  
    }  

}
