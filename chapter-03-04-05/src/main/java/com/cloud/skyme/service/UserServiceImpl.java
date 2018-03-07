/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    UserServiceImpl.java
 *
 *    Description: 用户实现
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月6日 下午3:12:24
 *
 *    Revision:
 *
 *    2017年11月6日 下午3:12:24
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.skyme.entity.User;
import com.cloud.skyme.mapper.UserMapper;


/**
 * @ClassName UserServiceImpl
 * @Description 用户实现
 * @author zhangfeng
 * @Date 2017年11月6日 下午3:12:24
 * @version 1.0.0
 */
@Transactional(rollbackFor = RuntimeException.class)
@Service
public class UserServiceImpl implements UserService {

//	@Autowired
	UserMapper userMapper;

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int insertSelective(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteByPrimaryKey(Integer userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

}
