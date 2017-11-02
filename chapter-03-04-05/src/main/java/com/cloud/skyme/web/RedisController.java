package com.cloud.skyme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.entity.UserEntity;
import com.cloud.skyme.service.UserService;


/**
 * @ClassName UserController
 * @Description 用户的基本操作控制层
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:04:54
 * @version 1.0.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
	
	private final static Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	@Autowired
	private UserService userService;
    
    @RequestMapping("/add")
    public String save(UserEntity user) {
    	userService.testInsert();
    	return "缓存数据添加";
    }    
    
    
    @RequestMapping("/get")
    public String get() {
    	Long id = (long) 358;
    	for (int i = 0; i < 5; i++) {
    		userService.getUser(id);
		}
    	return "缓存数据获取";
    }
}