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

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

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
	
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
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
	}
	
	public void getUser(Long id) {
		String key = "usercache_"+id;
		UserEntity userEntity = null;
		ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	userEntity = operations.get(key);
 
        	logger.info("getUser() : 从缓存中获取了  >> " + userEntity.toString());
        }else {
        	// 从DB获取
            userEntity = userMapper.getOne(id);
            // 插入缓存
            operations.set(key, userEntity, 10, TimeUnit.SECONDS);
            logger.info("从DB获取并插入缓存   >> " + userEntity.toString());
        }
        
	}
	
	

}
