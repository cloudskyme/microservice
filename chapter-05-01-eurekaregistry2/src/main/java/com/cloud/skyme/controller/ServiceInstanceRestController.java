/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    ServiceInstanceRestController.java
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
 *    Create at:   2017年11月21日 上午9:49:44
 *
 *    Revision:
 *
 *    2017年11月21日 上午9:49:44
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ServiceInstanceRestController
 * @Description 服务注册与发现
 * @author zhangfeng
 * @Date 2017年11月21日 上午9:49:44
 * @version 1.0.0
 */
@RestController
public class ServiceInstanceRestController {

	private static final Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@RequestMapping("/")
	public String sayhello() {
		return "hello eureka";
	}

	@GetMapping(value = "/add")
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		Integer r = a + b;
		logger.info("chapter-05-01-eurekaregistry2 /add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}

}
