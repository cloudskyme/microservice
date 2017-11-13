/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    UserController.java
 *
 *    Description: 测试dubbox rpc调用
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午5:44:47
 *
 *    Revision:
 *
 *    2017年11月8日 下午5:44:47
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cloud.skyme.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName UserController
 * @Description 测试dubbox rpc调用
 * @author zhangfeng
 * @Date 2017年11月8日 下午5:44:47
 * @version 1.0.0
 */
@RestController
@Api("远程调用测试")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Reference
	private UserService userService;
	
	/**
	 * @Description 添加用户消费
	 * @return
	 */
	@ApiOperation(value = "添加用户接口", notes = "添加用户接口")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser() {
		String user = "zhangfeng";
		userService.addUser(user);
		logger.info("消费addUser方法");
		return "添加用户"+user+"成功";
	}
	
	/**
	 * @Description 获取用户消费
	 * @return
	 */
	@ApiOperation(value = "获取用户接口", notes = "获取用户接口")
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public String getUser() {
		userService.getUser();
		logger.info("消费getUser方法");
		return "获取用户zhangfeng成功";
	}

}
