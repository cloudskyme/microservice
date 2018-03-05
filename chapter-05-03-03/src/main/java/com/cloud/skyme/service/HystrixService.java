/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    FailTestService.java
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
 *    Create at:   2017年11月28日 上午10:29:33
 *
 *    Revision:
 *
 *    2017年11月28日 上午10:29:33
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.skyme.model.User;
import com.cloud.skyme.service.HystrixService.HystrixClientFallback;

/**
 * @ClassName FailTestService
 * @Description 业务测试，模拟有时成功，有时失败的情况
 * @author zhangfeng
 * @Date 2017年11月28日 上午10:29:33
 * @version 1.0.0
 */
@FeignClient(name = "CLOUD-CLIENT",fallback = HystrixClientFallback.class)
public interface HystrixService {

	/**
	 * @Description 得到用户名
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/service-remote/getName", method = RequestMethod.GET)
	String getName(@RequestParam("name") String name);

	/**
	 * @Description 得到用户对象
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/service-remote/getNameAndAge", method = RequestMethod.GET)
	User getNameAndAge(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	/**
	 * @Description 得到用户对象
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/service-remote/getUser", method = RequestMethod.POST)
	String getUser(@RequestBody User user);

	@Component
	static class HystrixClientFallback implements HystrixService {
		private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

		@Override
		public String getName(String name) {
			LOGGER.info("fail getName(String name)");
			return "fail getName(String name)";
		}

		@Override
		public User getNameAndAge(String name, Integer age) {
			LOGGER.info("fail getNameAndAge(String name, Integer age)");
			User user = new User();
			user.setId(-1L);
			user.setName("default username");
			user.setAge(0);
			return user;
		}

		@Override
		public String getUser(User user) {
			LOGGER.info("fail getUser(User user)");
			return "fail getUser(User user)";
		}

	}

}
