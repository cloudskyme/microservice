/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    UserService.java
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
 *    Create at:   2017年11月6日 下午2:54:04
 *
 *    Revision:
 *
 *    2017年11月6日 下午2:54:04
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import com.cloud.skyme.entity.User;

/**
 * @ClassName UserService
 * @Description 用户操作类
 * @author zhangfeng
 * @Date 2017年11月6日 下午2:54:04
 * @version 1.0.0
 */
public interface UserService {
	int insert(User user);

	int insertSelective(User user);
	
	int updateByPrimaryKeySelective(User user);

	User getUserById(Integer userId);

	User getUserByUsername(String username);

	void deleteByPrimaryKey(Integer userId);
}
