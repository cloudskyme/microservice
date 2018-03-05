/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    UserServiceImpl.java
 *
 *    Description: 用户实现类
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午5:26:15
 *
 *    Revision:
 *
 *    2017年11月8日 下午5:26:15
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户实现类
 * @author zhangfeng
 * @Date 2017年11月8日 下午5:26:15
 * @version 1.0.0
 */
@Service
@Component
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/* (非 Javadoc)
	 * Description:
	 * @see com.cloud.skyme.service.UserService#addUser(java.lang.String)
	 */
	@Override
	public void addUser(String name) {
		logger.info("添加用户 : "+name);
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.cloud.skyme.service.UserService#getUser()
	 */
	@Override
	public String getUser() {
		logger.info("获取用户 : zhangfeng");
		return "zhangfeng";
	}

}
