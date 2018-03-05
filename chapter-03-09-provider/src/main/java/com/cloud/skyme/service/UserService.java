/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    UserService.java
 *
 *    Description: 用户服务接口
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午5:24:37
 *
 *    Revision:
 *
 *    2017年11月8日 下午5:24:37
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

/**
 * @ClassName UserService
 * @Description 用户服务接口
 * @author zhangfeng
 * @Date 2017年11月8日 下午5:24:37
 * @version 1.0.0
 */
public interface UserService {
	
	/**
	 * @Description 添加用户
	 * @param name
	 */
	public void addUser(String name);
	
	/**
	 * @Description 获取用户
	 * @return
	 */
	public String getUser();

}
