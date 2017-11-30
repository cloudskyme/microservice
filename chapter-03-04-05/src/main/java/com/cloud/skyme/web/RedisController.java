package com.cloud.skyme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.cloud.skyme.entity.User;
import com.cloud.skyme.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName UserController
 * @Description 用户的基本操作控制层，用于测试缓存
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:04:54
 * @version 1.0.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	private final static Logger logger = LoggerFactory.getLogger(RedisController.class);

	@Autowired
	UserService userService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@ApiOperation(value = "字符串缓存测试", notes = "字符串缓存测试")
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public void insertString() {
		stringRedisTemplate.opsForValue().set("stringKey", "stringValue");
	}

	@ApiOperation(value = "对象缓存测试", notes = "对象缓存测试")
	@RequestMapping(value = "/string/object", method = RequestMethod.GET)
	public void insertStringObject() {
		User user = new User();
		user.setUserId(1);
		user.setUsername("user1");
		user.setPassword("password1");
		redisTemplate.opsForValue().set("stringKeyObject", user);
	}

	@ApiOperation(value = "获取缓存中的对象", notes = "获取缓存中的对象")
	@RequestMapping(value = "/string/object/get", method = RequestMethod.GET)
	public User getStringObject() {
		User user = (User) redisTemplate.opsForValue().get("stringKeyObject");
		return user;
	}
	
	@ApiOperation(value = "用户插入缓存测试", notes = "用户插入缓存测试")
	@CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.userId")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User insertUser(@RequestBody User user) {
		user.setPassword(user.getPassword());
		userService.insertSelective(user);
		return user;
	}
	
	@ApiOperation(value = "获取用户信息测试", notes = "获取用户信息测试")
	@Cacheable(value = "user")
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer userId) {
		logger.info("从DB中获取数据");
		User user = userService.getUserById(userId);
		return user;
	}
	
	@ApiOperation(value = "更新用户缓存测试", notes = "更新用户缓存测试")
	//#root.caches[0].name:当前被调用方法所使用的Cache, 即"user"
	@CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.userId")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		user.setPassword(user.getPassword());
		userService.updateByPrimaryKeySelective(user);
		return user;
	}
	
	@ApiOperation(value = "删除用户缓存测试", notes = "删除用户缓存测试")
	@CacheEvict(value = "user")
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Integer userId) {
		userService.deleteByPrimaryKey(userId);
}
}