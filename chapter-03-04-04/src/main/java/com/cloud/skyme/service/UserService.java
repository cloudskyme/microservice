/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    UserService.java
 *
 *    Description: 测试事务
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月31日 下午5:55:41
 *
 *    Revision:
 *
 *    2017年10月31日 下午5:55:41
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.skyme.entity.UserEntity;
import com.cloud.skyme.enums.UserSexEnum;
import com.cloud.skyme.mapper.UserMapper;

/**
 * @ClassName UserService
 * @Description 测试事务
 * @author zhangfeng
 * @Date 2017年10月31日 下午5:55:41
 * @version 1.0.0
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * @Description 事务回滚测试
	 */
	@Transactional
	public void testInsert() {
		for (int i = 0; i < 5; i++) {
			UserEntity userEntity = new UserEntity();
			userEntity.setPassWord("password "+i);
			userEntity.setUserName("i"+i);
			userEntity.setUserSex(UserSexEnum.MAN);
			userMapper.insert(userEntity);
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setPassWord("password ");
		userEntity.setUserName("username");
		userEntity.setUserSex(UserSexEnum.MAN);
		userMapper.insert(userEntity);
	}

}
