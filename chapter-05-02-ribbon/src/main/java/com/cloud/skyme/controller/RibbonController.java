/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    RibbonController.java
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
 *    Create at:   2017年11月21日 上午11:51:03
 *
 *    Revision:
 *
 *    2017年11月21日 上午11:51:03
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RibbonController
 * @Description 测试ribbon负载均衡
 * @author zhangfeng
 * @Date 2017年11月21日 上午11:51:03
 * @version 1.0.0
 */
@RestController
public class RibbonController {
	
	@Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/add")
    public String add() {
        return restTemplate.getForEntity("http://CLOUD-CLIENT/add?a=30&b=50", String.class).getBody();
    }

}
