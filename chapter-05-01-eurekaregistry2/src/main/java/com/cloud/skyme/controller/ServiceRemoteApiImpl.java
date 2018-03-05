/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    ServiceRemoteApiImpl.java
 *
 *    Description: 实现依赖的core接口
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月22日 下午5:15:41
 *
 *    Revision:
 *
 *    2017年11月22日 下午5:15:41
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.api.ServiceRemoteApi;
import com.cloud.skyme.model.User;

/**
 * @ClassName ServiceRemoteApiImpl
 * @Description 实现依赖的core接口
 * @author zhangfeng
 * @Date 2017年11月22日 下午5:15:41
 * @version 1.0.0
 */
@RestController
public class ServiceRemoteApiImpl implements ServiceRemoteApi {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceRemoteApiImpl.class);

	@Override
	public String getName(@RequestParam("name") String name) {
		logger.info("chapter-05-01-eurekaregistry "+name);
		return "hello " + name;
	}

	@Override
	public User getNameAndAge(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		try {
			name = URLDecoder.decode(name, "UTF-8");
			logger.info("chapter-05-01-eurekaregistry "+name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new User(name, age);
	}

	@Override
	public String getUser(@RequestBody User user) {
		if (user == null) {
			return "参数为空";
		}
		logger.info("chapter-05-01-eurekaregistry "+user.toString());
		return user.toString();
	}

}
